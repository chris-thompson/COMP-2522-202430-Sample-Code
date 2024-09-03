package serializing;

import java.io.Serial;
import java.io.Serializable;

/**
 * A simple Person.
 *
 * @author BCIT
 * @version 2024
 */
public final class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // Recommended for serialization
    private final String name;
    private final int age;

    /**
     * Create an object of type Person.
     * @param name a string
     * @param age an integer
     */
    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }
}

