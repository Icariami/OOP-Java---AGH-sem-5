import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.time.format.TextStyle;
import java.time.DayOfWeek;
import java.time.Month;

public class Calendar{

    public static void main(String[] args){

        LocalDate today = LocalDate.now();
        System.out.println("Today is: " + today);


        System.out.print("Najblizszy dzien programisty: ");
        if(today.getDayOfYear() > 256){
            System.out.println(LocalDate.ofYearDay(2024, 256));
        }
        else{
            System.out.println(LocalDate.ofYearDay(2023, 256));
        }


        System.out.println("\n      " + today.getMonth().getDisplayName(TextStyle.SHORT, new Locale("pl")) + " " + LocalDate.now().getYear());



        for(var i : DayOfWeek.values()){
            System.out.print("  " + i.getDisplayName(TextStyle.NARROW, new Locale("pl")));
        }
        System.out.println();

        LocalDate day = LocalDate.of(today.getYear(), today.getMonth(), 1);
        var dayy = day.getDayOfWeek().getValue();

        for (int i = 0; i < dayy-1; i++) {
            System.out.print("   ");
        }

        while(day.getMonth() == today.getMonth()){
            System.out.printf("%3d", day.getDayOfMonth());
            if(day.getDayOfWeek() == DayOfWeek.SUNDAY){
                     System.out.println();
            }
            day = day.plusDays(1);
        }
        System.out.println();

        if(args[1].equals("9")){
            LocalDate day2 = LocalDate.of(today.getYear(), 9, 1);
            var dayy2 = day.getDayOfWeek().getValue();
            System.out.println("\n      " + day2.getMonth().getDisplayName(TextStyle.SHORT, new Locale("pl")) + " " + LocalDate.now().getYear());



        for(var i : DayOfWeek.values()){
            System.out.print("  " + i.getDisplayName(TextStyle.NARROW, new Locale("pl")));
        }
        System.out.println();



        for (int i = 0; i < dayy2-1; i++) {
            System.out.print("   ");
        }

        while(day2.getMonth() == Month.SEPTEMBER){
            System.out.printf("%3d", day2.getDayOfMonth());
            if(day2.getDayOfWeek() == DayOfWeek.SUNDAY){
                     System.out.println();
            }
            day2 = day2.plusDays(1);
        }
        System.out.println();
        }

    }
}
