package variablelength;

import java.util.Arrays;

/**
 * Demonstrates the use of variable length parameter lists.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Family {
    /**
     * Names of family members.
     */
    private final String[] members;

    /**
     * Constructs a Family object by storing the (possibly multiple)
     * names that are passed as passByValue.
     *
     * @param names a variable number of Strings
     */
    public Family(final String... names) {
        members = names;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Family{");
        if (members == null) {
            sb.append("members=").append("null");
        } else {
            sb.append("members=").append(Arrays.asList(members));
        }
        sb.append('}');
        return sb.toString();
    }
}
