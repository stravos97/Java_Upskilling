package strings;

public class App {
    public static void main(String[] args) {
        String name = "   Nish   ";
        char c = name.charAt(4);
        name = name.toLowerCase();
        name = name.trim();
        c = name.charAt(3);
        System.out.println(name);

        System.out.println();
        System.out.println(stringExercise("  Java list fundamentals "));

    }

    public static String stringExercise(String myString)
    {
        String name2 = "";
        name2 = myString.trim();
        name2= name2.toUpperCase();
        name2 = name2.replaceAll("[LT]", "*");
        int index = name2.indexOf('N');
        String finalString = "";
        finalString = name2.substring(0, index+ 1 );

        return finalString;
    }
}

