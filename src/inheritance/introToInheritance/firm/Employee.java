package inheritance.introToInheritance.firm;

import java.util.Scanner;

/**
 * Represents a general paid employee.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class Employee extends StaffMember {

    private String socialInsuranceNumber;
    private double payRate;

    /**
     * No argument constructor for initializing from a Scanner.
     */
    public Employee() {
    }

    /**
     * Constructor creates an Employee object with the specified information.
     *
     * @param eName       employee name a string
     * @param eAddress    employee address a string
     * @param ePhone      employee phone a string
     * @param socInNumber social insurance number a string
     * @param rate        pay rate a double
     */
    public Employee(final String eName,
                    final String eAddress,
                    final String ePhone,
                    final String socInNumber,
                    final double rate) {
        super(eName, eAddress, ePhone);

        socialInsuranceNumber = socInNumber;
        payRate = rate;
    }

    /**
     * Returns the social insurance number.
     * @return social insurance number as a string
     */
    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    /**
     * Returns the pay rate.
     *
     * @return pay rate as a double
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * Returns the pay for this employee. Same as pay rate.
     *
     * @return Amount this employee is paid as a double
     */
    public double pay() {
        return payRate;
    }

    /**
     * Reads instance data from scanner. Subclasses that add instance data
     * should override to read additional data.
     *
     * @param scan A Scanner constructed to collect the instance data. Each field
     *             must be a token.
     */
    public void readInstanceData(final Scanner scan) {
        super.readInstanceData(scan);
        socialInsuranceNumber = scan.next();
        payRate = Double.parseDouble(scan.next());
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        Employee employee = (Employee) object;

        if (Double.compare(getPayRate(), employee.getPayRate()) != 0) {
            return false;
        }
        return getSocialInsuranceNumber().equals(employee.getSocialInsuranceNumber());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        final int usefulPrime = 31;
        result = usefulPrime * result + getSocialInsuranceNumber().hashCode();
        temp = Double.doubleToLongBits(getPayRate());
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Employee{");
        sb.append("socialInsuranceNumber='").append(getSocialInsuranceNumber()).append('\'');
        sb.append(", payRate=").append(getPayRate());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
