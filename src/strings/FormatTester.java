package strings;

/**
 * Demonstrates the use of the String class' static format method.
 *
 * @author BCIT
 * @version 2024
 */
public final class FormatTester {

    private FormatTester() {

    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final String t = String.format("The correct answer is %b", false);
        System.out.println(t);

        final String w = "Insert Name Here";
        final String s = String.format("The correct answer is %s", w);
        System.out.println(s);

    }
}
