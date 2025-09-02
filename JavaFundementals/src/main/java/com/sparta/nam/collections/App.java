package com.sparta.nam.collections;



import oop.Member;

import java.util.*;

public class App {

    public static void main(String[] args) {
        // Array Lists
        List<String> nameList = new ArrayList<>();
        nameList.add("Nish");
        nameList.add("Nash");
        nameList.add("Nosh");

        List<Integer> nums = new ArrayList<>(List.of(1,2,3,4)); // int --> Integer
        for(var num : nums){
            System.out.println(num); // Integer --> int
        }

        Integer [] ints = {1,2,3,4,5};
        var arrList = Arrays.asList(ints);

        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("The original list is: " + list);
        list.add(2, 7);
        System.out.println("We have added the number 7 at index 2 now: " + list);
        System.out.println("The reversed list is: " + list.reversed());
        System.out.println("The original list is: " + list);
        list.remove(1);
        System.out.println("We have removed the element at index position 1 now: " + list);

        // HashSet (revisit)

        HashSet<Member> memberSet = new HashSet<>();
        memberSet.add(new Member("Nish", "Mandal", 2025,3,12));
        memberSet.add(new Member("Nish", "Mandal", 2025,3,12));
        memberSet.add(new Member("Hash", "Mandol", 2023,3,13));
        memberSet.add(new Member("Nash", "Cheded", 2025,3,13));
        System.out.println("memberSet: ");
        for(Member m : memberSet){
            System.out.println(m);
        }

        if(memberSet.contains(new Member("Nish", "Mandal", 2025,3,12))){
            System.out.println("Nish is in the set");
        } else {
            System.out.println("Nish is not in the set");
        }



        // Queues and Stacks
        // HashMaps (activitiy)
        // Collections activity

        System.out.println(digitCount("hello 123"));
    }


    public static HashSet<Integer> makeFiveSet(int max)
    {
        HashSet<Integer> integerHashSet = new HashSet<>();
        int divisible = 5;
        for(int i =1; i <= max; i++)
        {
            if(i % divisible == 0)
            {
                integerHashSet.add(i);
            }
        }
        return integerHashSet;
    }


    public static List<String> longWordList(String phrase)
    {
        String[] string = phrase.split(",\\s*");
        List<String> phraseList = new ArrayList<>();

        for (String arrayElement : string)
        {
            if(arrayElement.length() >= 5)
            {
                phraseList.add(arrayElement);
            }
        }
        return phraseList;
    }

    /**
     * Every number starts as 0 and we add +1 to it everytime we see it in our string into our hashmap
     * The critical part happens BEFORE we start counting, in the initialization phase. We first create entries for ALL ten digits (0 through 9) and set each one to zero. This ensures that digitCounts.get(ch) will never return null - it will always find an existing entry with some count, even if that count is zero.
     * @param phrase
     * @return
     */
    public static Map<Character, Integer> digitCount(String phrase) {
        //you are given a string. we first need to change it to make it iterable e.g. char array
        //we iterate through the char array ignoring letters and focusing on numbers
        // for our hashmap we are a using a key value pair. the keys for the map are digits 0-9.
        //the values of the map are how many times that number repeated in the string/list
        //our final output is a series of key value pairs showing how many times a number is in the list


        Map<Character, Integer> numberMap = new HashMap<>(); //Character represents key, Integer represents value
        //we need to now create all of JUST the keys
        for (int i = 0; i <= 9; i++) {
//            char numToChar = (char) i; //wrong
//            char numToChar = (char) ('0' + i); //why does this work???
            char numToChar = Character.forDigit(i, 10);
            numberMap.put(numToChar, 0);
        }

        //We are looping through the string array, and only checking if the characters of the string are digits
        for(int i = 0; i < phrase.length(); i++ )
        {
            char eachCharOfString = phrase.charAt(i);
            if(Character.isDigit(eachCharOfString))
            {
                numberMap.put(eachCharOfString, numberMap.get(eachCharOfString) + 1);
            }
        }
        return numberMap;
    }
}