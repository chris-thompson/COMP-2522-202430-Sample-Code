package generics;

/**
 * Demonstrate how to create and use a static generic method.
 *
 * @author BCIT
 * @version 2024
 */
public final class GenericMethodExample {

    private GenericMethodExample() { }

    /**
     * Returns the maximum of the three elements.
     * @param x an  object of type T
     * @param y an  object of type T
     * @param z an  object of type T
     * @param <T> the data type
     * @return the 'maximum' of x, y, and z
     */
    public static <T extends Comparable<T>> T maximum(final T x, final T y, final T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        System.out.printf("Maximum of %d, %d and %d is %d%n%n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f%n%n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("Maximum of %s, %s and %s is %s%n", "pear", "apple", "orange",
                maximum("pear", "apple", "orange"));
        //maximum(3, "hello", 7);
    }
}
