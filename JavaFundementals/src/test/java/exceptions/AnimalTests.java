package exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @DisplayName("Should throw ParseException for invalid date formats")
    @ValueSource(strings = {
            "01-January-2022",
            "02-02-TwentyTwentyTwo",
            "3rd of March 2022",
            "2022/13/01",
            "2022-02-30",
            "not-a-date"
    })
    public void setVaccinationDate_InvalidFormats_ThrowsParseException(String invalidDateString) {
        // Arrange
        Animal sut = new Animal();

        // Act
        var exception = Assertions.assertThrows(
                ParseException.class,
                () -> sut.setVaccinationDate(invalidDateString),
                "Expected ParseException for invalid date: " + invalidDateString
        );

        String expectedMessage = "Invalid date format: " + invalidDateString + ". Use dd-MM-yyyy";
        String actualMessage = exception.getMessage();

        //Assert
        Assertions.assertFalse(exception.getMessage().isEmpty());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    @DisplayName("Should throw IllegalArgumentException for null vaccination date")
    public void setVaccinationDate_Null_ThrowsIllegalArgumentException() {
        // Arrange
        Animal sut = new Animal();

        // Act
        var nullException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> sut.setVaccinationDate(null),
                "Expected IllegalArgumentException for null vaccination date"
        );

        var emptyStringException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> sut.setVaccinationDate(""),
                "Expected IllegalArgumentException for empty vaccination date"
        );

        String expectedMessage = "Vaccination date cannot be null or empty";


        // Assert
        Assertions.assertEquals(expectedMessage, nullException.getMessage());
        Assertions.assertEquals(expectedMessage, emptyStringException.getMessage());
    }
}
