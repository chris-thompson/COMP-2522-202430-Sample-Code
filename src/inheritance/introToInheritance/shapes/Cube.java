package inheritance.introToInheritance.shapes;

/**
 * Cube.
 *
 * @author BCIT
 * @version 2024
 */
public final class Cube extends Shape {

    private final double sideLength;

    /**
     * Constructs an object of type Cube.
     *
     * @param sideLength a double
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(final double sideLength) {
        super("Cube");
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Positive sideLength only!");
        }
    }

    /**
     * Returns the side length of this Cube.
     *
     * @return sideLength as a double
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    @Override
    public double surfaceArea() {
        final int sides = 6;
        return getSideLength() * getSideLength() * sides;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Cube{");
        sb.append("sideLength=").append(getSideLength());
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

        Cube cube = (Cube) object;

        return Double.compare(getSideLength(), cube.getSideLength()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getSideLength());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
