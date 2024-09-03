package generics;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Adds all Numbers or anything that extends Number!
 *
 * @author BCIT
 * @version 2024
 */
public final class TotalNumbersBound {

    private TotalNumbersBound() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        Integer[] integers = {1, 2, 3, 4, 5};
        ArrayList<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, integers);

        System.out.printf("integerList contains: %s\n", integerList);
        System.out.printf("Total of the elements in integerList: %.0f\n\n", sum(integerList));

        Double[] doubles = {1.1, 3.3, 5.5};
        ArrayList<Double> doubleList = new ArrayList<>();
        Collections.addAll(doubleList, doubles);

        System.out.printf("doubleList contains: %s\n", doubleList);
        System.out.printf("Total of the elements in doubleList: %.1f\n\n", sum(doubleList));

        Number[] numbers = {1, 2.4, 3, 4.1}; // Integers and Doubles
        ArrayList<Number> numberList = new ArrayList<>();
        Collections.addAll(numberList, numbers);

        System.out.printf("numberList contains: %s\n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f\n", sum(numberList));
    }

    /**
     * Accepts a list of Number or anything that extends Number and returns the sum.
     *
     * @param list of Number
     * @param <T> a type that extends Number
     * @return sum as a double
     */
    public static <T extends Number> double sum(final ArrayList<T> list) {
        double total = 0;
        for (T element : list) {
            total += element.doubleValue();
        }
        return total;
    }
}
