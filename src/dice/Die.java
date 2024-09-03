package dice;

import java.util.Random;

/**
 * Die represents a six-sided die.
 *
 * @author BCIT
 * @version 2024
 */
public final class Die {

    /**
     * The number of sides.
     */
    public static final int SIDES = 6;
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    private int faceValue;

    /**
     * Constructs a Die object. A new Die has a face value of 1.
     */
    public Die() {
        this.faceValue = 1;
    }

    /**
     * Returns the face value of this Die as an int.
     *
     * @return faceValue as an int
     */
    public int getFaceValue() {
        return this.faceValue;
    }

    /**
     * Sets the face value of this Die to the specified value. If the value is
     * not valid, the face value will not be changed.
     *
     * @param value an int
     */
    public void setFaceValue(final int value) {
        if (value > 0 && value <= SIDES) {
            this.faceValue = value;
        }
    }

    /**
     * Rolls this Die and returns the result.
     *
     * @return faceValue as an int
     */
    public int roll() {
        this.faceValue = RANDOM_NUMBER_GENERATOR.nextInt(SIDES) + 1;
        return this.faceValue;
    }


    /**
     * Returns a String representation of this Die.
     *
     * @return toString description
     */
    @Override
    public String toString() {
        return "Die{" + "faceValue=" + getFaceValue() + "}";
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Die die = (Die) object;

        return getFaceValue() == die.getFaceValue();
    }

    @Override
    public int hashCode() {
        return getFaceValue();
    }

    /**
     * Demonstrates the use of this class.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        Die testDie = new Die();
        int roll = testDie.roll();
        int faceValue = testDie.getFaceValue();
        System.out.println(roll == faceValue);
        System.out.println(testDie);
    }
}
