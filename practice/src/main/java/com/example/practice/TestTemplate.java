package com.example.practice;

public class TestTemplate {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new GourmetCoffee();
        caffeineBeverage.prepareRecipe();
    }
}

abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        addCondiments();
        pourInCup();
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("Pouring in Cup");
    }
}

class GourmetCoffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Put in Coffee Maker");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding nothing, because GourmetCoffee");
    }
}