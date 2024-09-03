package concurrency.threadInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Let's put it all together and see how threading works in our first multithreaded program
 * that uses inheritance!
 *
 * @author BCIT
 * @version 2024 (wow already?!)
 */
public final class ThreadingInAction {

    private static final int MAX_PASSWORD = 999;

    private ThreadingInAction() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Random random = new Random();
        SecuredAsset vault = new SecuredAsset(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();

        threads.add(new FastHackerThread(vault));
        threads.add(new SlowHackerThread(vault));
        threads.add(new CyberCop());

        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static final class SecuredAsset {

        private final int password;

        SecuredAsset(final int password) {
            this.password = password;
        }

        public Boolean isCorrectPassword(final int submission) {
            return this.password == submission;
        }
    }

    private abstract static class Hacker extends Thread {
        protected final SecuredAsset target;

        Hacker(final SecuredAsset target) {
            this.target = target;
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private static class FastHackerThread extends Hacker {

        private static final int NETWORK_DELAY_MS = 5;

        FastHackerThread(final SecuredAsset target) {
            super(target);
            this.setName("I am a fast hacker!");
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                try {
                    Thread.sleep(NETWORK_DELAY_MS);
                } catch (InterruptedException e) {
                    System.out.println("Under what circumstance would this line be printed?");
                }
                if (target.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0); // GAME-OVER!
                }
            }
        }
    }

    private static final class SlowHackerThread extends Hacker {

        private static final int NETWORK_DELAY_MS = 50;


        SlowHackerThread(final SecuredAsset target) {
            super(target);
            this.setName("I am a slow hacker!");
            this.setPriority(Thread.MIN_PRIORITY);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                try {
                    Thread.sleep(NETWORK_DELAY_MS);
                } catch (InterruptedException e) {
                    System.out.println("Under what circumstance would this line be printed?");
                }
                if (target.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static final class CyberCop extends Thread {

        private static final int COUNTDOWN_IN_SECONDS = 10;
        private static final int ONE_SECOND = 1000;
        @Override
        public void run() {
            for (int i = COUNTDOWN_IN_SECONDS; i > 0; i--) {
                try {
                    Thread.sleep(ONE_SECOND);
                } catch (InterruptedException e) {
                    System.out.println("Under what circumstance would this line be printed?");
                }
                System.out.println(i);
            }

            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }
}
