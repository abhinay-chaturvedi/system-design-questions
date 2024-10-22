package org.abhinay.atm_machine;

public class WithdrawlTransaction extends Transaction{
    protected WithdrawlTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        this.account.withdrawMoney(this.amount);
    }
}
