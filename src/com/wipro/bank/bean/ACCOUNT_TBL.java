package com.wipro.bank.bean;

public class ACCOUNT_TBL {
    private int Account_Number;
    private String Customer_Name;
    private float Balance;

    public ACCOUNT_TBL(int Account_Number, String Customer_Name, float Balance) {
        this.Account_Number = Account_Number;
        this.Customer_Name = Customer_Name;
        this.Balance = Balance;
    }

    public ACCOUNT_TBL() {}

    public int getAccount_Number() {
        return Account_Number;
    }
    public void setAccount_Number(int account_Number) {
        Account_Number = account_Number;
    }
    public String getCustomer_Name() {
        return Customer_Name;
    }
    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }
    public float getBalance() {
        return Balance;
    }
    public void setBalance(float balance) {
        Balance = balance;
    }
}
