import com.sparta.nam.collections.App;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        String[] testInputs = {
            "apple, banana, cherry, date, eggplant, fig, grape, honeydew, ice cream, jackfruit",
            "kiwi, lemon, mango, nectarine, orange, papaya, quince, raspberry, strawberry, tangerine",
            "ugli fruit, watermelon, xigua, yuzu, zucchini"
        };
        
        for (int i = 0; i < testInputs.length; i++) {
            System.out.println("\n=== Test Case " + (i + 1) + " ===");
            String input = testInputs[i];
            List<String> result = App.longWordList(input);
            System.out.println("Result: " + result);
        }
    }
}