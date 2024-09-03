package sorting;

/**
 * Time manages a moment in time: hours, minutes, and seconds.
 *
 * @author BCIT
 * @version 2024
 */
public class SimpleTime {
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs an object of type Time.
     */
    public SimpleTime() {
        this(0, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     */
    public SimpleTime(final int h) {
        this(h, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     * @param m minutes an int
     */
    public SimpleTime(final int h, final int m) {
        this(h, m, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     * @param m minutes an int
     * @param s seconds an int
     */
    public SimpleTime(final int h, final int m, final int s) {
        setTime(h, m, s);
    }

    /**
     * Sets the time.
     * @param h hours an int
     * @param m minutes an int
     * @param s second an int
     */
    public void setTime(final int h, final int m, final int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    /**
     * Sets the hour to the specified time.
     * @param h an int
     */
    public void setHour(final int h) {
        hour = ((h >= 0 && h < 24) ? h : 0);
    }

    /**
     * Sets the minute to the specified time.
     * @param m an int
     */
    public void setMinute(final int m) {
        minute = ((m >= 0 && m < 60) ? m : 0);
    }

    /**
     * Sets the second to the specified time.
     * @param s an int
     */
    public void setSecond(final int s) {
        second = ((s >= 0 && s < 60) ? s : 0);
    }

    /**
     * Returns the hour.
     * @return hour as an int
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minute.
     * @return minute as an int
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Returns the second.
     * @return second as an int
     */
    public int getSecond() {
        return second;
    }

    /**
     * Returns the time formatted as HH:MM:SS.
     * @return time as HH:MM:SS
     */
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    /**
     * Returns a string representation of this Time.
     * @return description a string
     */
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}
