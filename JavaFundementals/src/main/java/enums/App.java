package enums;

public class App {

    public static void main(String[] args) {
        Day dayOfTheWeek = Day.SUNDAY;

        if(dayOfTheWeek == Day.SATURDAY || dayOfTheWeek == Day.SUNDAY){
            System.out.println("It's the weekend");
        } else {
            System.out.println("It's a weekday!");
        }


    }
}

