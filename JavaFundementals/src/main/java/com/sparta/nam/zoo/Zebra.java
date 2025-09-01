package com.sparta.nam.zoo;

public class Zebra extends Animal {
    
    public Zebra(String name, int age) {
        super(name, age, "Zebra");
    }

    @Override
    public String talk() {
        return "Neigh! Look at my stripes!";
    }
}