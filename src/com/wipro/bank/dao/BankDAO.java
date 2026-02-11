package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {

    public boolean validateAccount(int accountNumber){
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT * FROM account_tbl WHERE Account_Number=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public float findBalance(int accountNumber){
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT Balance FROM ACCOUNT_TBL WHERE Account_Number=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountNumber);  // must use setInt because Account_Number is INT
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat("Balance"); // or rs.getFloat(1)
            } else {
                return -1; // account not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public boolean updateBalance(int accountNumber, float newBalance){
        Connection connection = DBUtil.getDBConnection();
        String query = "UPDATE account_tbl SET Balance=? WHERE Account_Number=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, newBalance);
            ps.setInt(2, accountNumber);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean transferMoney(TransferBean transferBean){
        Connection connection = DBUtil.getDBConnection();
        String query = "INSERT INTO TRANSFER_TBL " +
        	    "(TRANSACTION_ID, ACCOUNT_NUMBER, BENEFICIARY_ACCOUNT_NUMBER, TRANSACTION_DATE, TRANSACTION_AMOUNT) " +
        	    "VALUES (transactionId_seq1.NEXTVAL, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, transferBean.getFromAccountNumber());
            ps.setInt(2, transferBean.getToAccountNumber());
            ps.setDate(3, new Date(transferBean.getDateOfTransaction().getTime()));
            ps.setFloat(4, transferBean.getAmount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
