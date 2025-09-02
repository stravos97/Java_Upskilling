package exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.color.ICC_ColorSpace;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AnimalTests {

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "10,10"
    })
    @DisplayName("Give an age of 0 or above, setAge changes the age")
    public void setAgeHappyPath(int newAge, int expectedAge){
        Animal sut = new Animal();
        sut.setAge(newAge);
        Assertions.assertEquals(expectedAge, sut.getAge());
    }

    @Test
    @DisplayName("Given an age below zero, setAge throws an IllegalArgumentException")
    public void setAgeSadPath(){
        Animal sut = new Animal();
        // invoke a method, and return anything it throws
        // we then store it in the `exception` variable
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sut.setAge(-2) );
        Assertions.assertEquals("Age must not be negative: -2", exception.getMessage());
    }

    // Create tests for setName (happy and sad) and setVaccincation date (happy & sad)
    @Test
    @DisplayName("Happy path for set name, the Animal class sets the name to uppercase")
    public void setNameHappyPath()
    {
        Animal sut = new Animal();
        sut.setName("Haashim");
        Assertions.assertEquals("HAASHIM", sut.getName());
    }

    @Test
    @DisplayName("Sad path for set name")
    public void setNameSadPath()
    {
        Animal sut = new Animal();
        var exception = Assertions.assertThrows(NullPointerException.class, () -> sut.setName(null) );
        Assertions.assertEquals("Name must not be null", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Happy path for set vaccination date")
    @ValueSource(strings = {"01-01-2022", "02-02-2022", "03-03-2022"})
    public void setVaccinationDateHappyPath(String dateString) throws ParseException {

        //Arrange
        Animal sut = new Animal();
        Date formattedDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);

        //Act
        sut.setVaccinationDate(dateString);

        //Assert
        Assertions.assertEquals(formattedDate, sut.getVaccinationDate());

    }

    @ParameterizedTest
    @DisplayName("UnHappy path for set vaccination date")
    @ValueSource(strings = {"01-January-2022", "02-02-TwentyTwentyTwo", "3rd of March 2022"})
    public void setVaccinationDateUnHappyPath(String dateString) {

        //Arrange
        Animal sut = new Animal();

        //Assert
        var exception = Assertions.assertThrows(ParseException.class, () -> sut.setVaccinationDate(dateString));
        Assertions.assertEquals(ParseException.class, exception.getClass());

    }

}
