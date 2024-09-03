package inheritance.introToInheritance.roads;

/**
 * Road.
 *
 * @author BCIT
 * @version 2024
 */
public class Road {

    private final String name;
    private final Direction direction;

    /**
     * Constructor for objects of type Road.
     *
     * @param roadName      the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     */
    public Road(final String roadName, final Direction roadDirection) {
        this.name = roadName;
        this.direction = roadDirection;
    }

    /**
     * Returns the name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the direction.
     *
     * @return direction as a Direction enum
     */
    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Road road = (Road) object;

        if (getName() != null) {
            if (!getName().equals(road.getName())) {
                return false;
            }
        } else {
            if (road.getName() != null) {
                return false;
            }
        }
        return getDirection() == road.getDirection();
    }

    @Override
    public int hashCode() {
        int result;
        if (getName() != null) {
            result = getName().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getDirection() != null) {
            result = usefulPrime * result + getDirection().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Road{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", direction=").append(getDirection());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
