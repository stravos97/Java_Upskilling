package collections;

import com.sparta.nam.collections.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppTests {

    @Test
    @DisplayName("Given max value 20, makeFiveSet returns set with 5, 10, 15, 20")
    public void givenMaxValue20_makeFiveSet_ReturnsSetWith5_10_15_20()
    {
        //Arrange
        HashSet<Integer> integerHashSet = new HashSet<>(Set.of(5, 10, 15, 20));
        //Act
        HashSet<Integer> returnItems = App.makeFiveSet(20);

        //Assert
        Assertions.assertEquals(integerHashSet, returnItems);
    }

    @ParameterizedTest
    @DisplayName("Given max value of out of bounds, makeFiveSet returns empty set")
    @ValueSource(ints = {0, 4, Integer.MIN_VALUE})
    public void givenMaxValueOfOutOfBounds_makeFiveSet_ReturnsEmptySet(int maxScore)
    {

        //Arrange
        HashSet<Integer> integerHashSet = new HashSet<>(Set.of());
        //Act
        HashSet<Integer> returnItems = App.makeFiveSet(maxScore);
        //Assert
        Assertions.assertEquals(integerHashSet,returnItems);

    }

    @Test
    @DisplayName("Given max value of 5, makeFiveSet returns set with 5")
    public void givenMaxValue5_makeFiveSet_ReturnsSetWith5Only()
    {

        //Arrange
        HashSet<Integer> integerHashSet = new HashSet<>(Set.of(5));
        //Act
        HashSet<Integer> returnItems = App.makeFiveSet(5);
        //Assert
        Assertions.assertEquals(integerHashSet,returnItems);

    }

    /**
     *
     ⏺ This line is creating the expected result for your test by filtering the input data to match what your App.longWordList() method should return.

     What it does:

     phraseList.removeIf(arrayElement -> arrayElement.length() < 5);

     - removeIf(): A safe method that removes elements from the list without causing ConcurrentModificationException
     - arrayElement -> arrayElement.length() < 5: A lambda expression (predicate) that returns true for elements to remove
     - Result: Removes all words with fewer than 5 characters, leaving only words with 5+ characters

     Why you need it:

     Your test follows the Arrange-Act-Assert pattern:

     1. Arrange: Create input data ("apple, banana, cherry, date, eggplant, fig, grape, honeydew, ice cream, jackfruit")
     2. Act:
     - Filter the input to create expected result (phraseList.removeIf(...))
     - Call the method being tested (App.longWordList(phrase))
     3. Assert: Compare expected vs actual results

     Example with "apple, banana, cherry, date":

     - Before removeIf(): [apple, banana, cherry, date]
     - After removeIf(): [apple, banana, cherry] (removed "date" because it has 4 letters)
     - Your method should return: [apple, banana, cherry]
     - Test passes if both lists match

     Without this line, you'd be comparing the unfiltered input against the filtered output, which would always fail.


     * @param phrase
     */
    @ParameterizedTest
    @DisplayName("Given phrase with mixed length words, longWordList returns only words with five or more letters")
    @CsvSource({
            "'apple, banana, cherry, date, eggplant, fig, grape, honeydew, ice cream, jackfruit'",
            "'kiwi, lemon, mango, nectarine, orange, papaya, quince, raspberry, strawberry, tangerine'",
            "'ugli fruit, watermelon, xigua, yuzu, zucchini'"
    })
    public void givenPhraseWithMixedLengthWords_longWordList_ReturnsOnlyWordsWithFiveOrMoreLetters(String phrase)
    {

        //Arrange
        List<String> phraseList = new ArrayList<>(List.of(phrase.split(",\\s*")));


        //Act
        phraseList.removeIf(arrayElement -> arrayElement.length() < 5); //lambda expression to GO over

        List<String> returnItems = App.longWordList(phrase);


        //Assert
        Assertions.assertEquals(phraseList,returnItems);

    }

    @Test
    @DisplayName("Given empty string, longWordList returns empty list")
    public void givenEmptyString_longWordList_ReturnsEmptyList()
    {

        //Arrange
        List<String> phraseList = new ArrayList<>(List.of());


        //Act
        List<String> returnItems = App.longWordList("");


        //Assert
        Assertions.assertEquals(phraseList,returnItems);

    }

    /**
     * However, your test method is only accepting a single String phrase parameter, so JUnit is treating each comma-separated value as a separate test case rather than as elements of an array.
     * @param phrase
     */
    @ParameterizedTest
    @DisplayName("Given phrase with only short words, longWordList returns empty list")
    @CsvSource({
            "'cat, dog, rat, pig, hen'",
            "'ant, bee, cow, bat, owl'",
            "'fox, cod, emu, jay, elk'"
    })
    public void givenPhraseWithAllShortWords_longWordList_ReturnsEmptyList(String phrase)
    {

        //Arrange
        List<String> phraseList = new ArrayList<>(List.of(phrase.split(",\\s*")));


        //Act
        phraseList.removeIf(arrayElement -> arrayElement.length() < 5); //lambda expression to GO over

        List<String> returnItems = App.longWordList(phrase);


        //Assert
        Assertions.assertEquals(phraseList,returnItems);

    }

    @ParameterizedTest
    @DisplayName("Given phrase with only long words, longWordList returns all words")
    @CsvSource({
            "'gopher, peanut, turtle, walnut, rabbit'",
            "'eagles, gazebo, python, jaguar, iguana'",
            "'turtle, iguana, alpaca, jaguar, pigeon'"
    })
    public void givenPhraseWithAllLongWords_longWordList_ReturnsAllWords(String phrase)
    {

        //Arrange
        List<String> phraseList = new ArrayList<>(List.of(phrase.split(",\\s*")));


        //Act
        phraseList.removeIf(arrayElement -> arrayElement.length() < 5); //lambda expression to GO over

        List<String> returnItems = App.longWordList(phrase);


        //Assert
        Assertions.assertEquals(phraseList,returnItems);

    }

    @ParameterizedTest
    @DisplayName("Given phrase with duplicate long words, longWordList returns duplicates in order")
    @CsvSource({
            "'turtle, turtle, iguana, jaguar, jaguar'",
            "'python, python, python, python, python'",
            "'monkey, monkey, gopher, gopher, turtle'"
    })
    public void givenPhraseWithDuplicateLongWords_longWordList_ReturnsDuplicatesInOrder(String phrase)
    {

        //Arrange
        List<String> phraseList = new ArrayList<>(List.of(phrase.split(",\\s*")));
//        System.out.println("Initial phraseList: " + phraseList);



        //Act
        phraseList.removeIf(arrayElement -> arrayElement.length() < 5); //lambda expression to GO over
//        System.out.println("After removeIf: " + phraseList);


        List<String> returnItems = App.longWordList(phrase);
//        System.out.println("returnItems: " + returnItems);


        //Assert
        Assertions.assertEquals(phraseList,returnItems);

    }

    @ParameterizedTest
    @DisplayName("Given phrase with long words in specific order, longWordList preserves insertion order")
    @CsvSource({
            "'zebra, apple, monkey, elephant, turtle'"
    })
    public void givenPhraseWithLongWordsInSpecificOrder_longWordList_PreservesInsertionOrder(String phrase)
    {
        //Arrange
        List<String> expectedOrder = List.of("zebra", "apple", "monkey", "elephant", "turtle");

        //Act
        List<String> actualResult = App.longWordList(phrase);

        //Assert
        Assertions.assertEquals(expectedOrder, actualResult, "ArrayList should preserve insertion order");

    }

}
