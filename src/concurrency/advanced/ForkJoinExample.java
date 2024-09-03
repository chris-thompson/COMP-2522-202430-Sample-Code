package concurrency.advanced;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 * SumTask extends RecursiveTask<Long> and represents a task that will compute the
 * sum of a portion of the array.
 *
 * If the portion of the array is small enough (defined by THRESHOLD), the task sums
 * the elements directly. Otherwise, it splits the task into two subtasks, one for the
 * left half and one for the right half, and processes them in parallel.
 *
 * Extending RecursiveTask<V> is the common approach when you need a result from your
 * task, as shown in this example where the sum is calculated.
 */
class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10_000;

    private final long[] array;
    private final int start;
    private final int end;

    SumTask(final long[] array, final int start, final int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) { // Base case: small enough to compute directly
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            leftTask.fork(); // Fork left task to be computed in parallel
            long rightResult = rightTask.compute(); // Compute right task directly
            long leftResult = leftTask.join(); // Wait for the left task result

            return leftResult + rightResult;
        }
    }
}

/**
 * Demonstrates Fork / Join.
 *<p>
 * The fork() method schedules a subtask to be executed asynchronously.
 * The compute() method handles the task execution.
 * The join() method waits for the completion of the forked subtask and retrieves its result.
 *<p<>
 * The Fork/Join framework efficiently divides tasks into smaller subtasks, allowing them to
 * be processed in parallel, which is especially useful for CPU-bound operations.
 *
 * @author BCIT
 * @version 2024
 */
public final class ForkJoinExample {

    private ForkJoinExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        // Initialize the array with values
        final int upperBound = 100_000_000;
        long[] array = new long[upperBound];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextLong();
        }

        long sum = 0;
        for (long l : array) {
            sum += l;
        }
        System.out.println("Sum using ordinary loop: " + sum);

        long result;
        try (ForkJoinPool pool = new ForkJoinPool()) {
            SumTask task = new SumTask(array, 0, array.length);
            result = pool.invoke(task);
        }
        System.out.println("Sum using Fork/Pool: " + result);
    }
}
