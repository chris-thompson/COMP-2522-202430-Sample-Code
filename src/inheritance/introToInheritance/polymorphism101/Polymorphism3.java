package inheritance.introToInheritance.polymorphism101;

/**
 * Polymorphism demo.
 *
 * @author BCIT
 * @version 2024
 */
public final class Polymorphism3 {

    private Polymorphism3() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final I ii = new I();
        final I ij = new J();
        final J j = new J();

        ii.foo();
        System.out.println("---");
        ij.foo();
        System.out.println("---");
        j.foo();
    }
}

/**
 * I.
 */
class I {
    void foo() {
        System.out.println("I foo()");
        bar();
    }

    void bar() {
        System.out.println("I bar()");
    }
}

/**
 * J extends I.
 */
class J extends I {
    void foo() {
        System.out.println("J foo()");
        super.foo();
    }

    void bar() {
        System.out.println("J bar()");
    }
}
