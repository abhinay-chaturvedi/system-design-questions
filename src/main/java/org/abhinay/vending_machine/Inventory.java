package org.abhinay.vending_machine;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private ConcurrentHashMap<Product, Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }
    public Product addProduct(Product product, int quantity) {
        products.put(product, quantity);
        System.out.println("Successfully added!");
        return product;
    }
    public Product removeProduct(Product product) {
        products.remove(product);
        System.out.println("Successfully removed!");
        return product;
    }
    public boolean updateQuantity(Product product, int num) {
        if(products.containsKey(product)) {
            products.put(product, num);
            System.out.println("Successfully updated!");
            return true;
        }
        return false;
    }
    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }
    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.getOrDefault(product, 0) > 0;
    }
}
