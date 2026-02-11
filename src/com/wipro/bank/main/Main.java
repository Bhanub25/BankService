package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;

public class Main {
    public static void main(String [] args) {
        BankService bankService = new BankService();

        int fromAccount = 1234567890;
        int toAccount = 1234567891;

        System.out.println("Balance of Bhanu: " + bankService.checkBalance(fromAccount));
        System.out.println("Balance of Feaner: " + bankService.checkBalance(toAccount));

        
        TransferBean transferBean = new TransferBean();
        transferBean.setFromAccountNumber(fromAccount);
        transferBean.setToAccountNumber(toAccount);
        transferBean.setAmount(500);
        transferBean.setDateOfTransaction(new java.util.Date());

        System.out.println("Transfer Result: " + bankService.transfer(transferBean));

        
        System.out.println("Balance of Bhanu after transfer: " + bankService.checkBalance(fromAccount));
        System.out.println("Balance of Feaner after transfer: " + bankService.checkBalance(toAccount));
    }
}
