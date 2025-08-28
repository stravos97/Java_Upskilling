package oop;

import exercises.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AnimalTests {

    @Test
    @DisplayName("getName returns the correct name")
    public void getNameTest(){
        // Arrange
        Animal animal = new Animal("Lion", 2010, 1, 1);
        // Act
        String result = animal.getName();
        // Assert
        Assertions.assertEquals("Lion", result);
    }

    @Test
    @DisplayName("getAge returns the correct age")
    public void getAgeTest()
    {
        // Arrange
        Animal animal = new Animal("Lion", 2010, 1, 1);
        // Act
        int age = animal.getAge();
        //Assert
        Assertions.assertEquals(15, age);
    }

    @Test
    @DisplayName("setBirthdate sets the newly created age")
    public void setBirthDateTest()
    {
        //Arrange
        Animal animal = new Animal("Lion", 2010, 1, 1);
        //Act
        animal.setBirthDate(LocalDate.of(2005,1,1));
        //Assert
        Assertions.assertEquals(20, animal.getAge());
    }

    @Test
    @DisplayName("setName set the newly created name")
    public void setNameTest()
    {
        //Arrange
        Animal animal = new Animal("Lion", 2010, 1, 1);
        //Act
        animal.setName("Cat");
        //Assert
        Assertions.assertEquals("Cat", animal.getName());
    }
}
