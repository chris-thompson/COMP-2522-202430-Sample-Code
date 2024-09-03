package exceptions;

/**
 * Custom checked exception.
 */
class MyCheckedException extends Exception {

    /**
     * Constructs an object of type MyCheckedException.
     * @param msg a description of the exceptional situation.
     */
    MyCheckedException(final String msg) {
        super(msg);
    }
}

/**
 * What is happening here?
 *
 * @author BCIT
 * @version 2024
 */
public final class ControlFlowExample3 {

    private ControlFlowExample3() {
    }

    /**
     * Throws a MyCheckedException.
     * @throws MyCheckedException every single time
     */
    private static void f() throws MyCheckedException {
        System.out.println("Throwing MyCheckedException from f()");
        throw new MyCheckedException("Originated in f()");
    }

    /**
     * Throws a MyCheckedException.
     * @throws MyCheckedException every single time
     */
    private static void g() throws MyCheckedException {
        System.out.println("Throwing MyCheckedException from g()");
        throw new MyCheckedException("Originated in g()");
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        try {
            f();
        } catch (MyCheckedException e) {
            e.printStackTrace(System.err);
        }
        try {
            g();
        } catch (MyCheckedException e) {
            e.printStackTrace(System.err);
        }
    }
}
