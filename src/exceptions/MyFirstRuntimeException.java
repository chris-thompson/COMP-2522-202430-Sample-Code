package exceptions;

/**
 * We create checked exceptions by extending Exception.
 * We create unchecked exceptions by extending RuntimeException.
 * We can extend any of the built-in exceptions, or create our own.
 * There's nothing "inside" it except the string we pass to the constructor.
 *
 * @author BCIT
 * @version 2024
 */
public class MyFirstRuntimeException extends RuntimeException {
    /**
     * Constructs an object of type MyFirstRuntimeException.
     * @param message a description of the exceptional situation
     */
    public MyFirstRuntimeException(final String message) {
        super(message);
    }
}
