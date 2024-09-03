package geometry;

/**
 * Cone.
 *
 * @author BCIT
 * @version 2024
 */
public final class Cone {
    private static final double SQUARED = 2.0;

    private double radius;
    private double height;

    /**
     * Constructs an object of type Cone.
     *
     * @param radius of the cone as a double
     * @param height of the cone as a double
     */
    public Cone(final double radius, final double height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Returns the radius for this Cone.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius for this Cone.
     *
     * @param radius the radius to set as a double
     */
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    /**
     * Returns the height for this Cone.
     *
     * @return height as a double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height for this Cone.
     *
     * @param height the height to set as a double
     */
    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * Returns this Cone's volume.
     *
     * @return volume as a double
     */
    public double getVolume() {
        final double third = 1.0 / 3.0;
        return third * Math.PI * Math.pow(radius, SQUARED);
    }

    /**
     * Returns this Cone's slant height.
     *
     * @return slantHeight as a double
     */
    public double getSlantHeight() {
        return Math.sqrt(Math.pow(radius, SQUARED) + Math.pow(height, SQUARED));
    }

    /**
     * Returns this Cone's surface area.
     *
     * @return surfaceArea as a double
     */
    public double getSurfaceArea() {
        return Math.PI * Math.pow(radius, SQUARED)
                + Math.PI * radius * Math.sqrt(Math.pow(radius, SQUARED)
                + Math.pow(height, SQUARED));
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Cone{");
        sb.append("radius=").append(radius);
        sb.append(", height=").append(height);
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

        Cone cone = (Cone) object;

        if (Double.compare(getRadius(), cone.getRadius()) != 0) {
            return false;
        }
        return Double.compare(getHeight(), cone.getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int shiftLongToInt = 32;
        result = (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getHeight());
        final int usefulPrime = 31;
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        return result;
    }
}
