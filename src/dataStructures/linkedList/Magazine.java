package dataStructures.linkedList;

/**
 * Represents a single magazine.
 *
 * @author BCIT
 * @version 2024
 */
public final class Magazine {

    private final String title;

    /**
     * Constructs a new Magazine object with the specified title.
     *
     * @param newTitle The title of the magazine
     */
    public Magazine(final String newTitle) {
        title = newTitle;
    }

    @Override
    public String toString() {
        return "Magazine{" + "title='" + title + '\'' + '}';
    }
}

