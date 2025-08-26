package com.sparta.nam.refactoring;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {

//    @Test
//    @DisplayName("First test")
//    public void firstTest() {
//        Assertions.assertEquals(true, false);
//    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11})
    @DisplayName("getGreeting, when given a time of 5 or 11, returns good morning")
    public void getGreeting_GivenATimeFrom5To11_ReturnsGoodMorning(int time)
    {
        Assertions.assertEquals("Good morning!", App.getGreeting(time));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 18})
    @DisplayName("getGreeting, when given a time of 12 or 18, returns good afternoon")
    public void getGreeting_GivenATimeFrom12To18_ReturnsGoodAfternoon(int time)
    {
        Assertions.assertEquals("Good afternoon!", App.getGreeting(time));
    }

    /**
     * getGreeting, when given a time outside morning and afternoon ranges, returns good evening
     * Testing for the beginning and end of boundary for every possible time that the above doesn't cover and what should give good evening
     * @param time
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 4, 19, 23})
    @DisplayName("getGreeting, when given a time outside morning and afternoon ranges, returns good evening")
    public void getGreeting_GivenATimeOutsideMorningAndAfternoonRanges_ReturnsGoodEvening(int time)
    {
        Assertions.assertEquals("Good evening!", App.getGreeting(time));
    }

    @ParameterizedTest
    @CsvSource({
            "Good evening!, 2",
            "Good morning!, 8",
            "Good afternoon!, 15",
            "Good evening!, 21"
    })
    @DisplayName("getGetting, when given a time, returns an appropriate greeting")
    public void givenATime_Greeting_ReturnsAnAppropriateGreeting(String expected, int time){
        Assertions.assertEquals(expected, App.getGreeting(time));
    }

//    @Test
//    @DisplayName("getGreeting, when given a time of 7, returns good morning")
//    public void getGreeting_GivenATimeOf7_ReturnsGoodMorning(){
//        //Arrange
//        int time = 7;
//        String expected = "Good morning!";
//
//        //Act
//        String actual = App.getGreeting(time);
//
//        //Assert
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("getGreeting, when given a time of 16, returns good afternoon")
//    public void getGreeting_GivenATimeOf16_ReturnsGoodAfternoon(){
//        //Arrange
//        int time = 16;
//        String expected = "Good afternoon!";
//
//        //Act
//        String actual = App.getGreeting(time);
//
//        //Assert
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("getGreeting, when given a time of 21, returns good evening")
//    public void getGreeting_GivenATimeOf21_ReturnsGoodEvening(){
//        //Arrange
//            int time = 21;
//            String expected = "Good evening!";
//        //Act
//            String actual = App.getGreeting(time);
//        //Assert
//            Assertions.assertEquals(expected, actual);
//
//    }



}
