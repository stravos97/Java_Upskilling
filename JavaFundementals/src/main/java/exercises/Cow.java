package exercises;

import java.time.LocalDate;

public class Cow extends Animal2{

    private final String favouriteDrink;

    public Cow(String name, int year, int month, int day, String favouriteDrink)
    {
        super(name, year, month, day);
        this.favouriteDrink = favouriteDrink;
    }

    @Override
    public String speak() {
        return "Moo!";
    }

    public String getFavouriteDrink() {
        return favouriteDrink;
    }

    @Override
    public String toString() {
        return super.toString() + "\nand its favourite drink is " + favouriteDrink;
    }
}
