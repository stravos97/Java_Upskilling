package com.sparta.nam.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZookeeperTest {

    @Test
    @DisplayName("Zookeeper creation with basic constructor")
    public void zookeeperBasicCreationTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals("John", john.getName());
        Assertions.assertEquals(employmentDate, john.getDateOfEmployment());
        Assertions.assertEquals(startTime, john.getShiftStartTime());
        Assertions.assertEquals(endTime, john.getShiftEndTime());
        Assertions.assertTrue(john.getAssignedAnimals().isEmpty());
        Assertions.assertTrue(john.getAssignedEnclosures().isEmpty());
    }

    @Test
    @DisplayName("Zookeeper creation with animals and enclosures")
    public void zookeeperFullCreationTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Animal> animals = Arrays.asList(
            new Lion("Simba", 5),
            new Elephant("Dumbo", 8)
        );
        List<String> enclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, animals, enclosures);
        
        Assertions.assertEquals(2, john.getAssignedAnimals().size());
        Assertions.assertEquals(2, john.getAssignedEnclosures().size());
        Assertions.assertTrue(john.getAssignedEnclosures().contains("Lion Den"));
        Assertions.assertTrue(john.getAssignedEnclosures().contains("Elephant Sanctuary"));
    }

    @Test
    @DisplayName("Zookeeper feedAnimals with assigned animals")
    public void feedAnimalsWithAnimalsTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Animal> animals = Arrays.asList(
            new Lion("Simba", 5),
            new Elephant("Dumbo", 8)
        );
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, animals, new ArrayList<>());
        
        String result = john.feedAnimals();
        String expected = "Zookeeper John is feeding the lion, elephant.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper feedAnimals with no animals")
    public void feedAnimalsNoAnimalsTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        String result = john.feedAnimals();
        String expected = "Zookeeper John has no animals to feed.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper cleanEnclosure with assigned enclosures")
    public void cleanEnclosureWithEnclosuresTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<String> enclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, new ArrayList<>(), enclosures);
        
        String result = john.cleanEnclosure();
        String expected = "Zookeeper John cleaned the lion den enclosure.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper cleanEnclosure with specific enclosure parameter")
    public void cleanSpecificEnclosureTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        String result = john.cleanEnclosure("Monkey Habitat");
        String expected = "Zookeeper John cleaned the monkey habitat enclosure.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper cleanEnclosure with no enclosures")
    public void cleanEnclosureNoEnclosuresTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        String result = john.cleanEnclosure();
        String expected = "Zookeeper John has no enclosures to clean.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper checkAnimalHealth returns correct message")
    public void checkAnimalHealthTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        String result = john.checkAnimalHealth();
        String expected = "Zookeeper John checked the health of all assigned animals.";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper talk returns correct greeting")
    public void zookeeperTalkTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        String result = john.talk();
        String expected = "Hello, I'm John, your zookeeper today!";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper addAssignedAnimal works correctly")
    public void addAssignedAnimalTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals(0, john.getAssignedAnimals().size());
        
        Lion simba = new Lion("Simba", 5);
        john.addAssignedAnimal(simba);
        
        Assertions.assertEquals(1, john.getAssignedAnimals().size());
        Assertions.assertEquals("Simba", john.getAssignedAnimals().get(0).getName());
    }

    @Test
    @DisplayName("Zookeeper addAssignedEnclosure works correctly")
    public void addAssignedEnclosureTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals(0, john.getAssignedEnclosures().size());
        
        john.addAssignedEnclosure("Lion Den");
        
        Assertions.assertEquals(1, john.getAssignedEnclosures().size());
        Assertions.assertEquals("Lion Den", john.getAssignedEnclosures().get(0));
    }

    @Test
    @DisplayName("Zookeeper toString returns correct format")
    public void zookeeperToStringTest() {
        LocalDate employmentDate = LocalDate.now().minusDays(100);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Animal> animals = Arrays.asList(new Lion("Simba", 5));
        List<String> enclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, animals, enclosures);
        
        String result = john.toString();
        String expected = "Zookeeper John, employed for 100 days, shift: 08:00-16:00, manages 1 animals and 2 enclosures";
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Zookeeper is instance of Staff and Speakable")
    public void zookeeperInstanceOfTest() {
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime);
        
        Assertions.assertTrue(john instanceof Staff);
        Assertions.assertTrue(john instanceof Speakable);
    }
}