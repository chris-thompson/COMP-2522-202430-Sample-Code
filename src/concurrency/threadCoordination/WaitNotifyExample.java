package concurrency.threadCoordination;

import java.util.LinkedList;
import java.util.Queue;

/*
 * The Buffer class manages a shared queue with a fixed capacity. Producers
 * add items to the queue, and consumers remove items from the queue.
 */
class Buffer {
    private final Queue<Integer> queue;
    private final int capacity;

    Buffer(final int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    /*
     * Synchronized to ensure that only one thread can modify the buffer at a time.
     *
     * Uses a guard block. If the buffer is full, the producer thread will call wait()
     * and release the lock, allowing other threads (like consumers) to acquire the lock.
     */
    synchronized void produce(final int value) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait(); // Wait until space is available
        }

        queue.add(value);
        System.out.println("Produced " + value);

        /*
         * After adding an item to the buffer, the thread calls notifyAll() to wake up
         * all waiting threads, signaling that the condition consumers are waiting for
         * might now be true, i.e., data is available to consume.
         */
        notifyAll();
    }

    /*
     * Synchronized to ensure that only one thread can modify the buffer at a time.
     *
     * Uses a guard block. If the buffer is empty, the consumer thread will call wait()
     * and release the lock, allowing other threads (like producers) to acquire the lock.
     */
    synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait(); // Wait until data is available
        }

        int value = queue.poll();
        System.out.println("Consumed " + value);

        /*
         * After removing an item from the buffer, the thread calls notifyAll() to wake up
         * all waiting threads, signaling that the condition producers are waiting for
         * might now be true, i.e., space is available.
         */
        notifyAll(); // Notify producers that space is available
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    Producer(final Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.produce(value++);
                final int halfSecond = 500;
                Thread.sleep(halfSecond); // Simulate time taken to produce data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;

    Consumer(final Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                final int oneSecond = 1000;
                Thread.sleep(oneSecond); // Simulate time taken to consume data yum
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Demonstrates the Producer-Consumer problem.
 *<p>
 * After a producer adds an item to the
 * queue, it calls notifyAll() to wake up any waiting consumer threads, signaling that
 * new data is available.
 *<p>
 * After a consumer removes an item from the queue, it calls notifyAll() to wake up any
 * waiting producer threads, signaling that space is available in the buffer.
 *
 * @author BCIT
 * @version 2024
 */
public final class WaitNotifyExample {

    private WaitNotifyExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int bufferCapacity = 5;
        Buffer buffer = new Buffer(bufferCapacity);

        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
        Thread producer2 = new Thread(new Producer(buffer), "Producer-2");
        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(buffer), "Consumer-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
