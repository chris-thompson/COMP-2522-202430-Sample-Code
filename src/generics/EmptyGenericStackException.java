package generics;


/**
 * EmptyGenericStackException is raised when a pop operation is attempted on an empty stack.
 *
 * @author BCIT
 * @version 2024
 */
public class EmptyGenericStackException extends RuntimeException {

    /**
     * Create an object of type EmptyGenericStackException.
     *
     * @param message a String message
     */
    public EmptyGenericStackException(final String message) {
        super(message);
    }

}
