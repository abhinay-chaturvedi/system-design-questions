package org.abhinay.vending_machine;

public class VendingMachineDemo {
    public  void  run() {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Product kurkure = new Product("kurkure", 5);
        Product milk = new Product("milk", 50);
        vendingMachine.inventory.addProduct(kurkure, 10);
        vendingMachine.inventory.addProduct(milk, 5);
        vendingMachine.selectProduct(milk);
//        vendingMachine.selectProduct(kurkure);
//        vendingMachine.addCoin(Coin.DIME);
//        vendingMachine.addNote(Note.TWENTY);
//        vendingMachine.addNote(Note.TWENTY);
//        vendingMachine.addNote(Note.TWENTY);
        vendingMachine.makePaymentNote(Note.TWENTY);
        vendingMachine.makePaymentNote(Note.TWENTY);
//        vendingMachine.makePaymentNote(Note.TWENTY);
        vendingMachine.dispenseProduct();;
        vendingMachine.returnChange();
    }
}
