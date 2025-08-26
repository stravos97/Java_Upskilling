package com.sparta.nam.refactoring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FilmClassificationTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11})
    @DisplayName("getRating, when the given age is between 0 and 11")
    public void getRating_GivenAAgeFrom0To11_Returns12AFilmsAvailable(int age)
    {
        Assertions.assertEquals("U, PG, 12A films are available.", FilmClassification.getClassificationsByAge(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 14})
    @DisplayName("getRating, when the given age is between 12 and 14")
    public void getRating_GivenAAgeFrom12To14_Returns18AFilmsAvailable(int age)
    {
        Assertions.assertEquals("U, PG, 12, 12A films are available.", FilmClassification.getClassificationsByAge(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 17})
    @DisplayName("getRating, when the given age is between 15 and 17")
    public void getRating_GivenAAgeFrom15To17_Returns18AFilmsAvailable(int age)
    {
        Assertions.assertEquals("U, PG, 12, 12A, 15 films are available.", FilmClassification.getClassificationsByAge(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 20, 50})
    @DisplayName("getRating, when the given age is 18, 20, 50")
    public void getRating_GivenAAgeOf18_Returns18AFilmsAvailable(int age)
    {
        Assertions.assertEquals("U, PG, 12, 12A, 15, 18, R18 films are available.", FilmClassification.getClassificationsByAge(age));
    }


//    /**
//     * Fix worng!!
//     * @param age
//     */
//    @ParameterizedTest
//    @ValueSource(ints = {-5, 1000})
//    @DisplayName("getRating, when the given age is -5, 100")
//    public void getRating_GivenAAgeOfNegative_ReturnsFailure(int age)
//    {
//        Assertions.assertEquals("U, PG, 12A films are available.", FilmClassification.getClassificationsByAge(age));
//    }




}
