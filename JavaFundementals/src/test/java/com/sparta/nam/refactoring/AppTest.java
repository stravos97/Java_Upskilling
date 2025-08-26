package com.sparta.nam.refactoring;


import org.junit.jupiter.api.*;

public class AppTest {

//    @Test
//    @DisplayName("First test")
//    public void firstTest() {
//        Assertions.assertEquals(true, false);
//    }

    @Test
    @DisplayName("getGreeting, when given a time of 7, returns good morning")
    public void getGreeting_GivenATimeOf7_ReturnsGoodMorning(){
        //Arrange
        int time = 7;
        String expected = "Good morning!";

        //Act
        String actual = App.getGreeting(time);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getGreeting, when given a time of 16, returns good afternoon")
    public void getGreeting_GivenATimeOf16_ReturnsGoodAfternoon(){
        //Arrange
        int time = 16;
        String expected = "Good afternoon!";

        //Act
        String actual = App.getGreeting(time);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getGreeting, when given a time of 21, returns good evening")
    public void getGreeting_GivenATimeOf21_ReturnsGoodEvening(){
        //Arrange
            int time = 21;
            String expected = "Good evening!";
        //Act
            String actual = App.getGreeting(time);
        //Assert
            Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("getGreeting, when given a time of -3, returns good evening")
    public void getGreeting_GivenATimeOf_Negative_3_ReturnsGoodEvening(){
        //Arrange
        int time = -3;
        String expected = "Good evening!";

        //Act
        String actual = App.getGreeting(time);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

}
