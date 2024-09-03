package interfaces;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * TimeComparator compares two Time objects.
 *
 * @author BCIT
 * @version 2024
 */
public class TimeComparator implements Comparator<Time> {

    /**
     * Compares the two Time arguments.
     * @param first a Time
     * @param second a Time
     * @return an int where 0 means they are the same
     *                      - means first > second
     *                      + means first < second
     */
    @Override
    public int compare(final Time first, final Time second) {
        int hourCompare = second.getHour() - first.getHour();
        if (hourCompare != 0) {
            return hourCompare;
        }
        int minuteCompare = second.getMinute() - first.getMinute();
        if (minuteCompare != 0) {
            return minuteCompare;
        }
        return second.getSecond() - first.getSecond();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        TimeComparator timeComparator = new TimeComparator();
        Time morning = new Time(6, 30, 34);
        Time evening = new Time(18, 50, 22);
        System.out.println(timeComparator.compare(morning, evening));
        System.out.println(morning.compareTo(evening));

        ArrayList<Time> demo = new ArrayList<>();
        demo.add(morning);
        demo.add(evening);
        demo.sort(timeComparator);
        System.out.println(demo);
        demo.sort(null);
        System.out.println(demo);

    }
}
