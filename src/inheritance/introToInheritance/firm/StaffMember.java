package inheritance.introToInheritance.firm;

import java.util.Scanner;

/**
 * Represents an abstract staff member. We do not know how to pay the staff
 * member, so subclasses will have to provide the pay method.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public abstract class StaffMember {

    private String name;
    private String address;
    private String phone;

    /**
     * No argument constructor. For creating components to be initialized from a
     * Scanner
     */
    public StaffMember() {
    }

    /**
     * Constructs a new StaffMember object using the specified information.
     *
     * @param eName    employee name
     * @param eAddress employee address
     * @param ePhone   employee phone
     */
    public StaffMember(final String eName, final String eAddress, final String ePhone) {
        name = eName;
        address = eAddress;
        phone = ePhone;
    }

    /**
     * Returns the name of the staff member.
     * @return name of staff member as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the staff member.
     * @return address of staff member as a String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the phone number of the staff member.
     * @return phone number of staff member as a String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Derived classes must define the pay method for each type of employee.
     *
     * @return amount staff member is paid
     */
    public abstract double pay();

    /**
     * Reads instance data from scanner. Subclasses that add instance data
     * should override to read additional data.
     *
     * @param scan Should be positioned before the instance data. Each field
     *             should be a token.
     */
    public void readInstanceData(final Scanner scan) {
        name = scan.next();
        address = scan.next();
        phone = scan.next();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        StaffMember that = (StaffMember) object;

        if (!getName().equals(that.getName())) {
            return false;
        }
        if (!getAddress().equals(that.getAddress())) {
            return false;
        }
        return getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        final int usefulPrime = 31;
        result = usefulPrime * result + getAddress().hashCode();
        result = usefulPrime * result + getPhone().hashCode();
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("StaffMember{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", address='").append(getAddress()).append('\'');
        sb.append(", phone='").append(getPhone()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
