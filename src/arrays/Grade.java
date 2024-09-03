package arrays;

/**
 * Represents a school grade.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Grade {

    private final String name;
    private final int lowerBound;

    /**
     * Constructs a Grade object with the specified grade name and numeric lower
     * bound.
     *
     * @param grade  a String
     * @param cutoff an int
     */
    public Grade(final String grade, final int cutoff) {
        name = grade;
        lowerBound = cutoff;
    }

    /**
     * Gets (accesses) the Grade name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets (accesses) the Grade lower bound.
     *
     * @return lowerBound as an int
     */
    public int getLowerBound() {
        return lowerBound;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Grade{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", lowerBound=").append(getLowerBound());
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

        Grade grade = (Grade) object;

        if (getLowerBound() != grade.getLowerBound()) {
            return false;
        }
        if (getName() != null) {
            return getName().equals(grade.getName());
        }
        return grade.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getName() != null) {
            result = getName().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        result = usefulPrime * result + getLowerBound();
        return result;
    }
}
