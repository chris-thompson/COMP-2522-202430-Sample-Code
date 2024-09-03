package inheritance.introToInheritance.firm;

/**
 * Represents an executive staff member, who can earn a bonus.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public class Executive extends Employee {

    private double bonus;

    /**
     * No argument constructor for initializing from a Scanner.
     */
    public Executive() {
    }

    /**
     * Constructors a new Executive object with the specified information.
     *
     * @param eName       employee name a string
     * @param eAddress    employee address a string
     * @param ePhone      employee phone a string
     * @param socInNumber social insurance number a string
     * @param rate        pay rate a double
     */
    public Executive(final String eName,
                     final String eAddress,
                     final String ePhone,
                     final String socInNumber,
                     final double rate) {
        super(eName, eAddress, ePhone, socInNumber, rate);
    }

    /**
     * Returns the bonus for this executive.
     * @return bonus as a double
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Awards the specified bonus to this executive.
     *
     * @param execBonus Amount of bonus as a double
     */
    public void awardBonus(final double execBonus) {
        bonus = execBonus;
    }

    /**
     * Computes and returns the pay for an executive, which is the regular
     * employee payment plus a one-time bonus.
     *
     * @return amount paid, including whatever bonus is due, as a double
     */
    public double pay() {
        return super.pay() + bonus;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        Executive executive = (Executive) object;

        return Double.compare(getBonus(), executive.getBonus()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getBonus());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Executive{");
        sb.append("bonus=").append(getBonus());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
