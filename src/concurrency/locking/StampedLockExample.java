package concurrency.locking;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

final class OptimisticInventory {
    private final StampedLock lock;
    private int items;

    OptimisticInventory() {
        lock = new StampedLock();
    }

    void addItem(final int count) {
        long stamp = lock.writeLock();
        try {
            items += count;
            System.out.println(Thread.currentThread().getName() + " added " + count + " items. Total items: " + items);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public int getItems() {
        long stamp = lock.tryOptimisticRead(); // Optimistic read
        int currentItems = items; // Read the value
        if (!lock.validate(stamp)) { // Check if the read was consistent
            stamp = lock.readLock(); // Upgrade to a read lock
            try {
                currentItems = items;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " read the item count: " + currentItems);
        return currentItems;
    }
}

/**
 * This example uses StampedLock to perform an optimistic read. The read is initially
 * non-blocking, but it validates the read afterward. If the data was modified during
 * the read, the lock is upgraded to a read lock to ensure consistency.
 *<p>
 * Optimistic locking can significantly improve performance in scenarios where writes are
 * rare, as it allows most reads to proceed without any locking overhead.
 *
 * @author BCIT
 * @version 2024
 */
public final class StampedLockExample {

    private StampedLockExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        OptimisticInventory inventory = new OptimisticInventory();

        final int numberOfTasks = 5;
        Runnable readTask = () -> {
            for (int i = 0; i < numberOfTasks; i++) {
                System.out.println(inventory.getItems());
            }
        };

        final int upperBound = 42;
        final int someNumber = new Random().nextInt(upperBound);
        Runnable writeTask = () -> inventory.addItem(someNumber);

        Thread t1 = new Thread(readTask, "Reader-1");
        Thread t2 = new Thread(readTask, "Reader-2");
        Thread t3 = new Thread(writeTask, "Writer-1");

        t1.start();
        t2.start();
        t3.start();
    }
}
