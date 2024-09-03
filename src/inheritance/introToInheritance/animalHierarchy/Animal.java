package inheritance.introToInheritance.animalHierarchy;

/**
 * Animal.
 *
 * @author BCIT
 * @version 2024
 */
public abstract class Animal {

    /**
     * The age in years.
     */
    protected int age;

    /**
     * Constructs an object of type Animal.
     *
     * @param age a positive integer
     */
    public Animal(final int age) {
        this.age = age;
    }

    /**
     * Eats.
     */
    abstract void eat();

    /**
     * Moves.
     */
    abstract void move();
}
