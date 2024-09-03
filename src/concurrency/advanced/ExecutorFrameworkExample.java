package concurrency.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * The PrintTask class implements the Runnable interface, encapsulating the
 * logic to be executed by each thread—in this case, simply printing a message.
 *
 * Each task is assigned a unique message, which will be printed by the thread.
 */
class PrintTask implements Runnable {
    private final String message;

    PrintTask(final String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + message);
    }
}

/**
 * Demonstrates the Executor framework.
 *<p>
 * Executors.newFixedThreadPool(3) creates a thread pool with a fixed number of 3 threads.
 * These threads will be reused to execute the submitted tasks. This is an efficient way to
 * handle multiple tasks without creating a new thread for each task.
 *<p>
 * The for loop submits 10 tasks to the executor, each task printing a different message.
 *<p>
 * The executor.submit(new PrintTask(...)) method adds the task to the executor’s queue. The
 * tasks are then picked up by available threads from the pool and executed.
 *<p>
 * executor.shutdown() initiates an orderly shutdown where previously submitted tasks are
 * executed, but no new tasks will be accepted. This ensures that all tasks finish executing
 * before the program exits.
 *
 * @author BCIT
 * @version 2024
 */
public final class ExecutorFrameworkExample {

    private ExecutorFrameworkExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        // Create a fixed thread pool with 3 threads
        final int poolSize = 3;
        try (ExecutorService executor = Executors.newFixedThreadPool(poolSize)) {

            final int taskCount = 10;
            // Submit tasks to the executor
            for (int i = 1; i <= taskCount; i++) {
                executor.submit(new PrintTask("Message " + i));
            }

            // Shut down the executor gracefully
            executor.shutdown();
        }
    }
}
