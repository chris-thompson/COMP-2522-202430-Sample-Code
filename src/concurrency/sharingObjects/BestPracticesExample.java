package concurrency.sharingObjects;

import java.util.concurrent.*;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Producer(final BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            final int iterations = 10;
            for (int i = 0; i < iterations; i++) {
                synchronized (this) {
                    queue.put(i); // Thread-safe, no need for explicit locking
                    System.out.println(Thread.currentThread().getName() + " produced " + i
                            + ". Queue size: " + queue.size());
                }
                final int productionTime = 100;
                Thread.sleep(productionTime); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(final BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    log(queue.take()); // Thread-safe, no need for explicit locking
                }
                final int consumptionTime = 150;
                Thread.sleep(consumptionTime); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void log(final int value) {
        synchronized (System.out) {
            System.out.println(Thread.currentThread().getName() + " consumed " + value
                    + ". Queue size: " + queue.size());
        }
    }
}

/**
 * This example combines several best practices, such as using thread-safe collections,
 * minimizing lock contention, and leveraging high-level concurrency utilities.
 *<p>
 * The BlockingQueue is used for sharing data between producers and consumers. This
 * collection is inherently thread-safe, eliminating the need for manual synchronization.
 *<p>
 * The ExecutorService is used to manage the threads, abstracting away much of the
 * complexity of thread creation and management.
 *<p>
 * By using a BlockingQueue, we avoid explicit locking altogether, which reduces the
 * possibility of lock contention and simplifies the code.
 *<p>
 * The example properly handles InterruptedException by restoring the interrupt status
 * and ensuring that threads can exit gracefully.
 *<p>
 * The use of ExecutorService and thread-safe collections makes the code scalable and
 * easier to maintain.
 *
 * @author BCIT
 * @version 2024
 */
public final class BestPracticesExample {

    private BestPracticesExample() { }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if a Thread explodes
     */
    public static void main(final String[] args) throws InterruptedException {
        final int queueCapacity = 5;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(queueCapacity);

        final int threadPoolSize = 4;
        try (ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize)) {

            executor.submit(new Producer(queue));
            executor.submit(new Producer(queue));
            executor.submit(new Consumer(queue));
            executor.submit(new Consumer(queue));

            executor.shutdown();
            System.out.println(executor.awaitTermination(1, TimeUnit.MINUTES));
        }
    }
}
