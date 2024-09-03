package concurrency.sharingObjects;

class Task implements Runnable {
    private volatile boolean running;

    Task() {
        running = true;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Task is running...");
            try {
                final int oneSecond = 1000;
                Thread.sleep(oneSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Task has stopped.");
    }

    public void stop() {
        running = false; // This change will be visible to the running thread immediately
    }
}

/**
 * Demonstrates how to use the volatile keyword.
 *<p>
 * The running flag is marked as volatile, ensuring that when one thread (the main thread)
 * changes its value, the change is immediately visible to the other thread (taskThread).
 *<p>
 *  Thread Visibility: Without volatile, there’s no guarantee that the running variable’s
 *  change in the stop() method would be visible to the thread running the run() method
 *  immediately, and the task might not stop as expected.
 *<p>
 * 1. The task prints “Task is running…” every second.
 * 2. After 3 seconds, the main thread requests the task to stop by setting running to false.
 * 3. The task thread detects this change and exits the loop, printing “Task has stopped.”
 *
 * @author BCIT
 * @version 2024
 */
public final class VolatileExample {

    private VolatileExample() { }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if an Exception explodes.
     */
    public static void main(final String[] args) throws InterruptedException {
        Task task = new Task();
        Thread taskThread = new Thread(task);
        taskThread.start();

        final int threeSeconds = 3000;
        Thread.sleep(threeSeconds);

        // Stop the task
        System.out.println("Requesting task to stop...");
        task.stop();

        // Wait for the task thread to finish
        taskThread.join();
        System.out.println("Task thread has finished.");
    }
}
