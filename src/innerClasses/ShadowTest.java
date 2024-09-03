package innerClasses;

/**
 * Demonstrates scope and variable shadowing.
 *
 * @author BCIT
 * @version 2024
 */
public class ShadowTest {

    /**
     * A public instance variable. Terrible. Never do this. It's for demo purposes only.
     */
    private final int x = 0;

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String... args) {
        ShadowTest st = new ShadowTest();
        FirstLevel fl = st.new FirstLevel();
        final int sumFirstFourPrimes = 2 + 3 + 5 + 7;
        fl.methodInFirstLevel(sumFirstFourPrimes);
        final int answer = 42;
        fl.methodInFirstLevel(answer);
    }

    /**
     * An inner class!
     */
    class FirstLevel {

        /**
         * A public instance variable. Terrible. Don't do this. It's for demo purposes only.
         */
        private final int x = 1;

        /**
         * Prints some stuff. Checkstyle doesn't like the name of the parameter, does it!
         * @param x an integer
         */
        void methodInFirstLevel(final int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.x = " + ShadowTest.this.x);
            System.out.println("x = " + x);
        }
    }
}
