package account;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Holder: ");
        String holder = scanner.next();
        System.out.print("Initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = scanner.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        int option;
        do {
            System.out.println("1 - Withdraw\n2 - Deposit\n0 - Close");
            option = scanner.nextInt();
            if (option == 1) {
                System.out.print("Enter amount for withdraw: ");
                double amount = scanner.nextDouble();
                try {
                    account.withdraw(amount);
                } catch (WithdrawException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option == 2) {
                System.out.print("Enter amount for deposit: ");
                double amount = scanner.nextDouble();
                try {
                    account.deposit(amount);
                } catch (DepositException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 0);

        scanner.close();
    }
}
