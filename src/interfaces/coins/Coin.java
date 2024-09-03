package interfaces.coins;

import java.util.Random;

/**
 * Represents a two-sided coin that can be flipped.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Coin implements Lockable {

    private static final Random RANDOM = new Random();

    private boolean face;
    private int key;
    private boolean locked;

    /**
     * Constructs a Coin object and flips it to give it a starting value.
     */
    public Coin() {
        flip();
        key = 0;
        locked = false;
    }

    /**
     * Returns true if the current face of the Coin is heads.
     *
     * @return true if current face is heads, else false.
     */
    public boolean getFace() {
        return face;
    }

    /**
     * Returns the key of this Coin.
     *
     * @return key an int
     */
    public int getKey() {
        return key;
    }

    /**
     * Flips this Coin by randomly choosing a face value.  The Coin cannot
     * be flipped if it is locked.
     */
    public void flip() {
        if (!locked) {
            face = RANDOM.nextBoolean();
        } else {
            System.out.println("Cannot flip, key is locked");
        }
    }

    @Override
    public void setKey(final int key) {
        if (!locked) {
            this.key = key;
        }
    }

    @Override
    public boolean lock(final int candidateKey) {
        if (!locked && this.key == candidateKey) {
                locked = true;
                return true;
        }
        return false;
    }

    @Override
    public boolean unlock(final int candidateKey) {
        if (this.key == candidateKey) {
            locked = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean locked() {
        return locked;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Coin coin = (Coin) object;

        if (getFace() != coin.getFace()) {
            return false;
        }
        if (getKey() != coin.getKey()) {
            return false;
        }
        return locked() == coin.locked();
    }

    @Override
    public int hashCode() {
        int result;
        if (getFace()) {
            result = 1;
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        result = usefulPrime * result + getKey();
        if (locked()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Coin{");
        sb.append("face=").append(getFace());
        sb.append(", key=").append(getKey());
        sb.append(", locked=").append(locked());
        sb.append('}');
        return sb.toString();
    }
}
