package concurrency.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccountWithLock {
    private int balance;
    private final Lock lock;

    BankAccountWithLock() {
        balance = 0;
        lock = new ReentrantLock();
    }

    /**
     * Adds the specified amount to the BankAccount.
     * Method will lock the BankAccount to ensure thread safety.
     *
     * @param amount an integer.
     */
    public void deposit(final int amount) {
        lock.lock(); // Explicitly acquire the lock
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
        } finally {
            lock.unlock(); // Ensure the lock is released even if an exception occurs
        }
    }

    /**
     * Removes the specified amount from the BankAccount. Overdraft is prevented.
     * Method will lock the BankAccount to ensure thread safety.
     *
     * @param amount an integer.
     */
    public void withdraw(final int amount) {
        lock.lock(); // Explicitly acquire the lock
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds, Balance: " + balance);
            }
        } finally {
            lock.unlock(); // Ensure the lock is released even if an exception occurs
        }
    }
}

/**
 * ReentrantLock allows us to:
 * ✅ Use tryLock() to attempt to acquire the lock without blocking indefinitely.
 * ✅ Set timeouts with tryLock(long timeout, TimeUnit unit).
 * ✅ Interrupt a thread waiting to acquire a lock.
 * ✅ Configure to ensure that threads acquire locks in the order they request them
 *    (new ReentrantLock(true))
 * ⚠️ Requires explicit lock management, meaning you must manually acquire and release
 *    the lock, increasing the risk of deadlocks if not done carefully.
 * ⚠️ If the unlock() method is not placed in a finally-block, the program may fail to
 *    release the lock in case of an exception, leading to potential deadlocks.
 *
 * @author BCIT
 * @version 2024
 */
public final class ReentrantLockExample {

    private ReentrantLockExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        BankAccountWithLock account = new BankAccountWithLock();

        // Creating multiple threads to deposit and withdraw money
        Thread t1 = new Thread(() -> {
            final int depositAmount = 100;
            account.deposit(depositAmount);
            final int withdrawAmount = 50;
            account.withdraw(withdrawAmount);
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            final int depositAmount = 200;
            account.deposit(depositAmount);
            final int withdrawAmount = 150;
            account.withdraw(withdrawAmount);
        }, "Thread 2");

        Thread t3 = new Thread(() -> account.withdraw(300), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
