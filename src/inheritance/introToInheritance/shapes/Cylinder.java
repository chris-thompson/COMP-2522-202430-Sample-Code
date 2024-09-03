package inheritance.introToInheritance.shapes;

/**
 * Cylinder.
 *
 * @author BCIT
 * @version 2024
 */
public final class Cylinder extends Shape {

    private final double radius;
    private final double height;

    /**
     * Constructs an object of type Cylinder.
     *
     * @param radius a positive double
     * @param height a positive double
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(final double radius, final double height) {
        super("Cylinder");
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Positive radius only!");
        }
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Positive height only!");
        }
    }

    /**
     * Returns the radius of this Cylinder.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the height of this Cylinder.
     *
     * @return height as a double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    @Override
    public double surfaceArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + getHeight());
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Cylinder{");
        sb.append("radius=").append(getRadius());
        sb.append(", height=").append(getHeight());
        sb.append(", ");
        sb.append(super.toString());
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
        if (!super.equals(object)) {
            return false;
        }

        Cylinder cylinder = (Cylinder) object;

        if (Double.compare(getRadius(), cylinder.getRadius()) != 0) {
            return false;
        }
        return Double.compare(getHeight(), cylinder.getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        temp = Double.doubleToLongBits(getHeight());
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
