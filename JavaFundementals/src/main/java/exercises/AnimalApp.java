package exercises;

import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalApp {
    public static void main(String[] args) {
//        Animal animal = new Animal("Lion", 2010, 1, 1);
//        System.out.println("The animal name is " + animal.getName());
//        System.out.println("The animal age is " + animal.getAge());
//        animal.setName("Tiger");
//        animal.setBirthDate(LocalDate.of(2015, 1, 1));
//        System.out.println("The animal name is " + animal.getName());
//        System.out.println("The animal age is " + animal.getAge());
//        System.out.println(animal.toString());




          Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
          Dog dog = new Dog("John", 2013, 6, 1, "Fetch");

//        ArrayList<Animal2> animals = new ArrayList<>();
//        animals.add(cow);
//        animals.add(dog);
//
//        for(Animal2 animal : animals)
//        {
//            System.out.println(animal.toString());
//        }

        ArrayList<Animal2> animals = Animal2.getAllAnimals();

        for(Animal2 animal : animals)
        {
            System.out.println(animal.toString());
        }



    }
}
