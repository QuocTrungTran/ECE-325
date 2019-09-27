import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class daysold {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) throws ParseException {
        // TODO: Assignment 1 -- write your code here.

        /*
         * today date, use it later
         */
        Calendar today = Calendar.getInstance();


        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
        /*
         * get date in type "Date" from the string input
         */
        Date date = input.parse(birthday);

        /*
         * get Calender date from the input
         */
        Calendar inputCalendar = input.getCalendar();

        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");

        /*
         * this is to print
         */
        String outputCalendar = output.format(date);

        /*
         * Reference for the following code:
         * https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
         */
        Instant previous, current;
        previous = inputCalendar.toInstant();
        current = today.toInstant();
        long gap = ChronoUnit.DAYS.between(previous, current);


        if (inputCalendar.after(today)) {
            System.out.println("Birthday: " + outputCalendar + "; " + "Today: " + output.format(new Date()) + " -- Wrong birthday.");
        } else {
            System.out.println("Birthday: " + outputCalendar + "; " + "Today: " + output.format(new Date()) + " -- You are " + gap + " days old." );
        }

    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) throws ParseException {
        days("2000-1-1");
        days("3000-1-1");           // This is a wrong birthday
    } // public static void main(String[] args)

}
