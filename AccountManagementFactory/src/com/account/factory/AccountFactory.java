package com.account.factory;

public class AccountFactory {
    public Account getAccount(String type) {
        if (type == null) return null;

        switch (type.toLowerCase()) {
            case "savings":
                return new SavingAccount();
            case "fixed":
                return new FixedDepositAccount();
            case "recurring":
                return new RecurringDepositAccount();
            default:
                return null;
        }
    }
}
