package concurrency.threadCoordination;

import java.math.BigInteger;

/**
 * Let's see another example of how joining can help us parallelize and then aggregate results for
 * complex calculations.
 *
 * @author BCIT
 * @version 2024
 */
public final class JoiningDemo {

    private JoiningDemo() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        JoiningDemo joiningDemo = new JoiningDemo();
        BigInteger base1 = new BigInteger("2");
        BigInteger power1 = new BigInteger("1000");
        BigInteger base2 = new BigInteger("2");
        BigInteger power2 = new BigInteger("2000");

        BigInteger result = joiningDemo.calculateResult(base1, power1, base2, power2);
        System.out.println("Result is: " + result);
    }

    private BigInteger calculateResult(final BigInteger base1,
                                      final BigInteger power1,
                                      final BigInteger base2,
                                      final BigInteger power2) {
        BigInteger result;
        ExponentCalculator thread1 = new ExponentCalculator(base1, power1);
        ExponentCalculator thread2 = new ExponentCalculator(base2, power2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Can you tell me when this line would be printed?");
        }

        result = thread1.getResult().add(thread2.getResult());
        return result;
    }

    private static final class ExponentCalculator extends Thread {
        private BigInteger result;
        private final BigInteger base;
        private final BigInteger power;

        ExponentCalculator(final BigInteger base, final BigInteger power) {
            this.result = BigInteger.ONE;
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
