package concurrency.locking;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Inventory {
    private final ReadWriteLock lock;
    private int items;

    Inventory() {
        lock = new ReentrantReadWriteLock();
        items = 0;
    }

    void addItem(final int count) {
        lock.writeLock().lock();
        try {
            items += count;
            System.out.println(Thread.currentThread().getName() + " added " + count + " items. Total items: " + items);
        } finally {
            lock.writeLock().unlock();
        }
    }

    int getItems() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read the item count: " + items);
            return items;
        } finally {
            lock.readLock().unlock();
        }
    }
}

/**
 * This example demonstrates how to use ReadWriteLock to optimize performance in
 * a read-heavy scenario. Multiple threads can read the item count concurrently,
 * but only one thread can modify the count at a time.
 *<p>
 * ReadWriteLock can improve throughput in scenarios where reads vastly outnumber
 * writes by reducing contention between threads.
 *
 * @author BCIT
 * @version 2024
 */
public final class ReadWriteLockExample {

    private ReadWriteLockExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Inventory inventory = new Inventory();

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
