package sorting;

import java.util.ArrayList;

/**
 * Sort2 uses a Comparator (neato!).
 *
 * @author BCIT
 * @version 2024
 */
public class Sort2 {

    /**
     * Prints the elements in a sorted list using a Comparator.
     */
    public void printElements() {
        java.util.List<SimpleTime> list = new ArrayList<>();
        list.add(new SimpleTime(6, 24, 34));
        list.add(new SimpleTime(6, 5, 34));
        list.add(new SimpleTime(12, 14, 58));
        list.add(new SimpleTime(6, 24, 22));

        System.out.printf("Unsorted array elements:%n%s%n", list);
        list.sort(new TimeComparator());
        System.out.printf("Sorted list elements:%n%s%n", list);
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Sort2 sort2 = new Sort2();
        sort2.printElements();
    }
}
