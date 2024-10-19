package org.abhinay.car_rental_system;

public class PaypalPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        // here we can just write the logic for the payment that will be processed through
        // paypal interface, so for the time being i am assuming payment will be success most of the time
        // so i am returning true;
        return true;
    }
}
