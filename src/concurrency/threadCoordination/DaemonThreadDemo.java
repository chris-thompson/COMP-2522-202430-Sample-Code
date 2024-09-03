package concurrency.threadCoordination;

import java.math.BigInteger;

/**
 * A Daemon (pronounced DAY-mon) thread is a thread that runs in the background and does not prevent the JVM from
 * exiting when the program finishes. If the JVM has only daemon threads remaining when we reach the end of the
 * main method, the program stops the threads and ends. Kaput!
 *
 * @author BCIT
 * @version 2024
 */
public final class DaemonThreadDemo {

    private DaemonThreadDemo() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2024"), new BigInteger("9999999")));
        // thread.setDaemon(true); // What happens when we uncomment this line of code?
        thread.start();
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
