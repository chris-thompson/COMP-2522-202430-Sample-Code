package interfaces;

import java.util.ArrayList;

/**
 * Sort2 uses a Comparator (neato!).
 *
 * @author BCIT
 * @version 2020
 */
public class SortingTime {

    /**
     * Prints the elements in a sorted list using a Comparator.
     */
    public void printElements() {
        java.util.List<Time> list = new ArrayList<>();
        list.add(new Time(6, 24, 34));
        list.add(new Time(18, 14, 58));
        list.add(new Time(6, 5, 34));
        list.add(new Time(12, 14, 58));
        list.add(new Time(6, 24, 22));

        System.out.println("Unsorted array elements");
        System.out.println(list);
        list.sort(new TimeComparator());
        System.out.println("Sorted array elements");
        System.out.println(list);
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        SortingTime sortingTime = new SortingTime();
        sortingTime.printElements();
    }
}
