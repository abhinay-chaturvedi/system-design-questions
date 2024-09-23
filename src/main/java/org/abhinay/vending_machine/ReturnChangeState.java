package org.abhinay.vending_machine;

public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;
    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product dispensed!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Product dispensed!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Product dispensed!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product dispensed!");
    }

    @Override
    public void returnChange() {
        double change = this.vendingMachine.getTotalPayment() - this.vendingMachine.getSelectedProduct().getPrice();
        if(change > 0) {
            System.out.println("Change returned" + change);

        } else {
            System.out.println("there is not change for this transaction!");
        }
        this.vendingMachine.resetPayment();
        this.vendingMachine.resetSelectedProduct();
        this.vendingMachine.setState(this.vendingMachine.getIdleState());
    }
}
