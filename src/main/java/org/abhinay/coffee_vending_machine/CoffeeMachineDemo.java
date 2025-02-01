package org.abhinay.coffee_vending_machine;

public class CoffeeMachineDemo {
    public void run() {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.displayMenu();
        Coffee coffee = coffeeMachine.selectCoffee("Latte");
        Payment payment = coffeeMachine.makePayment(coffee, 5.0);
        coffeeMachine.dispenseCoffee(coffee, payment);
    }
}
