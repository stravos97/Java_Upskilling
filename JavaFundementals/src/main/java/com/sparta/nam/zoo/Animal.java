package com.sparta.nam.zoo;

import java.util.Objects;

public abstract class Animal implements Speakable {
    protected String name;
    protected int age;
    protected String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public abstract String talk();

    @Override
    public String toString() {
        return String.format("%s named %s, age %d, says: %s", species, name, age, talk());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Animal animal)) return false;
        return age == animal.age && Objects.equals(name, animal.name) && Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, species);
    }
}