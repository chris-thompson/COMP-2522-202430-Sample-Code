package inheritance.introToInheritance.shapes;

/**
 * Sphere.
 *
 * @author BCIT
 * @version 2024
 */
public final class Sphere extends Shape {

    private final double radius;

    /**
     * Constructs an object of type Sphere.
     *
     * @param radius a positive double
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(final double radius) {
        super("Sphere");
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Positive radii only!");
        }
    }

    /**
     * Returns the radius of this Sphere.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    @Override
    public double surfaceArea() {
        final int four = 4;
        return four * Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Sphere{");
        sb.append("radius=").append(getRadius());
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

        Sphere sphere = (Sphere) object;

        return Double.compare(getRadius(), sphere.getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
