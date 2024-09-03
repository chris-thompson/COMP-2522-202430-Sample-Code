package generics;

/**
 * Wildcards are useful when you want to allow for flexibility in the types that can be used with
 * generics. In this example, the displayBox method accepts a Box of any type using the wildcard <?>.
 * This allows the method to work with Box instances of any type, providing more flexibility compared
 * to using bounds.
 *
 * @author BCIT
 * @version 2024
 */
public final class WhenToUseWildcards {

    private WhenToUseWildcards() {
    }

    static void displayBox(final Box<?> box) {
        System.out.println("Box contains: " + box.get());
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int someValue = 10;
        Box<Integer> integerBox = new Box<>(someValue);
        Box<String> stringBox = new Box<>("Hello");

        displayBox(integerBox); // Output: Box contains: 10
        displayBox(stringBox); // Output: Box contains: Hello
    }
}
