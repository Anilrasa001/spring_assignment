package com.account.factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountFactory factory = new AccountFactory();

        System.out.print("Enter account type (Savings / Fixed / Recurring): ");
        String type = scanner.nextLine();

        Account account = factory.getAccount(type);
        if (account != null) {
            account.accountType();
        } else {
            System.out.println("Invalid account type entered.");
        }

        scanner.close();
    }
}
