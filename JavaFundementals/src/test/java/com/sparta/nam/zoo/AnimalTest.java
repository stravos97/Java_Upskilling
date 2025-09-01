package com.sparta.nam.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    @DisplayName("Lion creation and basic properties")
    public void lionCreationTest() {
        Lion simba = new Lion("Simba", 5);
        
        Assertions.assertEquals("Simba", simba.getName());
        Assertions.assertEquals(5, simba.getAge());
        Assertions.assertEquals("Lion", simba.getSpecies());
    }

    @Test
    @DisplayName("Lion talk method returns correct message")
    public void lionTalkTest() {
        Lion simba = new Lion("Simba", 5);
        String expectedMessage = "Roar! I'm the king of the jungle!";
        
        Assertions.assertEquals(expectedMessage, simba.talk());
    }

    @Test
    @DisplayName("Zebra creation and basic properties")
    public void zebraCreationTest() {
        Zebra marty = new Zebra("Marty", 3);
        
        Assertions.assertEquals("Marty", marty.getName());
        Assertions.assertEquals(3, marty.getAge());
        Assertions.assertEquals("Zebra", marty.getSpecies());
    }

    @Test
    @DisplayName("Zebra talk method returns correct message")
    public void zebraTalkTest() {
        Zebra marty = new Zebra("Marty", 3);
        String expectedMessage = "Neigh! Look at my stripes!";
        
        Assertions.assertEquals(expectedMessage, marty.talk());
    }

    @Test
    @DisplayName("Elephant creation and basic properties")
    public void elephantCreationTest() {
        Elephant dumbo = new Elephant("Dumbo", 8);
        
        Assertions.assertEquals("Dumbo", dumbo.getName());
        Assertions.assertEquals(8, dumbo.getAge());
        Assertions.assertEquals("Elephant", dumbo.getSpecies());
    }

    @Test
    @DisplayName("Elephant talk method returns correct message")
    public void elephantTalkTest() {
        Elephant dumbo = new Elephant("Dumbo", 8);
        String expectedMessage = "Trumpet! I never forget!";
        
        Assertions.assertEquals(expectedMessage, dumbo.talk());
    }

    @Test
    @DisplayName("Monkey creation and basic properties")
    public void monkeyCreationTest() {
        Monkey george = new Monkey("George", 4);
        
        Assertions.assertEquals("George", george.getName());
        Assertions.assertEquals(4, george.getAge());
        Assertions.assertEquals("Monkey", george.getSpecies());
    }

    @Test
    @DisplayName("Monkey talk method returns correct message")
    public void monkeyTalkTest() {
        Monkey george = new Monkey("George", 4);
        String expectedMessage = "Ooh ooh ah ah! I love bananas!";
        
        Assertions.assertEquals(expectedMessage, george.talk());
    }

    @Test
    @DisplayName("Animal setters work correctly")
    public void animalSettersTest() {
        Lion lion = new Lion("Original", 5);
        
        lion.setName("Updated");
        lion.setAge(6);
        lion.setSpecies("Big Lion");
        
        Assertions.assertEquals("Updated", lion.getName());
        Assertions.assertEquals(6, lion.getAge());
        Assertions.assertEquals("Big Lion", lion.getSpecies());
    }

    @Test
    @DisplayName("Animal toString returns correct format")
    public void animalToStringTest() {
        Lion simba = new Lion("Simba", 5);
        String expectedString = "Lion named Simba, age 5, says: Roar! I'm the king of the jungle!";
        
        Assertions.assertEquals(expectedString, simba.toString());
        
        Zebra marty = new Zebra("Marty", 3);
        String expectedZebraString = "Zebra named Marty, age 3, says: Neigh! Look at my stripes!";
        
        Assertions.assertEquals(expectedZebraString, marty.toString());
    }

    @Test
    @DisplayName("Animals implement Speakable interface")
    public void speakableInterfaceTest() {
        Lion lion = new Lion("Simba", 5);
        Zebra zebra = new Zebra("Marty", 3);
        Elephant elephant = new Elephant("Dumbo", 8);
        Monkey monkey = new Monkey("George", 4);
        
        Assertions.assertTrue(lion instanceof Speakable);
        Assertions.assertTrue(zebra instanceof Speakable);
        Assertions.assertTrue(elephant instanceof Speakable);
        Assertions.assertTrue(monkey instanceof Speakable);
    }

    @Test
    @DisplayName("Animal equals method works correctly")
    public void animalEqualsTest() {
        Lion lion1 = new Lion("Simba", 5);
        Lion lion2 = new Lion("Simba", 5);
        Lion lion3 = new Lion("Mufasa", 5);
        
        Assertions.assertEquals(lion1, lion2);
        Assertions.assertNotEquals(lion1, lion3);
    }

    @Test
    @DisplayName("Animal hashCode method works correctly")
    public void animalHashCodeTest() {
        Lion lion1 = new Lion("Simba", 5);
        Lion lion2 = new Lion("Simba", 5);
        
        Assertions.assertEquals(lion1.hashCode(), lion2.hashCode());
    }
}