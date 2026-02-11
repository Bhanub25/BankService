package com.wipro.bank.bean;

import java.util.Date;

public class TransferBean {
    private int transactionId;
    private int fromAccountNumber; // int instead of String
    private int toAccountNumber;   // int instead of String
    private Date dateOfTransaction;
    private float amount;

    public TransferBean(int transactionId, int fromAccountNumber, int toAccountNumber, Date dateOfTransaction, float amount) {
        this.transactionId = transactionId;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }

    public TransferBean() {}

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    public int getFromAccountNumber() { return fromAccountNumber; }
    public void setFromAccountNumber(int fromAccountNumber) { this.fromAccountNumber = fromAccountNumber; }
    public int getToAccountNumber() { return toAccountNumber; }
    public void setToAccountNumber(int toAccountNumber) { this.toAccountNumber = toAccountNumber; }
    public Date getDateOfTransaction() { return dateOfTransaction; }
    public void setDateOfTransaction(Date dateOfTransaction) { this.dateOfTransaction = dateOfTransaction; }
    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
}
