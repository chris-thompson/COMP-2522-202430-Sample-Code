package printingAndConcatenation;

/**
 * Demonstrates the use of escape sequences.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Roses {

    private Roses() {

    }

    /**
     * Prints a poem (of sorts) on multiple lines.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.println("""
                Roses are red,
                \tViolets are blue,
                Sugar is sweet,
                \tBut I have "commitment issues",
                \tSo I'd rather just be friends
                \tAt this point in our relationship.""");
    }
}
