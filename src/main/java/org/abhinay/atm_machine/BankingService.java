package org.abhinay.atm_machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts;

    public BankingService() {
        this.accounts = new ConcurrentHashMap<>();
    }
    public Account addBankAccount(String accountNumber, double initialBalance) {
        return this.accounts.put(accountNumber, new Account(accountNumber, initialBalance));
//        return true;
    }
    public Account getBankAccount(String accountNumber) {
        return this.accounts.getOrDefault(accountNumber, null);
    }
    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }

}
