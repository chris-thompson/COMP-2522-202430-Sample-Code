package concurrency.locking;

/**
 * This is a variation of the classic “Dining Philosophers” problem,where each
 * philosopher tries to pick up two sticks (or chopsticks) to eat. If a philosopher
 * cannot pick up both sticks, they put down the one they’ve already picked up and
 * wait a bit before trying again.
 *<p>
 * Livelock Condition: In this scenario, it’s possible for two or more philosophers
 * to keep picking up and putting down their sticks in response to each other’s actions,
 * leading to a livelock where no philosopher ever actually eats!
 *
 * @author BCIT
 * @version 2024
 */
public final class LivelockExample {

    private LivelockExample() { }

    private static final class Stick {
        private boolean isPickedUp;

        Stick() {
            isPickedUp = false;
        }

        synchronized void pickUp() {
            isPickedUp = true;
        }

        synchronized void putDown() {
            isPickedUp = false;
        }

        synchronized boolean isPickedUp() {
            return isPickedUp;
        }
    }

    private static final class Philosopher {
        private final String name;
        private final Stick leftStick;
        private final Stick rightStick;

        Philosopher(final String name, final Stick leftStick, final Stick rightStick) {
            this.name = name;
            this.leftStick = leftStick;
            this.rightStick = rightStick;
        }

        void dine() {
            while (true) {
                // Check if both sticks are free
                if (!leftStick.isPickedUp()) {
                    leftStick.pickUp();
                    System.out.println(name + " picked up left stick");

                    if (!rightStick.isPickedUp()) {
                        rightStick.pickUp();
                        System.out.println(name + " picked up right stick");
                        // Both sticks picked up, philosopher can eat
                        System.out.println(name + " is eating");

                        // Put down the sticks after eating
                        rightStick.putDown();
                        System.out.println(name + " put down right stick");
                    }

                    // Left stick was picked up but right stick wasn't, so put down the left stick
                    leftStick.putDown();
                    System.out.println(name + " put down left stick");

                    // Wait a bit before trying again
                    try {
                        final int shortSleep = 10;
                        Thread.sleep(shortSleep);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Stick stick1 = new Stick();
        Stick stick2 = new Stick();
        Stick stick3 = new Stick();
        Stick stick4 = new Stick();
        Stick stick5 = new Stick();

        Philosopher philosopher1 = new Philosopher("Philosopher 1", stick1, stick2);
        Philosopher philosopher2 = new Philosopher("Philosopher 2", stick2, stick3);
        Philosopher philosopher3 = new Philosopher("Philosopher 3", stick3, stick4);
        Philosopher philosopher4 = new Philosopher("Philosopher 4", stick4, stick5);
        Philosopher philosopher5 = new Philosopher("Philosopher 5", stick5, stick1);

        new Thread(philosopher1::dine).start();
        new Thread(philosopher2::dine).start();
        new Thread(philosopher3::dine).start();
        new Thread(philosopher4::dine).start();
        new Thread(philosopher5::dine).start();
    }
}
