package concurrency.sharingObjects;

class RaceCondition {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

/**
 * Demonstrates a classic Race Condition.
 *
 * @author BCIT
 * @version 2024
 */
public final class RaceConditionExample {

    private RaceConditionExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        RaceCondition counter = new RaceCondition();
        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);
        t1.start();
        t2.start();
        System.out.println(counter.getCount());
    }
}
