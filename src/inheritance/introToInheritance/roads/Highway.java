package inheritance.introToInheritance.roads;

/**
 * Highway is a fast road that may have an HOV lane.
 *
 * @author BCIT
 * @version 2020
 */
public class Highway extends Road {

    private final boolean hasHovLane;

    /**
     * Constructor for objects of type Highway.
     *
     * @param roadName the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     * @param hasHovLane true if the highway includes an HOV lane else false
     */
    public Highway(final String roadName, final Direction roadDirection, final boolean hasHovLane) {
        super(roadName, roadDirection);
        this.hasHovLane = hasHovLane;
    }

    /**
     * Returns true if the highway has an HOV lane.
     *
     * @return true if the highway has an HOV lane, else false
     */
    public boolean hashHovLane() {
        return hasHovLane;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        Highway highway = (Highway) object;

        return hashHovLane() == highway.hashHovLane();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (hashHovLane()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Highway{");
        sb.append("hasHOVlane=").append(hashHovLane());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
