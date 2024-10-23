package org.abhinay.hotel_management_system.payment;

public class CreditCardPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
