package concurrency.threadCoordination;

import java.math.BigInteger;

/**
 * <p>
 * How can we use this in a non-trivial way? What if we have a huge computation that's preventing anything else from
 * happening? We can interrupt the thread and end the program gracefully.
 * </p>
 * <p>
 * Important: if a method does not respond to the interrupt signal by throwing an InterruptException, i.e.,
 * Thread.sleep(), then we have to check the interrupted status of the thread manually.
 *</p>
 *
 * @author BCIT
 * @version 2024
 */
public final class Interrupt {

    private Interrupt() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2024"), new BigInteger("9999999")));
        thread.start();
        final int millisecond = 1;
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            System.out.println("This thread's sleep was interrupted!");
        }
        // thread.interrupt(); // What happens when we uncomment this line of code?
    }

    private static class LongComputationTask implements Runnable {
        private final BigInteger base;
        private final BigInteger exponent;

        LongComputationTask(final BigInteger base, final BigInteger exponent) {
            this.base = base;
            this.exponent = exponent;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + exponent + " = " + calculate());
        }

        private BigInteger calculate() {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(exponent) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Calculation in progress, iteration " + i + " of " + exponent);
                    System.out.println("This computation thread has been interrupted, returning BigInteger.ZERO...");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
