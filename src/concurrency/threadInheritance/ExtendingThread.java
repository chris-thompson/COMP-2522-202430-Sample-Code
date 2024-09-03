package concurrency.threadInheritance;

/**
 * We can extend the Thread class and override the run() method. In our previous example, the Thread constructor
 * requires a Runnable object. But did you notice that Thread implements Runnable? That means we can extend Thread
 * and override the run() method. This is a preferred way to create a Thread object for the JVM.
 *
 *
 * @author BCIT
 * @version 2024
 */
public final class ExtendingThread {

    private ExtendingThread() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static final class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
