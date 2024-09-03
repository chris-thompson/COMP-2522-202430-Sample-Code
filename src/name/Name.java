package name;

/**
 * Name represents a three-part Name.
 *
 * @author BCIT
 * @version 2024
 */
public final class Name {

    /**
     * Default first name.
     */
    public static final String DEFAULT_FIRST = "Boaty";

    /**
     * Default middle name.
     */
    public static final String DEFAULT_MIDDLE = "B";

    /**
     * Default last name.
     */
    public static final String DEFAULT_LAST = "McBoatface";

    private String first;
    private String middle;
    private String last;

    /**
     * Constructs an object of type Name.
     *
     * @param firstName  a String
     * @param middleName a String
     * @param lastName   a String
     */
    public Name(final String firstName, final String middleName, final String lastName) {

        if (firstName != null && !firstName.trim().isEmpty()) {
            this.first = firstName.trim().substring(0, 1).toUpperCase()
                    + firstName.trim().substring(1).toLowerCase();
        } else {
            this.first = DEFAULT_FIRST;
        }

        if (middleName != null && !middleName.trim().isEmpty()) {
            this.middle = middleName.trim().substring(0, 1).toUpperCase()
                    + middleName.trim().substring(1).toLowerCase();
        } else {
            this.middle = DEFAULT_MIDDLE;
        }

        if (lastName != null && !lastName.trim().isEmpty()) {
            this.last = lastName.trim().substring(0, 1).toUpperCase()
                    + lastName.trim().substring(1).toLowerCase();
        } else {
            this.last = DEFAULT_LAST;
        }
    }

    /**
     * Returns the first name.
     *
     * @return first as a String
     */
    public String getFirst() {
        return first;
    }

    /**
     * Sets the first name.
     *
     * @param first the name to set
     */
    public void setFirst(final String first) {
        if (first != null && !first.trim().isEmpty()) {
            this.first = first.trim().substring(0, 1).toUpperCase()
                    + first.trim().substring(1).toLowerCase();
        }
    }

    /**
     * Returns the middle name.
     *
     * @return middle as a String
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * Sets the middle name.
     *
     * @param middle the middle to set
     */
    public void setMiddle(final String middle) {
        if (!middle.trim().isEmpty()) {
            this.middle = middle.trim().substring(0, 1).toUpperCase()
                    + middle.trim().substring(1).toLowerCase();
        }
    }

    /**
     * Returns the last name.
     *
     * @return last as a String
     */
    public String getLast() {
        return last;
    }

    /**
     * Sets the last name.
     *
     * @param last the last to set
     */
    public void setLast(final String last) {
        if (!last.trim().isEmpty()) {
            this.last = last.trim().substring(0, 1).toUpperCase()
                    + last.trim().substring(1).toLowerCase();
        }
    }

    /**
     * Returns the length of this Name.
     *
     * @return length as an int
     */
    public int getLength() {
        return first.length() + middle.length() + last.length();
    }

    /**
     * Returns this Name as three uppercase initials.
     *
     * @return initials as a String
     */
    public String getInitials() {
        return first.substring(0, 1).toUpperCase()
                + middle.substring(0, 1).toUpperCase()
                + last.substring(0, 1).toUpperCase();
    }

    /**
     * Returns the specified character in this Name.  If the
     * index exceeds the length of the String, '@' is
     * returned instead.  Index must be in the range [0, length() - 1].
     *
     * @param index the nth character to acquire as an int
     * @return index character, or @ if index > length
     */
    public char getCharacter(final int index) {
        if (index >= getLength()) {
            return '@';
        } else {
            String fullName = first + middle + last;
            return fullName.charAt(index);
        }
    }

    /**
     * Returns Name formatted as "LastName, FirstName MiddleName".
     *
     * @return formatted as Last, First Middle
     */
    public String getFormattedName() {
        return last + ", " + first + " " + middle;
    }

    /**
     * Returns true if the specified String is the first name.
     *
     * @param name to compare
     * @return true if the same, else false
     */
    public boolean isFirstName(final String name) {
        return first.equals(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Name{");
        sb.append("first='").append(getFirst()).append('\'');
        sb.append(", middle='").append(getMiddle()).append('\'');
        sb.append(", last='").append(getLast()).append('\'');
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

        Name name = (Name) object;

        if (getFirst() != null) {
            if (!getFirst().equals(name.getFirst())) {
                return false;
            }
        } else {
            if (name.getFirst() != null) {
                return false;
            }
        }
        if (getMiddle() != null) {
            if (!getMiddle().equals(name.getMiddle())) {
                return false;
            }
        } else {
            if (name.getMiddle() != null) {
                return false;
            }
        }
        if (getLast() != null) {
            return getLast().equals(name.getLast());
        }
        return name.getLast() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getFirst() != null) {
            result = getFirst().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getMiddle() != null) {
            result = usefulPrime * result + getMiddle().hashCode();
        } else {
            result = usefulPrime * result;
        }
        if (getLast() != null) {
            result = usefulPrime * result + getLast().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
