package innerClasses;

/**
 * Let's see how to create and use local classes.
 *
 * @author BCIT
 * @version 2024
 */
public class HelloWorldLocalClasses {

    /**
     * This class contains a nested private interface. The interface can be used
     * inside the class to formalize how to greet someone. Only the class can
     * use the interface.
     */
    private interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    /**
     * Says hello in many fun ways.
     */
    public void sayHello() {

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            public void greet() {
                greetSomeone("world");
            }

            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";

            public void greet() {
                greetSomeone("mundo");
            }

            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }



    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String... args) {
        HelloWorldLocalClasses myApp = new HelloWorldLocalClasses();
        myApp.sayHello();
    }
}
