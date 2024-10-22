package org.abhinay.atm_machine;

public class DepositTransaction extends Transaction{
    protected DepositTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        this.account.depositMoney(this.amount);
    }
}
