package inheritance.introToInheritance.firm;

/**
 * Represents an employee that gets paid by the hour.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class Hourly extends Employee {

    private int hoursWorked;

    /**
     * No argument constructor for initializing from a Scanner.
     */
    public Hourly() {
    }

    /**
     * Constructs a new Hourly object using the specified information.
     *
     * @param eName       employee name a string
     * @param eAddress    employee address a string
     * @param ePhone      employee phone a string
     * @param socInNumber social insurance number a string
     * @param rate        hourly pay rate a double
     */
    public Hourly(final String eName,
                  final String eAddress,
                  final String ePhone,
                  final String socInNumber,
                  final double rate) {
        super(eName, eAddress, ePhone, socInNumber, rate);
    }

    /**
     * Returns the number of hours worked by this employee.
     * @return hours worked as an int
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Adds the specified number of hours to this employee's accumulated hours.
     *
     * @param moreHours additional hours worked as an int
     */
    public void addHours(final int moreHours) {
        hoursWorked += moreHours;
    }

    /**
     * Computes and returns the pay for this hourly employee.
     *
     * @return pay for the pay period as a double
     */
    public double pay() {
        double payment = getPayRate() * getHoursWorked();
        hoursWorked = 0;
        return payment;
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

        Hourly hourly = (Hourly) object;

        return getHoursWorked() == hourly.getHoursWorked();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        result = usefulPrime * result + getHoursWorked();
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Hourly{");
        sb.append("hoursWorked=").append(getHoursWorked());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        sb.append('}');
        return sb.toString();
    }
}
