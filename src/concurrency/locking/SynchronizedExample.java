package concurrency.locking;

class BankAccount {
    private int balance;

    BankAccount() {
        balance = 0;
    }

    /**
     * Adds the specified amount to the BankAccount.
     * Synchronized method to ensure thread safety.
     *
     * @param amount an integer
     */
    public synchronized void deposit(final int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
    }

    /**
     * Removes the specified amount from the BankAccount. Overdraft is prevented.
     * Synchronized method to ensure thread safety.
     *
     * @param amount an integer
     */    public synchronized void withdraw(final int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds, Balance: " + balance);
        }
    }
}

/**
 * ✅ The synchronized keyword is easy to use and understand.
 * ✅ The lock is automatically acquired and released when the method exits.
 * ❌ No ability to time out while waiting for a lock nor interrupt a thread waiting for a lock.
 *
 * @author BCIT
 * @version 2024
 */
public final class SynchronizedExample {

    private SynchronizedExample() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        BankAccount account = new BankAccount();

        // Creating multiple threads to deposit and withdraw money
        Thread t1 = new Thread(() -> {
            final int depositAmount = 100;
            account.deposit(depositAmount);
            final int withdrawalAmount = 50;
            account.withdraw(withdrawalAmount);
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            final int depositAmount = 200;
            account.deposit(depositAmount);
            final int withdrawalAmount = 150;
            account.withdraw(withdrawalAmount);
        }, "Thread 2");

        final int bigAmount = 300;
        Thread t3 = new Thread(() -> account.withdraw(bigAmount), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
