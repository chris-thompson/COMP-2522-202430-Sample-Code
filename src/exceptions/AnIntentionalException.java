package exceptions;

/**
 * Demonstrates an uncaught exception.
 *
 * @author BCIT
 * @version 2024
 */
public final class AnIntentionalException {

    private AnIntentionalException() {

    }

    /**
     * Deliberately divides by zero to produce an exception.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final int numerator = 100;
        final int denominator = 0;

        System.out.println(numerator / denominator);

        System.out.println("Will this be printed?");
    }
}
