package inheritance.introToInheritance.thoughts;

/**
 * Demonstrates use of an overridden method.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Messages {

    private Messages() {
    }

    /**
     * Creates two objects and invokes the message method in each.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        Thought parked = new Thought();
        Advice dates = new Advice();
        parked.message();
        dates.message(); // Invokes the overridden version of the method.
    }
}
