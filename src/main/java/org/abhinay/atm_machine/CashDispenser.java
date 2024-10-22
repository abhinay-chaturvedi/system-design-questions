package org.abhinay.atm_machine;

public class CashDispenser {
    private int cashAvailable;
    public CashDispenser(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
    public boolean addCash(int amount) {
        this.cashAvailable += amount;
        return true;
    }
    public synchronized boolean dispenseCash(int amount) {
        System.out.println("Dispensing cash");
        if(amount > cashAvailable) {
            throw new IllegalArgumentException("Insufficient cash available!");
        }
        this.cashAvailable -= amount;
        System.out.println("Dispensed Cash: " + amount);
        return true;
    }
}
