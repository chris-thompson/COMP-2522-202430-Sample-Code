package dataStructures.stack;

/**
 * StackCompositionTest.
 *
 * @author BCIT
 * @version 2019
 */
public final class StackCompositionDemo {

    private StackCompositionDemo() {
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        StackComposition stack = new StackComposition();
        stack.push(-1);
        stack.print();
        stack.push(0);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(5);
        stack.print();

        try {
            while (true) {
                Object removedObject = stack.pop();
                System.out.printf("%s popped%n", removedObject);
                stack.print();
            }
        } catch (EmptySimpleDoublyLinkedListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
}
