package org.abhinay.vending_machine;

public class IdleState implements VendingMachineState{

    private final VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        if(this.vendingMachine.inventory.isAvailable(product)) {
            this.vendingMachine.setSelectedProduct(product);
            this.vendingMachine.setState(this.vendingMachine.getReadyState());
        } else {
            System.out.println("Product not available!");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select Product first!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select product first!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select product first!");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select product first!");
    }
}
