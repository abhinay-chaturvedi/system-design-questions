package org.abhinay.car_rental_system;

public class PaypalPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}
