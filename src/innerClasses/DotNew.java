package innerClasses;

/**
 * The DotNew class demonstrates how to instantiate an inner class.
 *
 * @author BCIT
 * @version 2024
 */
public final class DotNew {

    /**
     * Constructs an object of type DotNew.
     */
    public DotNew() {
        System.out.println("Constructing a DotNew object");
    }

    /**
     * A public inner class.
     */
    public class Inner {

        /**
         * Constructs an object of type Inner.
         */
        public Inner() {
            System.out.println("Constructing an Inner object");
        }

    }

    /**
     * Drives the program.
     *<p>
     * What if this main method is inside a separate Driver class. Do we have to do anything
     * different to instantiate an Inner object?
     * @param args unused
     */
    public static void main(final String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
        System.out.println(dni);
    }


}
