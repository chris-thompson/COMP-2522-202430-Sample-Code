package arrays;

import java.text.NumberFormat;

/**
 * Represents a DVD.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class DVD {

    private final String title;
    private final String director;
    private final int year;
    private final double cost;
    private final boolean bluRay;

    /**
     * Constructs a new DVD with the specified information.
     *
     * @param title    a String
     * @param director a String
     * @param year     released
     * @param cost     to purchase
     * @param bluRay   or not bluRay
     */
    public DVD(final String title,
               final String director,
               final int year,
               final double cost,
               final boolean bluRay) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
        this.bluRay = bluRay;
    }

/**
     * Returns this DVD's title.
     *
     * @return this DVD's title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns this DVD's director.
     *
     * @return this DVD's director as a String
     */
    public String getDirector() {
        return director;
    }

    /**
     * Returns this DVD's year.
     *
     * @return this DVD's year as an int
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns this DVD's cost.
     *
     * @return this DVD's cost as a double
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns true if this is a BluRay.
     *
     * @return true if this is a BluRay else false
     */
    public boolean isBluRay() {
        return bluRay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DVD{");
        sb.append("title='").append(getTitle()).append('\'');
        sb.append(", director='").append(getDirector()).append('\'');
        sb.append(", year=").append(getYear());
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        sb.append(", cost=").append(fmt.format(getCost()));
        sb.append(", bluRay=").append(isBluRay());
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

        DVD dvd = (DVD) object;

        if (getYear() != dvd.getYear()) {
            return false;
        }
        if (Double.compare(getCost(), dvd.getCost()) != 0) {
            return false;
        }
        if (isBluRay() != dvd.isBluRay()) {
            return false;
        }
        if (getTitle() != null) {
            if (!getTitle().equals(dvd.getTitle())) {
                return false;
            }
        } else {
            if (dvd.getTitle() != null) {
                return false;
            }
        }
        if (getDirector() != null) {
            return getDirector().equals(dvd.getDirector());
        }
        return dvd.getDirector() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        if (getTitle() != null) {
            result = getTitle().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getDirector() != null) {
            result = usefulPrime * result + getDirector().hashCode();
        } else {
            result = usefulPrime * result;
        }
        result = usefulPrime * result + getYear();
        temp = Double.doubleToLongBits(getCost());
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        if (isBluRay()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
