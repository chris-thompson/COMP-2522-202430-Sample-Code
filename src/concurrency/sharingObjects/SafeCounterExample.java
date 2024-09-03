package concurrency.sharingObjects;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

/**
 * Synchronize access to sharing objects.
 *
 * @author BCIT
 * @version 2024
 */
public final class SafeCounterExample {

    private SafeCounterExample() { }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if a Thread explodes.
     */
    public static void main(final String[] args) throws InterruptedException {
        Counter counter = new Counter();

        final int upperBound = 1000;
        Runnable task = () -> {
            for (int i = 0; i < upperBound; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count (expected 2000): " + counter.getCount());
    }
}
