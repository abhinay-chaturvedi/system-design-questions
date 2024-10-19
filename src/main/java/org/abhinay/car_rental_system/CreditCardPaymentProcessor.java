package org.abhinay.car_rental_system;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        // here we can just write the logic of the payment process but for the time being i am assuming payment
        // is success so i am returning it as true everytime
        return true;
    }
}
