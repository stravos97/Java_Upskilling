package com.sparta.nam.refactoring;

public class FilmClassification {

//    public static void main(String[] args) {
//        System.out.println(getClassificationsByAge(10));
//    }


    /**
     * Logic wrong fix
     * @param ageOfViewer
     * @return
     */
    public static String getClassificationsByAge(int ageOfViewer)
    {
        String result;
        if (ageOfViewer <= 12)
        {
            return result = "U, PG, 12A films are available.";
        }
        else if (ageOfViewer < 15)
        {
            return result = "U, PG, 12, 12A films are available.";
        }
        else if (ageOfViewer <= 17)
        {
            return result = "U, PG, 12, 12A, 15 films are available.";
        }
        else
        {
            return result = "U, PG, 12, 12A, 15, 18, R18 films are available.";
        }
//        return result;
    }
}
