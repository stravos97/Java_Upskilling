package com.sparta.nam.zoo;

public class Monkey extends Animal {
    
    public Monkey(String name, int age) {
        super(name, age, "Monkey");
    }

    @Override
    public String talk() {
        return "Ooh ooh ah ah! I love bananas!";
    }
}