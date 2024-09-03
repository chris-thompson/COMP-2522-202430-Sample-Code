package exceptions;

/**
 * Demonstrates exception propagation.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class ExceptionPropagationDriver {

    private ExceptionPropagationDriver() {
    }

    /**
     * Creates a new ExceptionScope object and invokes the level1() method in
     * it. This demonstrates exception propagation.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        ExceptionPropagation demo = new ExceptionPropagation();
        System.out.println("Program beginning.");
        demo.level1();
        System.out.println("Program ending.");
    }
}
