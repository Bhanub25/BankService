package com.wipro.bank.test;

import java.sql.Connection;
import com.wipro.bank.util.DBUtil;

public class TestDB {
    public static void main(String[] args) {
        if (DBUtil.getDBConnection() != null) {
            System.out.println("✅ Oracle DB Connected Successfully");
        } else {
            System.out.println("❌ Connection Failed");
        }
    }


    }

