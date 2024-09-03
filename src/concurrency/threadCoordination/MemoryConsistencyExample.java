package concurrency.threadCoordination;

/**
 * Due to memory consistency issues, it’s possible for the reader thread to see flag
 * as true but still read the old value of count (which might be 0), because there is
 * no guarantee that the write to count will be visible to the reader thread in the
 * correct order.
 *
 * @author BCIT
 * @version 2024
 */
public class MemoryConsistencyExample {

    private static final int ULTIMATE_ANSWER = 42;

    private boolean flag = false;
    private int count = 0;

    /**
     * Set the flag and set count.
     */
    public void writer() {
        flag = true;   // (1)
        count = ULTIMATE_ANSWER;    // (2)
    }

    /**
     * Prints the value of the count variable.
     */
    public void reader() {
        if (flag) {    // (3)
            System.out.println(count); // (4)
        }
    }

    /**
     * Drives the program.
     * @param args unused
     * @throws InterruptedException if a thread is interrupted, I guess.
     */
    public static void main(final String[] args) throws InterruptedException {
        MemoryConsistencyExample example = new MemoryConsistencyExample();
        Thread writerThread = new Thread(example::writer);
        Thread readerThread = new Thread(example::reader);
        writerThread.start();
        readerThread.start();
    }
}
