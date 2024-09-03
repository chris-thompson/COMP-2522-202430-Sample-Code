package geometry;

/**
 * Sphere.
 *
 * @author BCIT
 * @version 2024
 */
public final class Sphere {
    private double radius;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    /**
     * Constructs an object of type Sphere.
     *
     * @param radius of the Sphere
     * @param x the x Cartesian coordinate of the centre as a double
     * @param y the y Cartesian coordinate of the centre as a double
     * @param z the z Cartesian coordinate of the centre as a double
     */
    public Sphere(final double radius, final double x, final double y, final double z) {
        this.radius = radius;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.zCoordinate = z;
    }

    /**
     * Returns the radius for this Sphere.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius for this Sphere.
     *
     * @param radius the radius to set as a double
     */
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    /**
     * Returns the xCoordinate for this Sphere.
     *
     * @return xCoordinate as a double
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the xCoordinate for this Sphere.
     *
     * @param xCoordinate the xCoordinate to set as a double
     */
    public void setxCoordinate(final double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Returns the yCoordinate for this Sphere.
     *
     * @return yCoordinate as a double
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the yCoordinate for this Sphere.
     *
     * @param yCoordinate the yCoordinate to set as a double
     */
    public void setyCoordinate(final double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns the zCoordinate for this Sphere.
     *
     * @return zCoordinate as a double
     */
    public double getzCoordinate() {
        return zCoordinate;
    }

    /**
     * Sets the zCoordinate for this Sphere.
     *
     * @param zCoordinate the zCoordinate to set as a double
     */
    public void setzCoordinate(final double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    /**
     * Returns the surface area of this Sphere.
     *
     * @return surfaceArea as a double
     */
    public double getSurfaceArea() {
        final double multiplier = 4.0;
        final double squared = 2;
        return multiplier * Math.PI * Math.pow(radius, squared);
    }

    /**
     * Returns the volume of this Sphere.
     *
     * @return volume as a double
     */
    public double getVolume() {
        final int cubed = 3;
        final double divisor = 4.0 / 3.0;
        return divisor * Math.PI * Math.pow(radius, cubed);
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Sphere{");
        sb.append("radius=").append(getRadius());
        sb.append(", xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", zCoordinate=").append(getzCoordinate());
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

        Sphere sphere = (Sphere) object;

        if (Double.compare(getRadius(), sphere.getRadius()) != 0) {
            return false;
        }
        if (Double.compare(getxCoordinate(), sphere.getxCoordinate()) != 0) {
            return false;
        }
        if (Double.compare(getyCoordinate(), sphere.getyCoordinate()) != 0) {
            return false;
        }
        return Double.compare(getzCoordinate(), sphere.getzCoordinate()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int shiftLongToInt = 32;
        result = (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getxCoordinate());
        final int usefulPrime = 31;
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getyCoordinate());
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getzCoordinate());
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        return result;
    }
}
