package arraylist;

import java.util.*;

/**
 * Demonstrates the use of the iterator.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class IteratorDemo {

    private static final String[] COLOURS = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
    private static final String[] REMOVE_COLOURS = {"RED", "WHITE", "BLUE" };

    /**
     * Constructs an object of type CollectionTest.
     */
    public IteratorDemo() {
        List<String> list = new ArrayList<>();
        List<String> removeList = new ArrayList<>();

        Collections.addAll(list, COLOURS);
        Collections.addAll(removeList, REMOVE_COLOURS);

        System.out.println("ArrayList: ");
        for (String s : list) {
            System.out.printf("%s ", s);
        }

        System.out.println("\n\nArrayList after calling removeColors: ");
        removeColors(list, removeList);
        for (String color : list) {
            System.out.printf("%s ", color);
        }
    }

    /*
     * Demonstrates the standard idiom for using an iterator to remove
     * elements from a collection WHILE LOOPING!
     */
    private void removeColors(final Collection<String> collection1,
                              final Collection<String> collection2) {
        Iterator<String> iterator = collection1.iterator();
        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
                iterator.remove();
            }
        }
        // Can now use this, too -- we will examine later in the term:
        // collection1.removeIf(collection2::contains);
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        new IteratorDemo();
    }
}
