package controlflows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class SelectionTests {

    @ParameterizedTest
    @ValueSource(ints = {0,40,64})
    public void givenAMarkLessThan65_getGradeConditionalOperators_ReturnsFail(int mark){
        Assertions.assertEquals("Fail", Selection.getGradeConditionalOperators(mark));
    }

    @ParameterizedTest
    @ValueSource(ints = {85, 95})
    public void givenAMarkGreaterThan65_getGradeConditionalOperators_ReturnsDistinction(int mark){
        Assertions.assertEquals("Distinction", Selection.getGradeConditionalOperators(mark));
    }

    @ParameterizedTest
    @ValueSource(ints = {65, 84})
    public void givenAMarkBetween65And84_getGradeConditionalOperators_ReturnsPass(int mark){
        Assertions.assertEquals("Pass", Selection.getGradeConditionalOperators(mark));
    }

    //need tests for case statements


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




//    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100})
//    public void givenAMarkBetween0And100_getPriority_ReturnsCorrectPriority(int level){
//        String expectedPriority = level >= 95 ? "Code Red" : (level >= 85 ? "Code Red" : (level >= 75 ? "Code Red" : (level >= 65 ? "Code Red" : (level >= 55 ? "Code Red" : (level >= 45 ? "Code Red" : (level >= 35 ? "Code Red" : (level >= 25 ? "Code Red" : (level >= 15 ? "Code Red" : (level >= 5 ? "Code Red" : "Code Red")))))))));
//        Assertions.assertEquals(expectedPriority, Selection.priority(level));
//    }
}

