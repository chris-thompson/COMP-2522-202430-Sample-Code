package inheritance.introToInheritance.shapes;

/**
 * Shape.
 *
 * @author BCIT
 * @version 2024
 */
public abstract class Shape {

    private final String shapeName;

    /**
     * Constructs an object of type Shape.
     *
     * @param name a String
     */
    public Shape(final String name) {
        this.shapeName = name;
    }

    /**
     * Returns the name of this Shape.
     *
     * @return shapeName as a String
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    public abstract double surfaceArea();


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Shape{");
        sb.append("shapeName='").append(getShapeName()).append('\'');
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

        Shape shape = (Shape) object;

        if (getShapeName() != null) {
            return getShapeName().equals(shape.getShapeName());
        }
        return shape.getShapeName() == null;
    }

    @Override
    public int hashCode() {
        if (getShapeName() != null) {
            return getShapeName().hashCode();
        }
        return 0;
    }
}
