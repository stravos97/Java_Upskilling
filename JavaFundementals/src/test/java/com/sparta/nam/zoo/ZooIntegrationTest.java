package com.sparta.nam.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZooIntegrationTest {

    @Test
    @DisplayName("Complete zoo scenario with mixed animals and staff")
    public void completeZooScenarioTest() {
        ArrayList<Speakable> zooThings = new ArrayList<>();
        
        Lion simba = new Lion("Simba", 5);
        Zebra marty = new Zebra("Marty", 3);
        Elephant dumbo = new Elephant("Dumbo", 8);
        Monkey george = new Monkey("George", 4);
        
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Animal> johnAnimals = Arrays.asList(simba, dumbo);
        List<String> johnEnclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, johnAnimals, johnEnclosures);
        
        List<Animal> sarahAnimals = Arrays.asList(marty, george);
        List<String> sarahEnclosures = Arrays.asList("Zebra Plains", "Monkey Habitat");
        Zookeeper sarah = new Zookeeper("Sarah", employmentDate, startTime, endTime, sarahAnimals, sarahEnclosures);
        
        zooThings.add(simba);
        zooThings.add(marty);
        zooThings.add(dumbo);
        zooThings.add(george);
        zooThings.add(john);
        zooThings.add(sarah);
        
        Assertions.assertEquals(6, zooThings.size());
        
        List<String> messages = new ArrayList<>();
        for (Speakable speakable : zooThings) {
            String message = speakable.talk();
            Assertions.assertNotNull(message);
            Assertions.assertFalse(message.isEmpty());
            messages.add(message);
        }
        
        Assertions.assertEquals(6, messages.size());
        Assertions.assertTrue(messages.contains("Roar! I'm the king of the jungle!"));
        Assertions.assertTrue(messages.contains("Neigh! Look at my stripes!"));
        Assertions.assertTrue(messages.contains("Trumpet! I never forget!"));
        Assertions.assertTrue(messages.contains("Ooh ooh ah ah! I love bananas!"));
        Assertions.assertTrue(messages.contains("Hello, I'm John, your zookeeper today!"));
        Assertions.assertTrue(messages.contains("Hello, I'm Sarah, your zookeeper today!"));
    }

    @Test
    @DisplayName("Zoo application main functionality simulation")
    public void zooAppMainFunctionalityTest() {
        Lion simba = new Lion("Simba", 5);
        Zebra marty = new Zebra("Marty", 3);
        Elephant dumbo = new Elephant("Dumbo", 8);
        Monkey george = new Monkey("George", 4);
        
        LocalDate employmentDate = LocalDate.of(2020, 3, 15);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        List<Animal> johnAnimals = Arrays.asList(simba, dumbo);
        List<String> johnEnclosures = Arrays.asList("Lion Den", "Elephant Sanctuary");
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, johnAnimals, johnEnclosures);
        
        String feedResult = john.feedAnimals();
        String cleanResult = john.cleanEnclosure();
        String healthResult = john.checkAnimalHealth();
        
        Assertions.assertEquals("Zookeeper John is feeding the lion, elephant.", feedResult);
        Assertions.assertEquals("Zookeeper John cleaned the lion den enclosure.", cleanResult);
        Assertions.assertEquals("Zookeeper John checked the health of all assigned animals.", healthResult);
        
        Assertions.assertTrue(simba instanceof Speakable);
        Assertions.assertTrue(john instanceof Speakable);
    }

    @Test
    @DisplayName("Zoo handles different animal species correctly")
    public void zooHandlesDifferentSpeciesTest() {
        List<Animal> animals = Arrays.asList(
            new Lion("Lion1", 3),
            new Lion("Lion2", 4),
            new Zebra("Zebra1", 2),
            new Elephant("Elephant1", 7),
            new Monkey("Monkey1", 1)
        );
        
        int lionCount = 0;
        int zebraCount = 0;
        int elephantCount = 0;
        int monkeyCount = 0;
        
        for (Animal animal : animals) {
            switch (animal.getSpecies()) {
                case "Lion":
                    lionCount++;
                    Assertions.assertEquals("Roar! I'm the king of the jungle!", animal.talk());
                    break;
                case "Zebra":
                    zebraCount++;
                    Assertions.assertEquals("Neigh! Look at my stripes!", animal.talk());
                    break;
                case "Elephant":
                    elephantCount++;
                    Assertions.assertEquals("Trumpet! I never forget!", animal.talk());
                    break;
                case "Monkey":
                    monkeyCount++;
                    Assertions.assertEquals("Ooh ooh ah ah! I love bananas!", animal.talk());
                    break;
            }
        }
        
        Assertions.assertEquals(2, lionCount);
        Assertions.assertEquals(1, zebraCount);
        Assertions.assertEquals(1, elephantCount);
        Assertions.assertEquals(1, monkeyCount);
    }

    @Test
    @DisplayName("Multiple zookeepers can manage different animals")
    public void multipleZookeepersManagementTest() {
        Lion lion = new Lion("King", 6);
        Zebra zebra = new Zebra("Stripes", 4);
        Elephant elephant = new Elephant("Trunk", 9);
        Monkey monkey = new Monkey("Swing", 3);
        
        LocalDate employmentDate1 = LocalDate.of(2019, 1, 1);
        LocalDate employmentDate2 = LocalDate.of(2020, 6, 1);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 0);
        
        Zookeeper keeper1 = new Zookeeper("Alice", employmentDate1, startTime, endTime, 
                                          Arrays.asList(lion, elephant), 
                                          Arrays.asList("Big Cat Area", "Pachyderm Zone"));
        
        Zookeeper keeper2 = new Zookeeper("Bob", employmentDate2, startTime, endTime, 
                                          Arrays.asList(zebra, monkey), 
                                          Arrays.asList("Savanna", "Primate House"));
        
        Assertions.assertEquals(2, keeper1.getAssignedAnimals().size());
        Assertions.assertEquals(2, keeper1.getAssignedEnclosures().size());
        Assertions.assertEquals("Zookeeper Alice is feeding the lion, elephant.", keeper1.feedAnimals());
        
        Assertions.assertEquals(2, keeper2.getAssignedAnimals().size());
        Assertions.assertEquals(2, keeper2.getAssignedEnclosures().size());
        Assertions.assertEquals("Zookeeper Bob is feeding the zebra, monkey.", keeper2.feedAnimals());
        
        Assertions.assertTrue(keeper1.daysEmployed() > keeper2.daysEmployed());
    }

    @Test
    @DisplayName("Zoo toString methods provide meaningful information")
    public void zooToStringInformationTest() {
        Lion simba = new Lion("Simba", 5);
        LocalDate employmentDate = LocalDate.now().minusDays(365);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        Zookeeper john = new Zookeeper("John", employmentDate, startTime, endTime, 
                                      Arrays.asList(simba), 
                                      Arrays.asList("Lion Den"));
        
        String animalString = simba.toString();
        String keeperString = john.toString();
        
        Assertions.assertTrue(animalString.contains("Lion"));
        Assertions.assertTrue(animalString.contains("Simba"));
        Assertions.assertTrue(animalString.contains("5"));
        Assertions.assertTrue(animalString.contains("Roar!"));
        
        Assertions.assertTrue(keeperString.contains("Zookeeper John"));
        Assertions.assertTrue(keeperString.contains("365 days"));
        Assertions.assertTrue(keeperString.contains("09:00-17:00"));
        Assertions.assertTrue(keeperString.contains("1 animals"));
        Assertions.assertTrue(keeperString.contains("1 enclosures"));
    }

    @Test
    @DisplayName("Zoo demonstrates proper inheritance and polymorphism")
    public void zooInheritancePolymorphismTest() {
        ArrayList<Speakable> zooCollection = new ArrayList<>();
        
        zooCollection.add(new Lion("Leo", 4));
        zooCollection.add(new Zebra("Zara", 2));
        zooCollection.add(new Zookeeper("Manager", LocalDate.of(2018, 1, 1), 
                                       LocalTime.of(7, 0), LocalTime.of(15, 0)));
        
        int animalCount = 0;
        int staffCount = 0;
        int speakableCount = 0;
        
        for (Speakable item : zooCollection) {
            speakableCount++;
            
            if (item instanceof Animal) {
                animalCount++;
                Animal animal = (Animal) item;
                Assertions.assertNotNull(animal.getName());
                Assertions.assertTrue(animal.getAge() > 0);
            }
            
            if (item instanceof Staff) {
                staffCount++;
                Staff staff = (Staff) item;
                Assertions.assertNotNull(staff.getName());
                Assertions.assertTrue(staff.daysEmployed() >= 0);
            }
            
            Assertions.assertNotNull(item.talk());
        }
        
        Assertions.assertEquals(3, speakableCount);
        Assertions.assertEquals(2, animalCount);
        Assertions.assertEquals(1, staffCount);
    }
}