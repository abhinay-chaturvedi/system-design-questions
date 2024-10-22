package org.abhinay.atm_machine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class AtmMachine {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private static AtmMachine instance;
    public static AtmMachine getInstance() {
        if(instance == null) {
            instance = new AtmMachine(new BankingService(), new CashDispenser(1000));
        }
        return instance;
    }
    private static final AtomicLong transactionCounter = new AtomicLong(0);
    public AtmMachine(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public double checkBalance(String accountNumber) {
        Account account = bankingService.getBankAccount(accountNumber);
        return account.getBalance();
    }
    public void authenticateUser(Card card) {
        // Here we can just write the logic for the authenticate the user using the card
        // scanner and the pin entered
    }
    public void withdrawCash(String accountNumber, double amount) {
        Account account = bankingService.getBankAccount(accountNumber);
//        account.withdrawMoney(amount);
        Transaction transaction = new WithdrawlTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash((int) amount);
    }
    public void depositCash(String accountNumber, double amount) {
        Account account = this.bankingService.getBankAccount(accountNumber);
        Transaction transaction = new DepositTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
    }
    private String generateTransactionId() {
        long transactionNumber = transactionCounter.incrementAndGet();
        System.out.println(transactionNumber);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(timestamp);
        System.out.println(String.format("%010d", transactionNumber));
        return "TXN" + timestamp + String.format("%010d", transactionNumber);
    }
    public void runSystem() {
        bankingService.addBankAccount("1234567890", 1000.0);
        bankingService.addBankAccount("9876543210", 500.0);

        Card card = new Card("1234567890", "1234");
        authenticateUser(card);
        double balance = checkBalance("1234567890");
        System.out.println("Account balance: " + balance);

        withdrawCash("1234567890", 500.0);
        depositCash("9876543210", 200.0);

        balance = checkBalance("1234567890");
        System.out.println("Account balance: " + balance);
        balance = checkBalance("9876543210");
        System.out.println("Account balance: " + balance);
    }
}
