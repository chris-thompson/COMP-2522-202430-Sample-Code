package students;

/**
 * Represents a BCIT student.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Student {

    private final String firstName;
    private final String lastName;
    private final Address homeAddress;
    private final Address schoolAddress;

    /**
     * Constructs a Student object that contains the specified values.
     *
     * @param firstName a String representing the first.name
     * @param lastName a String representing the last name
     * @param homeAddress an Address object containing the home address
     * @param schoolAddress an Address object containing the school address
     */
    public Student(final String firstName,
                   final String lastName,
                   final Address homeAddress,
                   final Address schoolAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.schoolAddress = schoolAddress;
    }

    /**
     * Returns the first name of the Student as a string.
     * @return firstName as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Student as a string.
     * @return lastName as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the home address of the Student as an Address object.
     * @return homeAddress as an Address
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * Returns the school address of the Student as an Address object.
     * @return schoolAddress as an Address
     */
    public Address getSchoolAddress() {
        return schoolAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Student{");
        sb.append("firstName='").append(getFirstName()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", homeAddress=").append(getHomeAddress());
        sb.append(", schoolAddress=").append(getSchoolAddress());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Student student = (Student) object;

        if (getFirstName() != null) {
            if (!getFirstName().equals(student.getFirstName())) {
                return false;
            }
        } else {
            if (student.getFirstName() != null) {
                return false;
            }
        }
        if (getLastName() != null) {
            if (!getLastName().equals(student.getLastName())) {
                return false;
            }
        } else {
            if (student.getLastName() != null) {
                return false;
            }
        }
        if (getHomeAddress() != null) {
            if (!getHomeAddress().equals(student.getHomeAddress())) {
                return false;
            }
        } else {
            if (student.getHomeAddress() != null) {
                return false;
            }
        }
        if (getSchoolAddress() != null) {
            return getSchoolAddress().equals(student.getSchoolAddress());
        }
        return student.getSchoolAddress() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getFirstName() != null) {
            result = getFirstName().hashCode();
        } else {
            result = 0;
        }
        final int helpfulPrime = 31;
        if (getLastName() != null) {
            result = helpfulPrime * result + getLastName().hashCode();
        }  else {
            result = helpfulPrime * result;
        }
        if (getHomeAddress() != null) {
            result = helpfulPrime * result + getHomeAddress().hashCode();
        } else {
            result = helpfulPrime * result;
        }
        if (getSchoolAddress() != null) {
            result = helpfulPrime * result + getSchoolAddress().hashCode();
        } else {
            result = helpfulPrime * result;
        }
        return result;
    }
}
