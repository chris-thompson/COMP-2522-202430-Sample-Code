package maps.dice;

import java.util.Random;

/**
 * Die.  This die has 6 sides.
 *
 * @author BCIT
 * @version 2024
 */
public final class Die {

    /**
     * This die has 6 sides.
     */
    public static final int NUMBER_OF_SIDES = 6;
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    private int faceValue;

    /**
     * Constructor for objects of type Die.
     */
    public Die() {
        faceValue = RANDOM_NUMBER_GENERATOR.nextInt(NUMBER_OF_SIDES) + 1;

    }

    /**
     * Returns the face value of this Die.
     *
     * @return faceValue as an int
     */
    public int getFaceValue() {
        return faceValue;
    }

    private void setFaceValue(final int faceValue) {
        this.faceValue = faceValue;
    }

    /**
     * Rolls the Die and returns the new face value.
     *
     * @return the new face value as an int
     */
    public int roll() {
        this.setFaceValue(RANDOM_NUMBER_GENERATOR.nextInt(NUMBER_OF_SIDES) + 1);
        return getFaceValue();
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Die{");
        sb.append("faceValue=").append(getFaceValue());
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

        Die die = (Die) object;

        return getFaceValue() == die.getFaceValue();
    }

    @Override
    public int hashCode() {
        return getFaceValue();
    }
}
