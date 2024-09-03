package numbers;

import java.util.Random;

/**
 * Dice demonstrates how to generate random numbers in Java.
 *
 * @author BCIT
 * @version 2024
 */
public final class Dice {

    private Dice() {
        // intentionally empty
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final Random random = new Random();
        final int fourSidedDie = random.nextInt(4) + 1;
        final int sixSidedDie = random.nextInt(6) + 1;
        final int eightSidedDie = random.nextInt(8) + 1;
        final int tenSidedDie = random.nextInt(10) + 1;
        final int twelveSidedDie = random.nextInt(12) + 1;
        final int twentySidedDie = random.nextInt(20) + 1;

        System.out.println("Your 4d rolled a " + fourSidedDie);
        System.out.println("Your 6d rolled a " + sixSidedDie);
        System.out.println("Your 8d rolled a " + eightSidedDie);
        System.out.println("Your 10d rolled a " + tenSidedDie);
        System.out.println("Your 12d rolled a " + twelveSidedDie);
        System.out.println("Your 20d rolled a " + twentySidedDie);
        System.out.println("The sum is " + (fourSidedDie + sixSidedDie
                + eightSidedDie + tenSidedDie
                + twelveSidedDie + twentySidedDie));
    }

}
