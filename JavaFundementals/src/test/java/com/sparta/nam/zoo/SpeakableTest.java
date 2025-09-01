package com.sparta.nam.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpeakableTest {

    @Test
    @DisplayName("All animals implement Speakable interface")
    public void allAnimalsImplementSpeakableTest() {
        Lion lion = new Lion("Simba", 5);
        Zebra zebra = new Zebra("Marty", 3);
        Elephant elephant = new Elephant("Dumbo", 8);
        Monkey monkey = new Monkey("George", 4);
        
        List<Animal> animals = Arrays.asList(lion, zebra, elephant, monkey);
        
        for (Animal animal : animals) {
            Assertions.assertTrue(animal instanceof Speakable, 
                animal.getClass().getSimpleName() + " should implement Speakable");
        }
    }

    @Test
    @DisplayName("All staff implement Speakable interface")
    public void allStaffImplementSpeakableTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper zookeeper = new Zookeeper("John", employmentDate, startTime, endTime);
        
        Assertions.assertTrue(zookeeper instanceof Speakable);
    }

    @Test
    @DisplayName("Polymorphic behavior through Speakable interface")
    public void polymorphicBehaviorTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Speakable> speakableThings = Arrays.asList(
            new Lion("Simba", 5),
            new Zebra("Marty", 3),
            new Elephant("Dumbo", 8),
            new Monkey("George", 4),
            new Zookeeper("John", employmentDate, startTime, endTime)
        );
        
        List<String> expectedMessages = Arrays.asList(
            "Roar! I'm the king of the jungle!",
            "Neigh! Look at my stripes!",
            "Trumpet! I never forget!",
            "Ooh ooh ah ah! I love bananas!",
            "Hello, I'm John, your zookeeper today!"
        );
        
        for (int i = 0; i < speakableThings.size(); i++) {
            String actualMessage = speakableThings.get(i).talk();
            String expectedMessage = expectedMessages.get(i);
            
            Assertions.assertEquals(expectedMessage, actualMessage, 
                "Message from " + speakableThings.get(i).getClass().getSimpleName() + " should match expected");
        }
    }

    @Test
    @DisplayName("Speakable interface talk method works in ArrayList loop")
    public void speakableInArrayListLoopTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        ArrayList<Speakable> zooThings = new ArrayList<>();
        zooThings.add(new Lion("Simba", 5));
        zooThings.add(new Zebra("Marty", 3));
        zooThings.add(new Zookeeper("John", employmentDate, startTime, endTime));
        
        List<String> messages = new ArrayList<>();
        for (Speakable speakable : zooThings) {
            messages.add(speakable.talk());
        }
        
        Assertions.assertEquals(3, messages.size());
        Assertions.assertTrue(messages.contains("Roar! I'm the king of the jungle!"));
        Assertions.assertTrue(messages.contains("Neigh! Look at my stripes!"));
        Assertions.assertTrue(messages.contains("Hello, I'm John, your zookeeper today!"));
    }

    @Test
    @DisplayName("Speakable reference can hold different object types")
    public void speakableReferencePolymorphismTest() {
        Speakable speakable1 = new Lion("Simba", 5);
        Speakable speakable2 = new Zookeeper("John", LocalDate.of(2020, 3, 15), 
                                             LocalTime.of(8, 0), LocalTime.of(16, 0));
        
        Assertions.assertEquals("Roar! I'm the king of the jungle!", speakable1.talk());
        Assertions.assertEquals("Hello, I'm John, your zookeeper today!", speakable2.talk());
    }

    @Test
    @DisplayName("Mixed animals and staff in Speakable list maintain correct behavior")
    public void mixedSpeakableListTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Speakable> mixedList = Arrays.asList(
            new Lion("King", 6),
            new Zookeeper("Alice", employmentDate, startTime, endTime),
            new Monkey("Curious", 2),
            new Zookeeper("Bob", employmentDate, startTime, endTime),
            new Elephant("Heavy", 10)
        );
        
        int animalCount = 0;
        int staffCount = 0;
        
        for (Speakable speakable : mixedList) {
            String message = speakable.talk();
            Assertions.assertNotNull(message);
            Assertions.assertFalse(message.isEmpty());
            
            if (speakable instanceof Animal) {
                animalCount++;
            } else if (speakable instanceof Staff) {
                staffCount++;
            }
        }
        
        Assertions.assertEquals(3, animalCount);
        Assertions.assertEquals(2, staffCount);
    }
}