package com.sparta.nam.zoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("🦁 Welcome to Nam's Zoo! 🦁\n");

        ArrayList<Speakable> zooThings = new ArrayList<>();

        Lion simba = new Lion("Simba", 5);
        Zebra marty = new Zebra("Marty", 3);
        Elephant dumbo = new Elephant("Dumbo", 8);
        Monkey george = new Monkey("George", 4);

        List<Animal> johnAnimals = Arrays.asList(simba, dumbo);
        List<String> johnEnclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        Zookeeper john = new Zookeeper("John", 
                                       LocalDate.of(2020, 3, 15), 
                                       LocalTime.of(8, 0), 
                                       LocalTime.of(16, 0),
                                       johnAnimals, 
                                       johnEnclosures);

        List<Animal> sarahAnimals = Arrays.asList(marty, george);
        List<String> sarahEnclosures = Arrays.asList("Zebra Plains", "Monkey Habitat");
        Zookeeper sarah = new Zookeeper("Sarah", 
                                        LocalDate.of(2019, 7, 10), 
                                        LocalTime.of(9, 0), 
                                        LocalTime.of(17, 0),
                                        sarahAnimals, 
                                        sarahEnclosures);

        zooThings.add(simba);
        zooThings.add(marty);
        zooThings.add(dumbo);
        zooThings.add(george);
        zooThings.add(john);
        zooThings.add(sarah);

        System.out.println("🗣️  Let's hear from everyone in the zoo:\n");
        for (Speakable speakableThing : zooThings) {
            System.out.println("• " + speakableThing.talk());
        }

        System.out.println("\n🧑‍🔬 Zookeeper Activities:\n");

        System.out.println("📋 " + john.feedAnimals());
        System.out.println("🧹 " + john.cleanEnclosure());
        System.out.println("🩺 " + john.checkAnimalHealth());

        System.out.println();

        System.out.println("📋 " + sarah.feedAnimals());
        System.out.println("🧹 " + sarah.cleanEnclosure("Monkey Habitat"));
        System.out.println("🩺 " + sarah.checkAnimalHealth());

        System.out.println("\n📊 Zoo Information:\n");
        System.out.println("🦁 Animals in the zoo:");
        List<Animal> allAnimals = Arrays.asList(simba, marty, dumbo, george);
        for (Animal animal : allAnimals) {
            System.out.println("   • " + animal.toString());
        }

        System.out.println("\n👥 Staff information:");
        System.out.println("   • " + john.toString());
        System.out.println("   • " + sarah.toString());

        System.out.println("\nThank you for visiting Nam's Zoo! 🎉");
    }
}