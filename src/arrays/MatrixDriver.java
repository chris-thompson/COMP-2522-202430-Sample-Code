package arrays;

/**
 * MatrixDriver.
 *
 * @author BCIT
 * @version 2024
 */
public final class MatrixDriver {

    private MatrixDriver() {
    }

    /**
     * Drives the program. These magic numbers are awful I'm sorry.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final Matrix square = new Matrix(2, 2);
        square.setValue(2, 0, 0);
        square.setValue(3, 0, 1);
        square.setValue(4, 1, 0);
        square.setValue(5, 1, 1);
        System.out.println(square);

        final Matrix anotherSquare = new Matrix(2, 2);
        anotherSquare.setValue(1, 0, 0);
        anotherSquare.setValue(2, 0, 1);
        anotherSquare.setValue(3, 1, 0);
        anotherSquare.setValue(4, 1, 1);
        System.out.println(anotherSquare);

        final Matrix rectangle = new Matrix(2, 3);
        rectangle.setValue(1, 0, 0);
        rectangle.setValue(2, 0, 1);
        rectangle.setValue(3, 0, 2);
        rectangle.setValue(4, 1, 0);
        rectangle.setValue(5, 1, 1);
        rectangle.setValue(6, 1, 2);
        System.out.println(rectangle);

        final Matrix sumMatrix = square.add(anotherSquare);
        System.out.println(sumMatrix);

        try {
            final Matrix wontWorkMatrix = square.add(rectangle);
            System.out.println(wontWorkMatrix);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
