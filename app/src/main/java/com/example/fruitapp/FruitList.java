package com.example.fruitapp;

import java.util.ArrayList;

public class FruitList {
    private ArrayList<Fruit> fruits = new ArrayList<>();

    public FruitList() { }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }
}
