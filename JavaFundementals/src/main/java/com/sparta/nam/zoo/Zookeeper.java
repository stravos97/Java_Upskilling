package com.sparta.nam.zoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zookeeper extends Staff {
    private List<Animal> assignedAnimals;
    private List<String> assignedEnclosures;

    public Zookeeper(String name, LocalDate dateOfEmployment, LocalTime shiftStartTime, LocalTime shiftEndTime) {
        super(name, dateOfEmployment, shiftStartTime, shiftEndTime);
        this.assignedAnimals = new ArrayList<>();
        this.assignedEnclosures = new ArrayList<>();
    }

    public Zookeeper(String name, LocalDate dateOfEmployment, LocalTime shiftStartTime, LocalTime shiftEndTime, 
                     List<Animal> assignedAnimals, List<String> assignedEnclosures) {
        super(name, dateOfEmployment, shiftStartTime, shiftEndTime);
        this.assignedAnimals = assignedAnimals != null ? new ArrayList<>(assignedAnimals) : new ArrayList<>();
        this.assignedEnclosures = assignedEnclosures != null ? new ArrayList<>(assignedEnclosures) : new ArrayList<>();
    }

    public List<Animal> getAssignedAnimals() {
        return new ArrayList<>(assignedAnimals);
    }

    public void setAssignedAnimals(List<Animal> assignedAnimals) {
        this.assignedAnimals = assignedAnimals != null ? new ArrayList<>(assignedAnimals) : new ArrayList<>();
    }

    public void addAssignedAnimal(Animal animal) {
        this.assignedAnimals.add(animal);
    }

    public List<String> getAssignedEnclosures() {
        return new ArrayList<>(assignedEnclosures);
    }

    public void setAssignedEnclosures(List<String> assignedEnclosures) {
        this.assignedEnclosures = assignedEnclosures != null ? new ArrayList<>(assignedEnclosures) : new ArrayList<>();
    }

    public void addAssignedEnclosure(String enclosure) {
        this.assignedEnclosures.add(enclosure);
    }

    public String feedAnimals() {
        if (assignedAnimals.isEmpty()) {
            return String.format("Zookeeper %s has no animals to feed.", name);
        }
        
        String animalTypes = assignedAnimals.stream()
                .map(Animal::getSpecies)
                .distinct()
                .collect(Collectors.joining(", "));
                
        return String.format("Zookeeper %s is feeding the %s.", name, animalTypes.toLowerCase());
    }

    public String cleanEnclosure() {
        if (assignedEnclosures.isEmpty()) {
            return String.format("Zookeeper %s has no enclosures to clean.", name);
        }
        
        String enclosure = assignedEnclosures.get(0);
        return String.format("Zookeeper %s cleaned the %s enclosure.", name, enclosure.toLowerCase());
    }

    public String cleanEnclosure(String specificEnclosure) {
        return String.format("Zookeeper %s cleaned the %s enclosure.", name, specificEnclosure.toLowerCase());
    }

    public String checkAnimalHealth() {
        return String.format("Zookeeper %s checked the health of all assigned animals.", name);
    }

    @Override
    public String talk() {
        return String.format("Hello, I'm %s, your zookeeper today!", name);
    }

    @Override
    public String toString() {
        return String.format("Zookeeper %s, employed for %d days, shift: %s-%s, manages %d animals and %d enclosures", 
                            name, daysEmployed(), shiftStartTime, shiftEndTime, 
                            assignedAnimals.size(), assignedEnclosures.size());
    }
}