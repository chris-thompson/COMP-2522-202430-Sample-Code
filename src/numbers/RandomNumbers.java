package numbers;

import java.util.Random;

/**
 * Demonstrates the creation of pseudo-random numbers using the Random class.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class RandomNumbers {

    private RandomNumbers() {
        // intentionally empty
    }

    /**
     * Generates random numbers in various ranges.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // These are just sample numbers, IRL use semantically robust identifiers
        final int ten = 10;
        final int fifteen = 15;
        final int twenty = 20;
        final int dieMax = 6;

        final Random generator = new Random();

        int randomInteger = generator.nextInt();
        System.out.println("A random integer: " + randomInteger);

        randomInteger = generator.nextInt(ten);
        System.out.println("From 0 to 9: " + randomInteger);

        randomInteger = generator.nextInt(ten) + 1;
        System.out.println("From 1 to 10: " + randomInteger);

        randomInteger = generator.nextInt(fifteen) + twenty;
        System.out.println("From 20 to 34: " + randomInteger);

        randomInteger = generator.nextInt(twenty) - ten;
        System.out.println("From -10 to 9: " + randomInteger);

        float randomFloat = generator.nextFloat();
        System.out.println("A random float (between 0-1): " + randomFloat);

        randomFloat = generator.nextFloat() * dieMax; // 0.0 to 5.999999
        randomInteger = (int) randomFloat + 1;
        System.out.println("From 1 to 6: " + randomInteger);
    }
}
