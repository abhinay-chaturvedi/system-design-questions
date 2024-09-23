package org.abhinay.vending_machine;

public class VendingMachine {
    // Here i will use Singleton pattern
    private static VendingMachine instance;
    // in vending machine we will have products - so
    // this Class be for products
    private Product selectedProduct;
    // at any point of time machine will go through different states
    // for ex -   idleState -> readyState -> dispenseState -> returnChangeState
    // idleState -  means user has not selected the product yet
    // readyState - means user has selected the product and going to make payment.
    // dispenseState - means payment has been done and product is going to dispense;
    // returnChangeState - product has been dispensed and if there is any change return needed
    // for that transaction, that will be done
    private VendingMachineState state;

    // here is the idleState object which will have selectProduct method which takes
    // the product in its argument and select the product and will move the state
    // from idleState -> readyState.
    // it also checks the availability of product using inventory class
    private final IdleState idleState;
    // in readyState we will make the payment
    // we have two method in this ready state 1- addCoin and addNote which will add the
    // coin and note in the system and will ensure the payment.
    // while calling these method we will also check if the payment that is done is enough for
    // that particular product
    // if everything is good , it will move the state from readyState -> dispenseState
    private final ReadyState readyState;
    // in this class we have method name - dispenseProduct so it will dispense the product
    // using the inventory class and will move the state from dispenseState -> return change state
    private final DispenseState dispenseState;
    // in this state we have returnChange method which will return the changes if any
    // and will reset the payment and will move state back to idleState
    private final ReturnChangeState returnChangeState;

    // this will the amount of money user has added to to system using notes and coin
    private double totalPayment;
    // this will track the list of products and their quantities
    // it will also have method like - isAvailable, updateQuantity, removeProduct and
    // addProduct and so on.
    public Inventory inventory;
    // This is the constructor for the VendingMachine which will initialize
    // the states and totalPayment and inventory object
    public VendingMachine() {
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.state = this.idleState;
        this.inventory = new Inventory();
        this.totalPayment = 0.0;
    }
    // this is the thread safe method to get the instance of object
    // basically it uses the singleton pattern
    public static synchronized VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }
    public Product getSelectedProduct() {
        return this.selectedProduct;
    }
    public void setState(VendingMachineState state) {
        this.state = state;
    }
    public VendingMachineState getReadyState() {
        return this.readyState;
    }
    public VendingMachineState getDispenseState() {
        return this.dispenseState;
    }
    public VendingMachineState getReturnChangeState() {
        return this.returnChangeState;
    }
    public VendingMachineState getIdleState() {
        return this.idleState;
    }

    public void addCoin(Coin coin) {
        this.totalPayment += coin.getValue();
    }
    public void addNote(Note note) {
        this.totalPayment += note.getValue();
    }
    public double getTotalPayment() {
        return this.totalPayment;
    }
    public void resetPayment() {
        this.totalPayment = 0;
    }
    public void resetSelectedProduct() {
        this.selectedProduct = null;
    }
    public void selectProduct(Product product) {
        this.state.selectProduct(product);
    }
    public void dispenseProduct() {
        this.state.dispenseProduct();
    }
    public void returnChange() {
        this.state.returnChange();
    }
    public void makePaymentByCoin(Coin coin) {
        this.state.insertCoin(coin);
    }
    public void makePaymentNote(Note note) {
        this.state.insertNote(note);
    }

}
