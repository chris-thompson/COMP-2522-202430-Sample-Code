package generics;

/**
 * A simple generic Stack parameterized over E.
 *
 * @author BCIT
 * @version 2024
 * @param <E> the data type being stacked
 * */
public class GenericStack<E> {

    private static final int DEFAULT_SIZE = 10;

    // number of elements in the stack
    private final int size;

    // location of the top element
    private int top;

    // array that stores stack elements
    private final E[] elements;

    /**
     * Constructs a GenericStack of size DEFAULT_SIZE.
     */
    public GenericStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructs a GenericStack of the specified size.
     *
     * @param size a positive non-zero integer.
     */
    public GenericStack(final int size) {
        if (size > 0) {
            this.size = size;
        } else {
            this.size = DEFAULT_SIZE;
        }
        top = -1;
        elements = (E[]) new Object[this.size]; // A rare and necessary cast
    }

    /**
     * Pushes the specified element onto the GenericStack.
     * @param pushValue the element to push
     * @throws FullGenericStackException if the GenericStack is already full
     * */
    public void push(final E pushValue) {
        if (top == size - 1) {
            throw new FullGenericStackException(
                    String.format("GenericStack is full, cannot push %s", pushValue));
        }

        elements[++top] = pushValue; // place pushValue on Stack
    }

    /**
     * Returns the top element if not empty, else throws an EmptyGenericStackException.
     * @return the top element
     * @throws EmptyGenericStackException if the GenericStack is empty
     */
    public E pop() {
        if (top == -1) {
            throw new EmptyGenericStackException("GenericStack is empty, cannot pop");
        }

        return elements[top--]; // remove and return top element of Stack
    }
}
