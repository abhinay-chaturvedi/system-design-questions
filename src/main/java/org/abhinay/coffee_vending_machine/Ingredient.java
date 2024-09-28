package org.abhinay.coffee_vending_machine;

public class Ingredient {
    private final String name;
    private int quantity;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    // Here we update the quantity
    public void updateQuantity(int val) {
        this.quantity += val;
        if(this.quantity <= 0) this.quantity = 0;
    }
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
