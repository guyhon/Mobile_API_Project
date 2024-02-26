package com.example.fruitapp;

public class Fruit {

    public String name;
    public int id;
    public String family;
    public String order;
    public String genus;
    public Nutritions nutritions;

    public Fruit() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    public int compareTo(int sortType, Fruit fruit){
        double a1 = 0;
        double a2 = 0;
        if(sortType == 1) {
            a1 = this.getNutritions().getSugar();
            a2 = fruit.getNutritions().getSugar();
        }
        else if(sortType == 2){
            a1 = this.getNutritions().getProtein();
            a2 = fruit.getNutritions().getProtein();
        }
        else if(sortType == 3){
            a1 = this.getNutritions().getCalories();
            a2 = fruit.getNutritions().getCalories();
        }
        if(a1 > a2)
            return 1;
        else if (a1 < a2)
            return -1;
        else
            return 0;
    }
}
