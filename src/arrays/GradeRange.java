package arrays;

/**
 * Demonstrates the use of an array of objects.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class GradeRange {

    /**
     * Constant array of standard grades.
     */
    public static final Grade[] GRADES = {
            new Grade("A", 95),
            new Grade("A-", 90),
            new Grade("B+", 87),
            new Grade("B", 85),
            new Grade("B-", 80),
            new Grade("C+", 77),
            new Grade("C", 75),
            new Grade("C-", 70),
            new Grade("D+", 67),
            new Grade("D", 65),
            new Grade("D-", 60),
            new Grade("F", 0)
    };

    private GradeRange() {
    }

    /**
     * Creates and then prints an array of Grade objects.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        for (Grade letterGrade : GRADES) {
            System.out.println(letterGrade);
        }
    }
}
