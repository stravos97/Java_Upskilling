package oop;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {
//        Member nish = new Member("Nish", "Mandal",2025,1,1);
//        Member haashim = new Member("Haashim", "Alvi",2024,1,1);
//        Member tom = new Member("Tom", "Smith",2023,1,1);
//
////        System.out.println(nish.getFullName());
////        System.out.println(haashim.getLastName());
////        System.out.println(tom.getFirstName());
////        System.out.println(haashim.getMemberDays());
//
//        Member[] array = {nish, haashim, tom};
//
//        for(Member arrayElement : array)
//        {
//            System.out.println(arrayElement.getFullName());
//            System.out.println(arrayElement.getMemberDays());
//        }

        BaseballMember zainab = new BaseballMember("Zainab", "Farooq", 2022,12,6, "fielder");
        System.out.println(zainab.getFullName());
        System.out.println(zainab.getMemberDays());
        System.out.println(zainab.getPosition());
        zainab.setPosition("pitcher");
        System.out.println(zainab.getPosition());

        Shape rectangle = new Rectangle(5,5);
        System.out.println(rectangle);

        Shape circle = new Circle(5);
        System.out.println(circle);

        Shape[] shapes = {rectangle, circle};

        for(Shape shape : shapes){
            System.out.println(shape);
        }
    }
}
