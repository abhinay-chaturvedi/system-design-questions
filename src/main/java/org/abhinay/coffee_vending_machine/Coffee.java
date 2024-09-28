package org.abhinay.coffee_vending_machine;

import java.util.Map;

public class Coffee {
    // in coffee we will have name price and recipe
    private final String name;
    private final double price;
    private final Map<Ingredient, Integer> recipe;

    public Coffee(String name, double price, Map<Ingredient,Integer> recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }

    public String toString() {
        return "Coffee: " + this.name + " - Price: " + this.price;
    }
}
