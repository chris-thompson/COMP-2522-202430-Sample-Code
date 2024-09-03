package randomWalker;

import java.util.Random;

/**
 * RandomWalker.
 *
 * @author BCIT
 * @version 2024
 */
public final class RandomWalker {

    private int xCoordinate;
    private int yCoordinate;
    private final int maximumStepsToTake;
    private int currentStepsTaken;
    private final int boundary;
    private int maximumDistanceFromOrigin;
    private final Random random;

    /**
     * Constructs an object of type RandomWalker.
     *
     * @param maximumStepsToTake an int
     * @param boundary           an int
     */
    public RandomWalker(final int maximumStepsToTake, final int boundary) {
        xCoordinate = 0;
        yCoordinate = 0;
        this.maximumStepsToTake = maximumStepsToTake;
        currentStepsTaken = 0;
        this.boundary = boundary;
        maximumDistanceFromOrigin = 0;
        random = new Random();
    }

    /**
     * Returns the X Coordinate.
     *
     * @return xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the X Coordinate.
     *
     * @param newX an int
     */
    public void setxCoordinate(final int newX) {
        xCoordinate = newX;
    }

    /**
     * Returns the Y Coordinate.
     *
     * @return yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Takes a step.
     */
    public void takeStep() {
        currentStepsTaken++;
        final int directions = 4;
        int direction = random.nextInt(directions);
        switch (direction) {
            case 0 -> yCoordinate++;
            case 1 -> yCoordinate--;
            case 2 -> xCoordinate++;
            default -> xCoordinate--;
        }
        maximumDistanceFromOrigin = max(maximumDistanceFromOrigin, max(
                        Math.abs(xCoordinate),
                        Math.abs(yCoordinate)));
    }

    /**
     * Returns the max of the two specified values.
     *
     * @param a an int
     * @param b an int
     * @return the max of a and b as an int
     */
    private int max(final int a, final int b) {
        return Math.max(a, b);
    }

    /**
     * Returns the maximum distance from the origin this RandomWalker has
     * traveled.
     *
     * @return distance as an int
     */
    public int getMaximumDistance() {
        return maximumDistanceFromOrigin;
    }

    /**
     * Returns true if this RandomWalker has more steps to take.
     *
     * @return true if there are more steps to take, else false
     */
    public boolean moreSteps() {
        return maximumStepsToTake > currentStepsTaken;
    }

    /**
     * Returns true if the RandomWalker is in bounds, else false.
     *
     * @return true if in bounds, else false
     */
    public boolean inBounds() {
        return Math.abs(xCoordinate) <= boundary
                && Math.abs(yCoordinate) <= boundary;
    }

    /**
     * Walks while there are more steps and the RandomWalker is in bounds.
     */
    public void walk() {
        while (moreSteps() && inBounds()) {
            takeStep();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("RandomWalker{");
        sb.append("xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", maximumStepsToTake=").append(maximumStepsToTake);
        sb.append(", currentStepsTaken=").append(currentStepsTaken);
        sb.append(", boundary=").append(boundary);
        sb.append(", maximumDistanceFromOrigin=").append(getMaximumDistance());
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

        RandomWalker other = (RandomWalker) object;

        if (getxCoordinate() != other.getxCoordinate()) {
            return false;
        }
        if (getyCoordinate() != other.getyCoordinate()) {
            return false;
        }
        if (maximumStepsToTake != other.maximumStepsToTake) {
            return false;
        }
        if (currentStepsTaken != other.currentStepsTaken) {
            return false;
        }
        if (boundary != other.boundary) {
            return false;
        }
        return maximumDistanceFromOrigin == other.maximumDistanceFromOrigin;
    }

    @Override
    public int hashCode() {
        int result = getxCoordinate();
        final int usefulPrime = 31;
        result = usefulPrime * result + getyCoordinate();
        result = usefulPrime * result + maximumStepsToTake;
        result = usefulPrime * result + currentStepsTaken;
        result = usefulPrime * result + boundary;
        result = usefulPrime * result + maximumDistanceFromOrigin;
        return result;
    }
}
