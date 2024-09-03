package inheritance.introToInheritance.roads;

/**
 * Boulevard is a road that incorporates a green space median.
 *
 * @author BCIT
 * @version 2024
 */
public class Boulevard extends Road {

    private final boolean medianHasTrees;

    /**
     * Constructor for objects of type Boulevard.
     *
     * @param roadName the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     * @param medianHasTrees true if the median has trees, else false
     */
    public Boulevard(final String roadName, final Direction roadDirection, final boolean medianHasTrees) {
        super(roadName, roadDirection);
        this.medianHasTrees = medianHasTrees;
    }

    /**
     * Returns true if the median has trees.
     *
     * @return true if the median has trees, else false
     */
    public boolean getMedianHasTrees() {
        return medianHasTrees;
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

        Boulevard boulevard = (Boulevard) object;

        return getMedianHasTrees() == boulevard.getMedianHasTrees();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (getMedianHasTrees()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Boulevard{");
        sb.append("medianHasTrees=").append(getMedianHasTrees());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
