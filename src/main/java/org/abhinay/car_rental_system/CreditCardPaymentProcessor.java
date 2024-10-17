package org.abhinay.car_rental_system;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}
