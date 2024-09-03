package inheritance.introToInheritance.firm;

/**
 * Salesperson.
 *
 * @author BCIT
 * @version 2-2-
 */
public class Salesperson implements Comparable<Salesperson> {

    private final String firstName;
    private final String lastName;
    private final int totalSales;

    /**
     * Constructs an object of type Salesperson.
     *
     * @param first name as a String
     * @param last  name as a String
     * @param sales made last week an int
     */
    public Salesperson(final String first, final String last, final int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    /**
     * Returns the Salesperson's first name.
     *
     * @return firstname as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the Salesperson's last name.
     *
     * @return lastName as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the Salesperson's total sales rounded to the dollar.
     *
     * @return sales as an int
     */
    public int getSales() {
        return totalSales;
    }


    /**
     * Compares this Salesperson to the Salesperson passed as a parameter. The
     * salesperson who sells more comes first.
     *
     * @param other Salesperson
     * @return 0 if the sales are the same, a negative number if this salesperson
     *        sold less than other, a positive number if this salesperson sold
     *        more than the other.
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(final Salesperson other) {
        return getSales() - other.getSales();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Salesperson that = (Salesperson) object;

        if (getSales() != that.getSales()) {
            return false;
        }
        if (getFirstName() != null) {
            if (!getFirstName().equals(that.getFirstName())) {
                return false;
            }
        } else {
            if (that.getFirstName() != null) {
                return false;
            }
        }
        if (getLastName() != null) {
            return getLastName().equals(that.getLastName());
        }
        return that.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getFirstName() != null) {
            result = getFirstName().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getLastName() != null) {
            result = usefulPrime * result + getLastName().hashCode();
        } else {
            result = usefulPrime * result;
        }
        result = usefulPrime * result + getSales();
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Salesperson{");
        sb.append("firstName='").append(getFirstName()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", totalSales=").append(getSales());
        sb.append(", sales=").append(getSales());
        sb.append('}');
        return sb.toString();
    }
}
