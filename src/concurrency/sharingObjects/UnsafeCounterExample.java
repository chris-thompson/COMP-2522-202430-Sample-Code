package concurrency.sharingObjects;

class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

/**
 * Demonstrates the perils of sharing objects.
 *
 * @author BCIT
 * @version 2024
 */
public final class UnsafeCounterExample {

    private UnsafeCounterExample() { }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if a Thread explodes
     */
    public static void main(final String[] args) throws InterruptedException {
        UnsafeCounter counter = new UnsafeCounter();

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

        // Wait for the task threads to finish aka return aka join us again
        // before we continue the main thread
        t1.join();
        t2.join();

        System.out.println("Final count (expected 2000): " + counter.getCount());
    }
}
