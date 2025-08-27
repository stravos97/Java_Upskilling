package enums;

public class DayOfWeek {
    public static void main(String[] args) {
        Day day = Day.FRIDAY;

        switch (day) {
            case day.MONDAY:
                System.out.println("It's Monday!");
                break;
            case day.TUESDAY:
                System.out.println("It's Tuesday!");
                break;
            case day.WEDNESDAY:
                System.out.println("It's Wednesday!");
                break;
            case day.THURSDAY:
                System.out.println("It's Thursday!");
                break;
            case day.FRIDAY:
                System.out.println("It's Friday!");
                break;
            case day.SATURDAY:
                System.out.println("It's Saturday!");
                break;
            case day.SUNDAY:
                System.out.println("It's Sunday!");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
