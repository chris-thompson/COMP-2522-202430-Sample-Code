package exceptions;

/**
 * Custom exception.
 */
class AnotherException extends Exception {

    AnotherException(final String msg) {
        super(msg);
    }
}

/**
 * What is happening here?
 *
 * @author BCIT
 * @version 2024
 */
public final class SimpleCheckedExceptionDemo {
    private SimpleCheckedExceptionDemo() {
    }

    /**
     * Throws AnotherException.
     *
     * @throws AnotherException all the time
     */
    static void exceptionThrower() throws AnotherException {
        System.out.println("Throwing AnotherException from exceptionThrower()");
        throw new AnotherException("Originated in exceptionThrower()");
    }

    /**
     * Throws AnotherException.
     *
     * @throws AnotherException all the time
     */
    static void exceptionTosser() throws AnotherException {
        System.out.println("Throwing AnotherException from exceptionTosser()");
        throw new AnotherException("Originated in exceptionTosser()");
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        try {
            exceptionThrower();
        } catch (AnotherException e) {
            e.printStackTrace(System.err);
        }
        try {
            exceptionTosser();
        } catch (AnotherException e) {
            e.printStackTrace(System.err);
        }
    }
}
