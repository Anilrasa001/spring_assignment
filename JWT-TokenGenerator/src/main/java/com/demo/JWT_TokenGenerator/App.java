package com.demo.JWT_TokenGenerator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Mock Login ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter role (customer/admin): ");
        String role = sc.nextLine();

        // 1) Generate the token
        String token = JwtUtil.generateToken(username, role);
        System.out.println("Generated token: " + token);

        // 2) Validate token for accessing "Customer Dashboard"
        System.out.println("\n=== Access Customer Dashboard ===");
        System.out.print("Paste your token: ");
        String userInputToken = sc.nextLine();

        // Check if token is valid and user has role "customer"
        boolean isValidCustomer = JwtUtil.validateToken(userInputToken, "customer");
        if (isValidCustomer) {
            System.out.println("Access granted to Customer Dashboard!");
        } else {
            System.out.println("Access denied: You are not a customer or token is invalid/expired.");
        }

        // Optional: Print claims for debugging
        // JwtUtil.printClaims(userInputToken);

        sc.close();
    }
}
