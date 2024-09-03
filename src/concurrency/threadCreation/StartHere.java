package concurrency.threadCreation;

/**
 * <p>
 * Creates a new thread and prints its java101.name and priority.
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
public final class StartHere {

    private StartHere() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This thread is named: " + Thread.currentThread().getName());
                System.out.println("This thread has priority level: " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("Hello Threading World!");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

        System.out.println("A thread can have minimum priority: " + Thread.MIN_PRIORITY);
        System.out.println("A thread can have normal priority: " + Thread.NORM_PRIORITY);
        System.out.println("A thread can have maximum priority: " + Thread.MAX_PRIORITY);
    }
}
