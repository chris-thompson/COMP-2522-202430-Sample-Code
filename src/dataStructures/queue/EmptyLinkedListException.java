package dataStructures.queue;

/**
 * EmptyLinkedListException is an unchecked exception (it extends
 * RuntimeException).
 *
 * @author BCIT
 * @version 2024
 */
public class EmptyLinkedListException extends RuntimeException {

    /**
     * Constructs an object of type EmptyLinkedListException.
     * @param name of an empty object.
     */
    public EmptyLinkedListException(final String name) {
        super(name + " is empty");
    }
}
