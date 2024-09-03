package concurrency.locking;

/**
 * Demonstrates deadlock.
 * <p>
 * Deadlock Scenario: Neither thread can proceed because each is holding a lock
 * that the other needs. This situation leads to a deadlock, where both threads
 * are stuck indefinitely.
 * <p>
 * Thread 1 starts and acquires lock1. It then tries to acquire lock2 after a short delay.
 * Thread 2 starts and acquires lock2. It then tries to acquire lock1 after a short delay.
 * Since both threads are holding one lock and waiting for the other to release its lock,
 * a circular wait condition is created, resulting in a deadlock.
 *
 * @author BCIT
 * @version 2024
 */
public final class DeadlockExample {

    private static final int SLEEP_BUSY = 50;
    private final Object lock1;
    private final Object lock2;

    DeadlockExample() {
        lock1 = new Object();
        lock2 = new Object();
    }

    /**
     * Tries to lock lock1 then lock2.
     */
    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Holding lock1...");
            try {
                Thread.sleep(SLEEP_BUSY); // Simulate some work with lock1
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ": Waiting for lock2...");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": Holding lock1 and lock2...");
            }
        }
    }

    /**
     * Tries to lock lock2 then lock1.
     */
    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + ": Holding lock2...");
            try {
                Thread.sleep(SLEEP_BUSY); // Simulate some work with lock2
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ": Waiting for lock1...");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": Holding lock2 and lock1...");
            }
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(example::method1, "Thread-1");
        Thread t2 = new Thread(example::method2, "Thread-2");

        t1.start();
        t2.start();
    }
}
