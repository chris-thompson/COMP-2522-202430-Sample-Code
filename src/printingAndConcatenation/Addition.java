package printingAndConcatenation;

/**
 * Demonstrates the difference between the addition and string concatenation
 * operators.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Addition {

    private Addition() { }

    /**
     * Concatenates and adds two numbers, then prints the results.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.println("24 and 45 concatenated: " + 24 + 45);
        System.out.println("24 and 45 added: " + (24 + 45));
    }
}
