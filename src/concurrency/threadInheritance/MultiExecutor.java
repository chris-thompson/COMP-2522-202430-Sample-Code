package concurrency.threadInheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * How might we organize a collection of Threads to be executed concurrently? Is the order of initialization also
 * the order of execution? Let's find out!
 *
 * @author BCIT
 * @version 2024
 */
public final class MultiExecutor {

    private final List<Runnable> tasks;

    /**
     * Constructs an object of type MultiExecutor.
     * @param tasks a list of Runnable objects  to be executed concurrently
     */
    public MultiExecutor(final List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Executes all the tasks concurrently.
     */
    public void executeAll() {
        List<Thread> threads = new ArrayList<>(tasks.size());

        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        MultiExecutor multiExecutor = new MultiExecutor(List.of(
                () -> System.out.println("Hello from task 1"),
                () -> System.out.println("Hello from task 2"),
                () -> System.out.println("Hello from task 3"),
                () -> System.out.println("Hello from task 4"),
                () -> System.out.println("Hello from task 5"),
                () -> System.out.println("Hello from task 6"),
                () -> System.out.println("Hello from task 7"),
                () -> System.out.println("Hello from task 8"),
                () -> System.out.println("Hello from task 9"),
                () -> System.out.println("Hello from task 10")
        ));
        multiExecutor.executeAll();
    }
}
