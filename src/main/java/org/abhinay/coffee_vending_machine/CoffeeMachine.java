package org.abhinay.coffee_vending_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// So this will be our coffee machine which will provide all the functionality
// that is there in the system. This will be used using singleton pattern
// means this will have only one instance
public class CoffeeMachine {

    private static CoffeeMachine instance;
    public static CoffeeMachine getInstance() {
        if(instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }
    // So in the coffee machine we will have the menu to show to the users
    private final List<Coffee> menu;
    // We also haves the ingredients
    private final Map<String, Ingredient> ingredients;


    // we need to make sure that no body can create the object of this class
    // so that is the reason i made its constructor private.
    private CoffeeMachine() {
        this.ingredients = new HashMap<>();
        this.menu = new ArrayList<>();
        this.initializeIngredient();
        this.initializeMenu();
    }
    public void initializeMenu() {
        System.out.println("Initializing menu ....");
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"), 1);
        espressoRecipe.put(ingredients.get("Water"), 1);
        menu.add(new Coffee("Espresso", 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("Coffee"), 1);
        cappuccinoRecipe.put(ingredients.get("Water"), 1);
        cappuccinoRecipe.put(ingredients.get("Milk"), 1);
        menu.add(new Coffee("Cappuccino", 3.5, cappuccinoRecipe));

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredients.get("Coffee"), 1);
        latteRecipe.put(ingredients.get("Water"), 1);
        latteRecipe.put(ingredients.get("Milk"), 2);
        menu.add(new Coffee("Latte", 4.0, latteRecipe));
    }

    public void initializeIngredient() {
        System.out.println("Initializing ingredient .....");
        this.ingredients.put("Coffee", new Ingredient("Coffee", 20));
        this.ingredients.put("Water", new Ingredient("Water", 10));
        this.ingredients.put("Milk", new Ingredient("Milk", 10));
    }
    // we need to display the menu available in the system
    public void displayMenu() {
        this.menu.forEach((item) -> {
            System.out.println(item.toString());
        });
    }
    public Coffee selectCoffee(String coffeeName) {
        System.out.println("Selecting coffee please wait...");
        Coffee coffee = this.menu.stream().filter((item) -> item.getName().equalsIgnoreCase(coffeeName)).findFirst().orElse(null);
        if(coffee == null) return  null;
        if(!hasEnoughIngredient(coffee)) {
            System.out.println("Sorry for the inconvenience caused! right now we don't enough ingredients to process the coffee!");
            return null;
        }
        return coffee;
    }
    public Payment makePayment(Coffee coffee, double amount) {
        System.out.println("Making payment please wait...");
        if(coffee == null) {
            System.out.println("Please select coffee first");
            return null;
        }
        if(coffee.getPrice() > amount) {
            System.out.println("please enter more amount to get coffee dispensed!");
            return null;
        }
        return new Payment(amount);
    }
    public void dispenseCoffee(Coffee coffee, Payment payment) {
        if(coffee.getPrice() <= payment.getAmount()) {
           updateIngredient(coffee);
            System.out.println("Dispensing coffee : " + coffee.getName());
            if(payment.getAmount() > coffee.getPrice()) {
                System.out.println("Coffee dispensed!");
                System.out.println("Please collect your extra amount - " + (payment.getAmount() - coffee.getPrice()));
            }
        } else {
            System.out.println("You have not paid enough amount to get coffee dispensed!");
        }
        return ;
    }
    public void updateIngredient(Coffee coffee) {
//        this.ingredients.put
        coffee.getRecipe().forEach((ing, q) -> {
            ing.updateQuantity(-q);
            if(ing.getQuantity() <= 3) System.out.println("System is about to run off for the ingredient: " + ing.getName());
        });
    }
    public boolean hasEnoughIngredient(Coffee coffee) {
//        if(coffee == null)
        for(Map.Entry<Ingredient, Integer> entry: coffee.getRecipe().entrySet()) {
            if(entry.getKey().getQuantity() < entry.getValue()) return false;
        }
        return true;
    }
}
