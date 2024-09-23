package org.abhinay.vending_machine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected! please make payment!");
    }

    @Override
    public void insertCoin(Coin coin) {
        this.vendingMachine.addCoin(coin);
        System.out.println("Made the payment of: " + coin.getValue());
        verifyPayment();
    }

    @Override
    public void insertNote(Note note) {
        this.vendingMachine.addNote(note);
        System.out.println("Made the payment of" + note.getValue());
        verifyPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment!");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment!");
    }
    public void verifyPayment() {
        if(this.vendingMachine.getTotalPayment() >= this.vendingMachine.getSelectedProduct().getPrice()) {
            this.vendingMachine.setState(this.vendingMachine.getDispenseState());
        }
    }
}
