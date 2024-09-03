package concurrency.threadCoordination;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * The BoundedBuffer class uses a Lock (ReentrantLock) to manage access to the shared queue.
 *
 * Two condition variables are created using lock.newCondition():
 *
 * notFull: This condition variable is used by producer threads to wait
 *          until the buffer is not full.
 * notEmpty: This condition variable is used by consumer threads to wait
 *          until the buffer is not empty.
 */
class BoundedBuffer {
    private final Queue<Integer> queue;
    private final int capacity;
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    BoundedBuffer(final int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void produce(final int value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + " waiting, buffer is full.");

                // If the buffer is full, the producer waits on the notFull condition variable.
                notFull.await();
            }

            queue.add(value);
            System.out.println(Thread.currentThread().getName() + " produced " + value);

            // After adding an item to the buffer, the producer signals the notEmpty condition
            // variable to notify waiting consumers that data is available.
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " waiting, buffer is empty.");

                // If the buffer is empty, the consumer waits on the notEmpty condition variable.
                notEmpty.await();
            }

            int value = queue.poll();
            System.out.println(Thread.currentThread().getName() + " consumed " + value);

            // After consuming an item from the buffer, the consumer signals the notFull condition
            // variable to notify waiting producers that space is available in the buffer.
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}

class ConditionalProducer implements Runnable {
    private final BoundedBuffer buffer;

    ConditionalProducer(final BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.produce(value++);
                final int productionTime = 500;
                Thread.sleep(productionTime); // Simulate time taken to produce data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ConditionalConsumer implements Runnable {
    private final BoundedBuffer buffer;

    ConditionalConsumer(final BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                final int consumptionTime = 1000;
                Thread.sleep(consumptionTime); // Simulate time taken to consume data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Demonstrates how to use Condition Variables.
 *<p>
 * Producers wait if the buffer is full and are signaled when space becomes available.
 * Consumers wait if the buffer is empty and are signaled when new data is available.
 *
 * @author BCIT
 * @version 2024
 */
public final class ConditionVariableExample {

    private ConditionVariableExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int bufferCapacity = 5;
        BoundedBuffer buffer = new BoundedBuffer(bufferCapacity);

        Thread producer1 = new Thread(new ConditionalProducer(buffer), "Producer-1");
        Thread producer2 = new Thread(new ConditionalProducer(buffer), "Producer-2");
        Thread consumer1 = new Thread(new ConditionalConsumer(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new ConditionalConsumer(buffer), "Consumer-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
