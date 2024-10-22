package org.abhinay.atm_machine;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdrawMoney(double amount) {
        if(this.balance < amount) {
            System.out.println("Sorry! insufficient balance!");
            return false;
        }
        this.balance -= amount;
        return  true;
    }
    public boolean depositMoney(double amount) {
        this.balance += amount;
        return true;
    }
}
