package inheritance.introToInheritance.firm;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the personnel staff of a particular business.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class Staff {

    private static final double EXECUTIVE_BONUS = 500.00;
    private static final int HOURLY_HOURS = 40;
    private final List<StaffMember> staffList;

    /**
     * Constructs the list of staff members, read from a file. The file
     * staff.txt must has one line per staff member. The first word in each line
     * is the class name of the staff member. The instance variables to initialize
     * follow on the same line. Tokens must be separated by whitespace.
     */
    public Staff() {
        staffList = new ArrayList<>();
        Scanner scan;
        try {
            scan = new Scanner(new File("staff.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("could not find staff.txt");
            return;
        }
        scan.useDelimiter("[\t\n]");

        while (scan.hasNext()) {
            String className = scan.next();
            try {
                // create instance of staff member's class
                StaffMember nextStaff =  (StaffMember) Class.forName(className).getDeclaredConstructor().newInstance();

                // The instance initializes itself from the file
                nextStaff.readInstanceData(scan);

                // Why do you think I dislike these next two if-statements?
                staffList.add(nextStaff);
                if (nextStaff instanceof Executive) {
                    ((Executive) nextStaff).awardBonus(EXECUTIVE_BONUS);
                }
                if (nextStaff instanceof Hourly) {
                    ((Hourly) nextStaff).addHours(HOURLY_HOURS);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Could not find class \"" + className + "\"");
                return;
            } catch (InstantiationException ex) {
                System.out.println("Class " + className + " cannot be instantiated");
                return;
            } catch (IllegalAccessException ex) {
                System.out.println("Definition for class " + className + " cannot be accessed.");
                return;
            } catch (NoSuchMethodException e) {
                System.out.println("Constructor for class " + className + " cannot be found.");
                return;
            } catch (InvocationTargetException e) {
                System.out.println("Constructor for class " + className + " cannot be used.");
                return;
            }
        }
    }

    /**
     * Pays all staff members.
     */
    public void payday() {
        double amount;

        for (StaffMember staff : staffList) {
            System.out.println(staff);
            amount = staff.pay(); // polymorphic
            if (amount == 0.0) {
                System.out.println("Thanks!");
            } else {
                System.out.println("Paid: " + amount);
            }
            System.out.println("-----------------------------------");
        }
    }
}
