package com.account.factory;

public class FixedDepositAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("Fixed Deposit Account Created");
    }
}
