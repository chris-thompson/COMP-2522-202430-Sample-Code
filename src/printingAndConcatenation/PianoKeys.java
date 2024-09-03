package printingAndConcatenation;

/**
 * Demonstrates the declaration, initialization, and use of an integer variable.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2019
 */
public final class PianoKeys {

    private PianoKeys() {
    }

    /**
     * Prints the number of keys on a piano.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final int keys = 88;
        System.out.println("A piano has " + keys + " keys.");
    }
}
