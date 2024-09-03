package concurrency.threadCoordination;

/**
 * The main thread cannot finish, i.e., the program cannot end, until the blocking thread finishes.
 *
 * @author BCIT
 * @version 2024
 */
public final class BlockingSolution {

    private BlockingSolution() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        System.out.println("The main thread is done and is ready to terminate.");
        thread.interrupt(); // we can send an interrupt signal to a thread that is currently blocking due to a method
                            // that throws an InterruptedException when it gets interrupted
    }

    private static final class BlockingTask implements Runnable {

        private static final int ONE_MINUTE = 36000;

        @Override
        public void run() {
            System.out.println("This BlockingTask is running and will block for 1 minute...");
            try {
                Thread.sleep(ONE_MINUTE);
            } catch (InterruptedException e) {
                System.out.println("This BlockingTask was interrupted.");
            }
        }
    }
}
