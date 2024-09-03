package innerClasses;

/**
 * Check out this super simple calculator. This contains lambda!
 *
 * @author BCIT
 * @version 2024
 */
public class Calculator {

    /**
     * An integer operation accepts two integers and returns an integer.
     */
    public interface IntegerMath {

        /**
         * Performs an operation.
         * @param first an integer
         * @param second an integer
         * @return result of the operation
         */
        int operation(int first, int second);
    }

    /**
     * Performs a binary operation and returns the result.
     * @param first an int
     * @param second an int
     * @param operation an instance of IntegerMath
     * @return result as an integer
     */
    public int operateBinary(final int first, final int second, final IntegerMath operation) {
        return operation.operation(first, second);
    }

    /**
     * Drives the program. Of course, you will not use magic numbers...
     *
     * @param args unused. But notice we can use the ... that means variable argument list.
     */
    public static void main(final String... args) {

        Calculator myApp = new Calculator();
        IntegerMath addition = Integer::sum; // This is a method reference. Java borrowed this syntax from C++.
        IntegerMath subtraction = (a, b) -> a - b; // This is a lambda! This is a form of anonymous class.
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
    }
}
