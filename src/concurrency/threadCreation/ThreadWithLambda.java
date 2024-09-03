package concurrency.threadCreation;

/**
 * <p>
 * Creates a new thread using a lambda (because Runnable is a functional interface!) and prints its name and priority.
 * </p>
 * <p>
 * To create a thread, we must instantiate a thread and pass it a Runnable object.
 * </p>
 * <a href="https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html">Thread API</a>
 * <a href="https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Runnable.html">Runnable API</a>
 *
 * @author BCIT
 * @version 2024
 */
public final class ThreadWithLambda {

    private ThreadWithLambda() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("This thread is named: " + Thread.currentThread().getName());
            System.out.println("This thread has priority level: " + Thread.currentThread().getPriority());
        });

        thread.setName("Hello Threading World!");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
