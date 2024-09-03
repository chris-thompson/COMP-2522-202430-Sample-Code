package exceptions;

/**
 * This is NOT how we want to deal with Exceptions. This approach
 * is not Java style (LBYL).  This is Pythonic (EAFP).
 *
 * @author BCIT
 * @version 2024
 */
public final class DontDoThis {

    private DontDoThis() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        String hello = "Blue";

        // This makes Java developers' eyes bleed, but it is Pythonic.
        try {
            int index = 0;
            while (true) {
                System.out.println(hello.charAt(index));
                index++;
            }
        } catch (Exception e) {
            System.out.println("This is terrible. Don't do this.");
        }
    }
}
