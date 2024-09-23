package org.abhinay.vending_machine;

public class DispenseState implements VendingMachineState{

    private final VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Already done!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already done!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Already done!");
    }

    @Override
    public void dispenseProduct() {
//        System.out.println("Already done!");
        Product product = this.vendingMachine.getSelectedProduct();
        this.vendingMachine.inventory.updateQuantity(product,this.vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("product dispensed!");
        this.vendingMachine.setState(this.vendingMachine.getReturnChangeState());
    }


    @Override
    public void returnChange() {
        System.out.println("Please dispense item fist!!");
    }
}
