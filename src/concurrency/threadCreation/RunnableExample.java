package concurrency.threadCreation;

// Define a task to download a file
class FileDownloader implements Runnable {
    private static final int TWO_MINUTE_SLEEP = 2000;
    private final String fileName;

    FileDownloader(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Defines the task to be performed.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting download: " + fileName);
        try {
            // Simulate time taken to download the file
            Thread.sleep(TWO_MINUTE_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " completed download: " + fileName);
    }
}

/**
 * Demonstrates how to extend the Runnable interface in order to write
 * better, more modular code.
 *
 * @author BCIT
 * @version 2024
 */
public final class RunnableExample {

    private RunnableExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        // Create instances of FileDownloader for each file to be downloaded
        Runnable downloadTask1 = new FileDownloader("file1.txt");
        Runnable downloadTask2 = new FileDownloader("file2.txt");
        Runnable downloadTask3 = new FileDownloader("file3.txt");

        // Create threads for each download task
        Thread thread1 = new Thread(downloadTask1, "Downloader-1");
        Thread thread2 = new Thread(downloadTask2, "Downloader-2");
        Thread thread3 = new Thread(downloadTask3, "Downloader-3");

        // Start the threads to begin downloading
        thread1.start();
        thread2.start();
        thread3.start();

        // Optionally wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }

        System.out.println("All downloads completed.");
    }
}
