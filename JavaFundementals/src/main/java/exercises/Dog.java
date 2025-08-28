package exercises;

import java.time.LocalDate;

public class Dog extends Animal2{

    private final String favouriteGame;

    public Dog(String name, int year, int month, int day, String favouriteGame)
    {
        super(name, year, month, day);
        this.favouriteGame = favouriteGame;
        speak();
    }

    @Override
    public String speak() {
        return "Woof!";
    }

    public String getFavouriteGame()
    {
        return favouriteGame;
    }

    @Override
    public String toString() {
        return super.toString() + " and its favourite game is " + favouriteGame;
    }
}
