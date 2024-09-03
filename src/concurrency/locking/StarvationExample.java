package concurrency.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example demonstrates how a lower-priority thread might starve because
 * higher-priority threads keep taking the CPU time or resources.
 *<p>
 * In this example, a shared ReentrantLock is used by three threads. Two threads
 * have high priority, and one has low priority. The low-priority thread might starve
 * if the high-priority threads continuously acquire the lock.
 *<p>
 * Without proper handling (e.g., using a fair lock or adjusting priorities), the
 * low-priority thread will probably starve.
 *
 * @author BCIT
 * @version 2024
 */
class StarvationExample {
    private final Lock lock;

    StarvationExample() {
        lock = new ReentrantLock(true); // Fair lock to reduce starvation
    }

    void performTask() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            lock.lock();
            try {
                System.out.println(threadName + " acquired the lock");
                final int shortSleep = 500;
                // Simulate task execution
                Thread.sleep(shortSleep);
                System.out.println(threadName + " completed the task and released the lock");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        StarvationExample example = new StarvationExample();

        // Create threads with different priorities
        Thread t1 = new Thread(example::performTask, "Thread-1 (Low Priority)");
        Thread t2 = new Thread(example::performTask, "Thread-2 (High Priority)");
        Thread t3 = new Thread(example::performTask, "Thread-3 (High Priority)");

        // Set thread priorities
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
