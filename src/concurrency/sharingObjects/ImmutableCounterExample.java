package concurrency.sharingObjects;

import java.util.concurrent.atomic.AtomicReference;

/*
 * The ImmutableCounter class is immutable, meaning that once an instance
 * is created, its state (the count field) cannot change.
 *
 * We say that the  ImmutableCounter class itself is thread-safe because
 * its state cannot be modified after it is created.
 */
final class ImmutableCounter {
    private final int count;

    ImmutableCounter(final int count) {
        this.count = count;
    }

    ImmutableCounter increment() {
        return new ImmutableCounter(count + 1);
    }

    int getCount() {
        return count;
    }
}

/**
 * Demonstrates an idiom for using an immutable object with Threads.
 *
 * @author BCIT
 * @version 2024
 */
public final class ImmutableCounterExample {

    private ImmutableCounterExample() { }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if a Thread explodes
     */
    public static void main(final String[] args) throws InterruptedException {

        // We use AtomicReference<ImmutableCounter> to hold the reference to the current
        // ImmutableCounter object. This allows us to safely update the reference in a
        // multithreaded environment.
        AtomicReference<ImmutableCounter> counter = new AtomicReference<>(new ImmutableCounter(0));

        final int upperBound = 1000;
        Runnable task = () -> {
            for (int i = 0; i < upperBound; i++) {
                // The updateAndGet() method of AtomicReference atomically updates the
                // ImmutableCounter by applying the increment() method. This ensures that
                // the reference to the ImmutableCounter is updated correctly, even when
                // multiple threads are trying to update it concurrently
                counter.updateAndGet(ImmutableCounter::increment);
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

        System.out.println("Final count (expected 2000): " + counter.get().getCount());
    }
}
