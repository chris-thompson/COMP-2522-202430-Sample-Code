package numbers;

import java.util.Scanner;

/**
 * BaseConvert.
 *
 * @author BCIT
 * @version 2024
 */
public final class BaseConvert {

    private BaseConvert() {
        // Utility classes should not be instantiated.
    }

    /**
     * Drives the program.
     *
     * @param args (unused)
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        System.out.println("Base Conversion Program");
        System.out.print("Please enter a base (2-9): ");

        // Assign the user's input to the base variable
        final int base = scan.nextInt();

        // Calculate the correct value to store in maxNumber
        final int maximumNumber = base * base * base * base - 1;

        System.out.println("The max base 10 number to convert for that base is " + maximumNumber);

        System.out.print("Please enter a base 10 number to convert: ");

        // Assign the user's input to the base20number variable
        int base10number = scan.nextInt();

        // Do the conversion
        final int place0 = base10number % base;
        base10number = base10number / base;
        final int place1 = base10number % base;
        base10number = base10number / base;
        final int place2 = base10number % base;
        base10number = base10number / base;
        final int place3 = base10number % base;
        base10number = base10number / base;
        System.out.println(base10number);

        // Print the result
        String baseBNum = "";
        baseBNum = baseBNum + place3 + place2 + place1 + place0;
        System.out.println("The number in base " + base + " = " + baseBNum);
        scan.close();
    }
}
