package com.sparta.nam.zoo;

public class Lion extends Animal {
    
    public Lion(String name, int age) {
        super(name, age, "Lion");
    }

    @Override
    public String talk() {
        return "Roar! I'm the king of the jungle!";
    }
}