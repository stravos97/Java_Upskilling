package oop;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {
        Member nish = new Member("Nish", "Mandal",2025,1,1);
        Member haashim = new Member("Haashim", "Alvi",2024,1,1);
        Member tom = new Member("Tom", "Smith",2023,1,1);

//        System.out.println(nish.getFullName());
//        System.out.println(haashim.getLastName());
//        System.out.println(tom.getFirstName());
//        System.out.println(haashim.getMemberDays());

        Member[] array = {nish, haashim, tom};

        for(Member arrayElement : array)
        {
            System.out.println(arrayElement.getFullName());
            System.out.println(arrayElement.getMemberDays());
        }

        // create a few more member objects
        // print out their names, using the getter methods
        // prinout the days since they have joined
        // create an array of member objects, loop through them, and get their full name
    }
}
