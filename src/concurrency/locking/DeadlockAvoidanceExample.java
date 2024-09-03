package concurrency.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates how to avoid a deadlock.
 * <p>
 * This looks complicated, but don't be fooled, it's not!
 * <p>
 * The tryLock() method attempts to acquire the lock, but if it cannot
 * acquire the lock within the specified time, it gives up and releases
 * any locks it has already acquired. This prevents the deadlock by
 * ensuring that threads don’t wait indefinitely.
 *<p>
 * Depending on the timing, one thread may fail to acquire the second lock
 * and will release the first lock, avoiding the deadlock situation.
 *
 * @author BCIT
 * @version 2024
 */
public final class DeadlockAvoidanceExample {

    private static final int SHORT_BUSY = 50;
    private static final int LONG_BUSY = 100;

    private final Lock lock1;
    private final Lock lock2;

    private DeadlockAvoidanceExample() {
        lock1 = new ReentrantLock();
        lock2 = new ReentrantLock();
    }

    private void method1() {
        try {
            if (lock1.tryLock(LONG_BUSY, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + ": Holding lock1");
                try {
                    Thread.sleep(SHORT_BUSY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (lock2.tryLock(LONG_BUSY, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Holding lock1 and lock2");
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Could not acquire lock2, releasing lock1");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock1.unlock();
        }
    }

    private void method2() {
        try {
            if (lock2.tryLock(LONG_BUSY, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + ": Holding lock2");
                try {
                    Thread.sleep(SHORT_BUSY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Holding lock2 and lock1");
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Could not acquire lock1, releasing lock2");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock2.unlock();
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        DeadlockAvoidanceExample example = new DeadlockAvoidanceExample();

        Thread t1 = new Thread(example::method1, "Thread-1");
        Thread t2 = new Thread(example::method2, "Thread-2");

        t1.start();
        t2.start();
    }
}
