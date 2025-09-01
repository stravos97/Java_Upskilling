package com.sparta.nam.zoo;

public class Elephant extends Animal {
    
    public Elephant(String name, int age) {
        super(name, age, "Elephant");
    }

    @Override
    public String talk() {
        return "Trumpet! I never forget!";
    }
}