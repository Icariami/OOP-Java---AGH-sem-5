import java.time.LocalDate;
import java.util.Locale;
import java.time.format.TextStyle;
import java.time.DayOfWeek;
import java.time.Month;

/**
 * The Calendar class
 */
public class Calendar {

    /**
     * Main function.
     * Prints: today's date, closest software developer's day's date, and a Calendar.
     * By default, with no command-line arguments, prints the current month's calendar.
     * With -m <int number> arguments, prints the month with the given number of the current year.
     * With -m <month number> -y <year number>, prints the month and year with the given numbers.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args){

        LocalDate today = LocalDate.now();
        System.out.println("Today is: " + today);

        System.out.print("Closest software developer's day: ");
        if(today.getDayOfYear() > 256)
            System.out.println(LocalDate.ofYearDay(today.getYear() + 1, 256));
        else
            System.out.println(LocalDate.ofYearDay(today.getYear(), 256));

        int month_nr;
        Month m;
        int year_nr = today.getYear();
        if(args.length == 0) {
            m = today.getMonth();
        } else if (args[0].equals("-m") && args.length >= 2) {
            try {
                month_nr = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data entered. Month must be an integer.");
                return;
            }
            if (month_nr < 1 || month_nr > 12) {
                System.out.println("Incorrect data entered. Month must be between 1 and 12");
                return;
            }
            m = Month.of(month_nr);
            if (args.length == 4 && args[2].equals("-y")) {
                try {
                    year_nr = Integer.parseInt(args[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect data entered. Year must be an integer.");
                    return;
                }
            }
        } else {
            System.out.println("Incorrect data entered");
            return;
        }

        System.out.println("\n      " + m.getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + year_nr);
        for(var i : DayOfWeek.values()){
            System.out.print("  " + i.getDisplayName(TextStyle.NARROW, Locale.ENGLISH).toLowerCase());
        }
        System.out.println();

        LocalDate day = LocalDate.of(year_nr, m, 1);
        var day_of_week = day.getDayOfWeek().getValue();

        for (int i = 0; i < day_of_week - 1; i++) {
            System.out.print("   ");
        }

        while(day.getMonth() == m){
            System.out.printf("%3d", day.getDayOfMonth());
            if(day.getDayOfWeek() == DayOfWeek.SUNDAY){
                System.out.println();
            }
            day = day.plusDays(1);
        }
        System.out.println();
    }
}
