package datetime;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate nextWeek = now.plusWeeks(1);
        System.out.println(nextWeek);
        LocalDate anotherDate = now.withDayOfMonth(5).withYear(2025);
        System.out.println(anotherDate);
        if(anotherDate.getMonth().equals(nextWeek.getMonth())){
            System.out.println("Yes they are in the same moth");
        } else {
            System.out.println("Different months");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var mydate = LocalDate.parse("09-10-2002", formatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMMM, yy");

        System.out.println(mydate.toString());
        System.out.println(mydate.format(outputFormatter));


        /**
         * Debug THISS
         */

//        LocalDate nishBday = LocalDate.of(1989, 11,2);
//        int nishYear = nishBday.getYear();
//        int nishMonth = nishBday.getMonthValue();
//        int nishDay = nishBday.getDayOfMonth();
//
//        LocalDate getCurrentDate = LocalDate.now();
//        int currentYear = getCurrentDate.getYear();
//        int currentMonth = getCurrentDate.getMonthValue();
//        int currentDay = getCurrentDate.getDayOfMonth();
//
//
//        int nishActualBirthdayYear = getCurrentDate.minusYears(nishYear).getYear();
//        int nishActualBirthdayMonth = getCurrentDate.minusMonths(nishMonth).getMonthValue();
//        int nishActualBirthdayDay = getCurrentDate.minusDays(nishDay).getDayOfMonth();
//
//        LocalDate nishActualBirthday = LocalDate.of(nishActualBirthdayYear, nishActualBirthdayMonth, nishActualBirthdayDay);
//        System.out.println(nishActualBirthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Work out how old I am
        // How many days are there until my Birthday this year

        LocalDate nishBday = LocalDate.of(1989, 11,2);

        long daysDifference = ChronoUnit.DAYS.between(nishBday, LocalDate.now());
        int ageInYears = (int) (daysDifference / 365.25);
        System.out.println(ageInYears);

        LocalDate nextBirthday = LocalDate.of(LocalDate.now().getYear(), nishBday.getMonth(), nishBday.getDayOfMonth());
        long daysUntilBirthday = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday);
        System.out.println(daysUntilBirthday);

    }
}
