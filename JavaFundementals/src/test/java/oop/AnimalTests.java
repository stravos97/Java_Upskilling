package oop;

import exercises.Animal;
import exercises.Cow;
import exercises.Dog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AnimalTests {
//
//    @Test
//    @DisplayName("getName returns the correct name")
//    public void getNameTest(){
//        // Arrange
//        Animal animal = new Animal("Lion", 2010, 1, 1);
//        // Act
//        String result = animal.getName();
//        // Assert
//        Assertions.assertEquals("Lion", result);
//    }
//
//    @Test
//    @DisplayName("getAge returns the correct age")
//    public void getAgeTest()
//    {
//        // Arrange
//        Animal animal = new Animal("Lion", 2010, 1, 1);
//        // Act
//        int age = animal.getAge();
//        //Assert
//        Assertions.assertEquals(15, age);
//    }
//
//    @Test
//    @DisplayName("setBirthdate sets the newly created age")
//    public void setBirthDateTest()
//    {
//        //Arrange
//        Animal animal = new Animal("Lion", 2010, 1, 1);
//        //Act
//        animal.setBirthDate(LocalDate.of(2005,1,1));
//        //Assert
//        Assertions.assertEquals(20, animal.getAge());
//    }
//
//    @Test
//    @DisplayName("setName set the newly created name")
//    public void setNameTest()
//    {
//        //Arrange
//        Animal animal = new Animal("Lion", 2010, 1, 1);
//        //Act
//        animal.setName("Cat");
//        //Assert
//        Assertions.assertEquals("Cat", animal.getName());
//    }


    @Test
    @DisplayName("getName returns the correct name")
    public void getNameTest(){
        // Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        // Act
        String cowNameResult = cow.getName();
        String dogNameResult = dog.getName();
        // Assert
        Assertions.assertEquals("Daisy", cowNameResult);
        Assertions.assertEquals("John", dogNameResult);
    }

    @Test
    @DisplayName("getAge returns the correct age")
    public void getAgeTest()
    {
        // Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        // Act
        int cowAgeResult = cow.getAge();
        int dogAgeResult = dog.getAge();
        //Assert
        Assertions.assertEquals(17, cowAgeResult);
        Assertions.assertEquals(12, dogAgeResult);
    }

    @Test
    @DisplayName("setBirthdate sets the newly created age")
    public void setBirthDateTest()
    {
        //Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        //Act
        cow.setBirthDate(LocalDate.of(2005,1,1));
        dog.setBirthDate(LocalDate.of(2002,1,1));
        //Assert
        Assertions.assertEquals(20, cow.getAge());
        Assertions.assertEquals(23, dog.getAge());
    }

    @Test
    @DisplayName("setName set the newly created name")
    public void setNameTest()
    {
        //Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        //Act
        cow.setName("Cat");
        dog.setName("Tom");
        //Assert
        Assertions.assertEquals("Cat", cow.getName());
        Assertions.assertEquals("Tom", dog.getName());
    }

    @Test
    @DisplayName("get Cow favourite drink")
    public void geFavouriteDrinkTest()
    {
        //Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Coke");
        //Act
        cow.getFavouriteDrink();
        //Assert
        Assertions.assertEquals("Coke", cow.getFavouriteDrink());
    }

    @Test
    @DisplayName("get Dog favourite toy")
    public void geFavouriteGameTest()
    {
        //Arrange
        Dog dog = new Dog("John", 2013, 6, 1, "Run");
        //Act
        dog.getFavouriteGame();
        //Assert
        Assertions.assertEquals("Run", dog.getFavouriteGame());
    }

    @Test
    @DisplayName("get Dog and Cow toSpeak() method")
    public void geToSpeakTest()
    {
        //Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        //Act
        dog.speak();
        cow.speak();
        //Assert
        Assertions.assertEquals("Moo!", cow.speak());
        Assertions.assertEquals("Woof!", dog.speak());
    }

    @Test
    @DisplayName("get Dog and Cow toString() method")
    public void geToStringTest()
    {
        //Arrange
        Cow cow = new Cow("Daisy", 2008, 7, 1, "Water");
        Dog dog = new Dog("John", 2013, 6, 1, "Fetch");
        //Act
        dog.toString();
        cow.toString();
        //Assert
        Assertions.assertEquals("The name of the animal is: Daisy\nThe age of the animal is: 17 years old.\n, and it can speak! : Moo!\nand its favourite drink is Water", cow.toString());
        Assertions.assertEquals("The name of the animal is: John\nThe age of the animal is: 12 years old.\n, and it can speak! : Woof! and its favourite game is Fetch", dog.toString());
    }
}
