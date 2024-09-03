package generics;


/**
 * FullGenericStackException is raised when a push operation is attempted on a full stack.
 *
 * @author BCIT
 * @version 2024
 */
public class FullGenericStackException extends RuntimeException {

    /**
     * Create an object of type FullStackException.
     *
     * @param exception a String message
     */
    public FullGenericStackException(final String exception) {
        super(exception);
    }
}
