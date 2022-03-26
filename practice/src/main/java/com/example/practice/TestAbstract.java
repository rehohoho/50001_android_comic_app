package com.example.practice;

public class TestAbstract {
    public static void main(String[] args){
        Feline tora = new Tiger("Tiger", "Sumatran Tiger");
        makeSound(tora);
    }
    public static void makeSound(Feline feline){
        feline.sound();
    }
}

abstract class Feline {
    private String name;
    private String breed;
    public Feline(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public abstract void sound();
}

class Tiger extends Feline {

    public Tiger(String name, String breed) {
        super(name, breed);
    }

    @Override
    public void sound() {
        System.out.println("I'm a tiger");
    }
}
