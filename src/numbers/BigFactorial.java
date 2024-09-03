package numbers;

import java.math.BigInteger;

/**
 * Demonstrates the use of BigDecimal.
 *
 * @author BCIT
 * @version 2024
 */
public final class BigFactorial {

    private BigFactorial() {

    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int upperBound = 15;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= upperBound; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.println(factorial);
        }
    }
}
