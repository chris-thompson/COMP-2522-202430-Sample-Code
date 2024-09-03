package banking;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Represents a bank account with basic services such as deposit and withdraw.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Account {

    /* Interest rate of 3.5 percent. */
    private static final double RATE = 0.035;

    /* Account number is unique for each account. */
    private final long acctNumber;
    private double balance;
    private final String identifier;

    /**
     * Constructs an account object by defining its owner, account number, and
     * initial balance.
     *
     * @param owner identifier of account owner as a String
     * @param account a long for the account number as a long
     * @param initial a double representing the initial balance as a double
     */
    public Account(final String owner, final long account, final double initial) {
        identifier = owner;
        acctNumber = account;
        balance = initial;
    }

    /**
     * Returns the account number.
     *
     * @return acctNumber as a long
     */
    public long getAcctNumber() {
        return acctNumber;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return balance as a double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the identifier of the account.
     *
     * @return identifier as a String
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Deposits the specified amount into the account. Returns the new balance.
     *
     * @param amount a double for the amount to deposit
     * @return the new balance after the deposit as a double
     */
    public double deposit(final double amount) {
        balance = balance + amount;
        return balance;
    }

    /**
     * Withdraws the specified amount from the account and applies the fee.
     * Returns the new balance.
     *
     * @param amount a double to withdraw
     * @param fee    a double for a withdrawal fee
     * @return balance after the withdrawal as a double
     */
    public double withdraw(final double amount, final double fee) {
        balance = balance - amount - fee;
        return balance;
    }

    /**
     * Adds interest to the account and returns the new balance.
     *
     * @return balance after interest has been added as a double
     */
    public double addInterest() {
        balance += (balance * RATE);
        return balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("acctNumber=").append(getAcctNumber());
        final NumberFormat fmt = NumberFormat.getCurrencyInstance();
        sb.append(", balance=").append(fmt.format(getBalance()));
        sb.append(", identifier='").append(getIdentifier()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Account account = (Account) object;

        if (acctNumber != account.acctNumber) {
            return false;
        }
        if (Double.compare(getBalance(), account.getBalance()) != 0) {
            return false;
        }
        return Objects.equals(identifier, account.identifier);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        final int shiftLongToInt = 32;
        result = (int) (acctNumber ^ (acctNumber >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getBalance());
        final int usefulPrime = 31;
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        if (identifier != null) {
            result = usefulPrime * result + identifier.hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
