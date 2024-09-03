package concurrency.sharingObjects;

/**
 * Demonstrates how to use ThreadLocal.
 * <p>
 * ThreadLocal allows each thread to have its own copy of a variable,
 * preventing interference between threads!
 *
 * @author BCIT
 * @version 2024
 */
public final class ThreadLocalExample {

    private static final ThreadLocal<Integer> THREAD_LOCAL_COUNT = ThreadLocal.withInitial(() -> 0);

    private ThreadLocalExample() { }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        Runnable task = () -> {
            int count = THREAD_LOCAL_COUNT.get();
            count++;
            THREAD_LOCAL_COUNT.set(count);
            System.out.println(Thread.currentThread().getName() + ": " + THREAD_LOCAL_COUNT.get());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
