package staticModifier;

/**
 * Represents a single slogan string.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Slogan {
    private static int count;

    private final String phrase;

    /**
     * Constructs a Slogan and increments the number of instances created.
     *
     * @param str the String used for the slogan
     */
    public Slogan(final String str) {
        phrase = str;
        count++;
    }

    /**
     * Returns the number of instances of this class that have been
     * created.
     *
     * @return count as an int
     */
    public static int getCount() {
        return count;
    }

    /**
     * Returns this Slogan's phrase as a String.
     * @return phrase as a String
     */
    public String getPhrase() {
        return phrase;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Slogan{");
        sb.append("phrase='").append(getPhrase()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Slogan slogan = (Slogan) object;

        if (getPhrase() != null) {
            return getPhrase().equals(slogan.getPhrase());
        }
        return slogan.getPhrase() == null;
    }

    @Override
    public int hashCode() {
        if (getPhrase() != null) {
            return getPhrase().hashCode();
        }
        return 0;
    }
}
