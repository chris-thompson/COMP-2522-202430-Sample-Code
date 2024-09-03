package exceptions;

/**
 * Demonstrates exception propagation.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class ExceptionPropagation {

    /**
     * Invokes level2(), which invokes level3().  The level3() method
     * throws an exception and doesn't catch it.  The exception gets
     * thrown at level2(), which does not catch it, so it propagates
     * all the way to level1(), where it does get caught.  Neat!
     */
    public void level1() {
        System.out.println("Level 1 beginning.");

        try {
            level2();
        } catch (ArithmeticException problem) {
            System.out.println("The exception message is: "
                    + problem.getMessage());
            System.out.println("The call stack trace:");
            problem.printStackTrace();
        }

        System.out.println("Level 1 ending.");
    }

    /**
     * Invokes level3(), which will throw an exception.  The exception
     * gets thrown at level2(), which does not catch it, so it gets
     * thrown to level1().
     */
    public void level2() {
        System.out.println("Level 2 beginning.");
        level3();
        System.out.println("Level 2 ending.");
    }

    /**
     * Performs a calculation that produces an exception.  The
     * exception is not caught in this method, so it propagates up.
     */
    public void level3() {
        final int numerator = 10;
        final int denominator = 0;

        System.out.println("Level 3 beginning.");
        System.out.println("10 / 3 = " + numerator / denominator);
        System.out.println("Level 3 ending.");
    }
}
