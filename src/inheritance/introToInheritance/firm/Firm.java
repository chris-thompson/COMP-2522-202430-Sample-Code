package inheritance.introToInheritance.firm;

/**
 * Demonstrates polymorphism via inheritance.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Firm {

    private Firm() {
    }

    /**
     * Creates a staff of employees for a firm and pays them.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        Staff personnel = new Staff();
        personnel.payday();
    }
}
