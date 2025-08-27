package oop;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Member haashim = new Member("Haashim", "Alvi", LocalDate.of(2023, 1, 1));
        System.out.println(haashim);
    }
}
