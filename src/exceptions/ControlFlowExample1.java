package exceptions;

/**
 * What's happening here?
 *
 * @author BCIT
 * @version 2024
 */
public class ControlFlowExample1 {

    /**
     * Throws an exception.
     * @throws Exception always thrown
     */
    public void alwaysThrows() throws Exception {
        throw new Exception();
    }

    /**
     * I think this throws an Exception.  But what happens first?
     * @throws Exception of some sort is thrown, somehow, eventually...
     */
    public void foo() throws Exception {
        System.out.println("Entering foo()!");
        try {
            System.out.println("Entering try before alwaysThrows()");
            alwaysThrows();
            System.out.println("Exiting try after alwaysThrows()");
        } catch (Exception e) {
            System.out.println("Oh no! An exception was thrown by alwaysThrows!");
            throw e; // Rethrowing the exception. This is a bad idea.
        } finally {
            System.out.println("Finally!");
        }
        System.out.println("Exiting foo()!");
    }

    /**
     * Drives the program.
     * @param args unused
     * @throws Exception in a circuitous way
     */
    public static void main(final String[] args) throws Exception {
        ControlFlowExample1 c = new ControlFlowExample1();
        try {
            c.foo();
        } finally {
            System.out.println("The exception has made it to the main finally without being caught!");
        }
    }
}
