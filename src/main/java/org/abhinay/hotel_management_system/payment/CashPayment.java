package org.abhinay.hotel_management_system.payment;

public class CashPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        // Here we can just write the logic for the payment process through the credit card;
        return true;
    }
}
