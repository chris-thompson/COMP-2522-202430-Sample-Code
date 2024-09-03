package arrays;

import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Represents a collection of DVDs.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class DVDCollection {

    /**
     * Default collection size.
     */
    public static final int DEFAULT_SIZE = 100;

    private DVD[] collection;
    private int count;
    private double totalCost;

    /**
     * Constructs a new empty DVDCollection of default size.
     */
    public DVDCollection() {
        collection = new DVD[DEFAULT_SIZE];
        count = 0;
        totalCost = 0.0;
    }

    /**
     * Adds a new DVD to this DVDCollection. Creates a new DVD using the
     * specified information and adds it.  Increases the size of the
     * collection array if necessary.
     *
     * @param title    a String
     * @param director a String
     * @param year     an int
     * @param cost     a double
     * @param bluRay   a boolean
     */
    public void addDVD(final String title,
                       final String director,
                       final int year,
                       final double cost,
                       final boolean bluRay) {
        if (count == collection.length) {
            increaseSize();
        }
        collection[count] = new DVD(title, director, year, cost, bluRay);
        totalCost += cost;
        count++;
    }

    /**
     * Adds the specified DVD to this collection.
     *
     * @param dvd the DVD to add
     */
    public void addDVD(final DVD dvd) {
        if (count == collection.length) {
            increaseSize();
        }
        collection[count] = dvd;
        count++;
    }

    /**
     * Returns the number of DVDs in this collection.
     *
     * @return count as an int
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the total cost of the DVDs in this collection.
     *
     * @return totalCost as a double
     */
    public double getTotalCost() {
        return totalCost;
    }

    /*
     * Increases the capacity of the collection by creating a
     * larger array and copying the existing collection into it.
     */
    private void increaseSize() {
        final DVD[] temp = new DVD[collection.length * 2];
        System.arraycopy(collection, 0, temp, 0, collection.length);
        collection = temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("DVDCollection{");
        if (collection == null) {
            sb.append("collection=").append("null");
        } else {
            sb.append("collection=").append(Arrays.asList(collection));
        }
        sb.append(", count=").append(getCount());
        final NumberFormat fmt = NumberFormat.getCurrencyInstance();
        sb.append(", totalCost=").append(fmt.format(getTotalCost()));
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

        DVDCollection that = (DVDCollection) object;

        if (getCount() != that.getCount()) {
            return false;
        }
        if (Double.compare(getTotalCost(), that.getTotalCost()) != 0) {
            return false;
        }
        return Arrays.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.hashCode(collection);
        final int usefulPrime = 31;
        result = usefulPrime * result + getCount();
        temp = Double.doubleToLongBits(getTotalCost());
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
