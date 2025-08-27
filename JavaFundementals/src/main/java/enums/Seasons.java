package enums;

public class Seasons {
    public static void main(String[] args) {
        Season season = Season.SUMMER;
        if(season.equals(Season.SPRING))
        {
            System.out.println("The daffodils are out");
        }
        else
        {
            System.out.println("The leaves are falling");
        }
        for(Season value : Season.values())
        {
            System.out.println(value);
        }
    }
}
