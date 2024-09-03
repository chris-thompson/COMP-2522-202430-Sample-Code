package concurrency.threadCoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>We can use the join() method to wait for a thread to finish. That is, we wait for the thread's run method
 * to complete. We can also specify a timeout value for the join() method. If the thread does not finish within
 * the specified timeout, the join() method returns and the program continues.
 * </p>
 * <p>
 * This lets us run tasks in parallel and then safely and correctly aggregate the results in main. Neat!
 * </p>
 *
 * @author BCIT
 * @version 2024
 */
public final class JoiningThreads {

    private JoiningThreads() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        // When I execute the next line of code on my 2024 MacBook Air M3, the program
        // prints 8. What about your laptop?
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);

        List<Integer> inputNumbers = Arrays.asList(1, 10, 100, 1000, 10000, 100000, 1000000);
        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            // thread.setDaemon(true); // How does this change the performance of the program?
            thread.start();
        }

        for (Thread thread : threads) {
            final int oneSecond = 1000;
            try {
                thread.join(oneSecond); // What happens if we change this to a longer time? Or remove the parameter?
            } catch (InterruptedException e) {
                System.out.println("Can you tell me when this line would be printed?");
            }
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    private static final class FactorialThread extends Thread {
        private final long inputNumber;
        private BigInteger result;
        private boolean isFinished;

        FactorialThread(final long inputNumber) {
            this.inputNumber = inputNumber;
            this.result = BigInteger.ZERO;
            this.isFinished = false;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(final long operand) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = operand; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
