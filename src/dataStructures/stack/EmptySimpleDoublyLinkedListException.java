package dataStructures.stack;

/**
 * EmptySimpleDoublyLinkedListException is an unchecked exception (it extends RuntimeException).
 *
 * @author BCIT
 * @version 2024
 */
public class EmptySimpleDoublyLinkedListException extends RuntimeException {

    /**
     * Constructs an object of type EmptySimpleDoublyLinkedListException.
     * @param name of an empty object.
     */
    public EmptySimpleDoublyLinkedListException(final String name) {
        super(name + " is empty");
    }
}
