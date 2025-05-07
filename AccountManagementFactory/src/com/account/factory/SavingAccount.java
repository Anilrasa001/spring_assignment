package com.account.factory;

public class SavingAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("Savings Account Created");
    }
}
