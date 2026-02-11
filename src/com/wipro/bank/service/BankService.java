package com.wipro.bank.service;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.InsufficientFundsException;

public class BankService {
    BankDAO bankDAO = new BankDAO();

    public String checkBalance(int accountNumber) {
        if(bankDAO.validateAccount(accountNumber)) {
            float balance = bankDAO.findBalance(accountNumber);
            return "BALANCE IS " + balance;
        } else {
            return "ACCOUNT NUMBER IS INVALID";
        }
    }

    public String transfer(TransferBean transferBean) {
        try {
            if(transferBean == null) return "INVALID";

            int fromAcc = transferBean.getFromAccountNumber();
            int toAcc = transferBean.getToAccountNumber();

            if(!bankDAO.validateAccount(fromAcc) || !bankDAO.validateAccount(toAcc)) {
                return "INVALID ACCOUNT";
            }

            float amount = transferBean.getAmount();
            float fromBalance = bankDAO.findBalance(fromAcc);
            if(fromBalance < amount) throw new InsufficientFundsException();

            float toBalance = bankDAO.findBalance(toAcc);

            bankDAO.updateBalance(fromAcc, fromBalance - amount);
            bankDAO.updateBalance(toAcc, toBalance + amount);
            bankDAO.transferMoney(transferBean);

            return "SUCCESS";

        } catch (InsufficientFundsException e) {
            return e.toString();
        }
    }
}
