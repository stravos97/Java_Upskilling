package exercises;

import java.time.LocalDate;

public class AnimalApp {
    public static void main(String[] args) {
        Animal animal = new Animal("Lion", 2010, 1, 1);
        System.out.println("The animal name is " + animal.getName());
        System.out.println("The animal age is " + animal.getAge());
        animal.setName("Tiger");
        animal.setBirthDate(LocalDate.of(2015, 1, 1));
        System.out.println("The animal name is " + animal.getName());
        System.out.println("The animal age is " + animal.getAge());
        System.out.println(animal.toString());
    }
}
