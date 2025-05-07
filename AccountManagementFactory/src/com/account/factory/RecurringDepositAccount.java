package com.account.factory;

public class RecurringDepositAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("Recurring Deposit Account Created");
    }
}
