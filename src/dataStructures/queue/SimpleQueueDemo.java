package dataStructures.queue;

/**
 * Demonstrates how to use a queue.
 *
 * @author BCIT
 * @version 2020
 */
public final class SimpleQueueDemo {

    private SimpleQueueDemo() {

    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        SimpleQueue simpleQueue = new SimpleQueue();

        simpleQueue.enqueue(-1);
        simpleQueue.print();
        simpleQueue.enqueue(0);
        simpleQueue.print();
        simpleQueue.enqueue(1);
        simpleQueue.print();
        simpleQueue.enqueue(5);
        simpleQueue.print();

        try {
            while (true) {
                Object removedObject = simpleQueue.dequeue();
                System.out.printf("%s dequeued\n", removedObject);
                simpleQueue.print();
            }
        } catch (EmptyLinkedListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
}
