package concurrency.threadCreation;

/**
 * We can designate a handler for uncaught exceptions in a thread. This prevents a thread from crashing the entire
 * program.
 *
 * @author BCIT
 * @version 2024
 */
public final class ThreadWithMagicExceptionHandler {

    private ThreadWithMagicExceptionHandler() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional RunTime Exception");
        });

        thread.setName("A thread that crashes");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(final Thread thread, final Throwable thrown) {
                System.out.println("A disaster has been averted in " + thread.getName() + ": " + thrown.getMessage());
            }
        });
        thread.start();
    }
}
