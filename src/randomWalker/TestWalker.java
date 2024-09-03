package randomWalker;

import java.util.Scanner;

/**
 * TestWalker.
 *
 * @author BCIT
 * @version 2024
 */
public final class TestWalker {

    private TestWalker() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final int maximumSteps = 10;
        final int boundary = 5;
        RandomWalker testWalker = new RandomWalker(maximumSteps, boundary);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the maximum number of steps");
        int userMax = scan.nextInt();
        System.out.println("Please enter the boundary size");
        int userBoundary = scan.nextInt();
        RandomWalker userWalker = new RandomWalker(userMax, userBoundary);

        System.out.println(testWalker);
        final int steps = 5;
        for (int i = 0; i < steps; ++i) {
            testWalker.takeStep();
            System.out.println(testWalker);
            System.out.println("Max distance = "
                    + testWalker.getMaximumDistance());
        }

        System.out.println(userWalker);
        for (int i = 0; i < steps; ++i) {
            userWalker.takeStep();
            System.out.println("Max distance = "
                    + userWalker.getMaximumDistance());
            System.out.println(userWalker);
        }

        final int moreSteps = 200;
        final int anotherBoundary = 10;
        RandomWalker anotherWalker =
                new RandomWalker(moreSteps, anotherBoundary);
        System.out.println(anotherWalker);
        anotherWalker.walk();
        System.out.println(anotherWalker);
        System.out.println("Max distance = "
                + anotherWalker.getMaximumDistance());
    }
}
