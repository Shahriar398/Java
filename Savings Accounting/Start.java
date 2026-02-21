import java.lang.*;
import java.util.Scanner;

public class Start {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Customer c = new Customer(phoneNumber);

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Show All Accounts");
            System.out.println("4. Get Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("1. Regular Account");
                    System.out.println("2. Savings Account");
                    System.out.println("3. Fixed Account");
                    System.out.print("Enter account type: ");
                    int accountType = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); 

                    if (accountType == 1) {
                        Account a = new Account();
                        a.setAccountHolderName(accountHolderName);
                        a.setAccountNumber(accountNumber);
                        a.setBalance(balance);
                        c.addAccount(a);
                    } else if (accountType == 2) {
                        System.out.print("Enter interest rate: ");
                        double interestRate = scanner.nextDouble();
                        scanner.nextLine(); 

                        SavingsAccount sa = new SavingsAccount();
                        sa.setAccountHolderName(accountHolderName);
                        sa.setAccountNumber(accountNumber);
                        sa.setBalance(balance);
                        sa.setInterestRate(interestRate);
                        c.addAccount(sa);
                    } else if (accountType == 3) {
                        System.out.print("Enter tenure year: ");
                        int tenureYear = scanner.nextInt();
                        scanner.nextLine(); 

                        FixedAccount fa = new FixedAccount();
                        fa.setAccountHolderName(accountHolderName);
                        fa.setAccountNumber(accountNumber);
                        fa.setBalance(balance);
                        fa.setTenureYear(tenureYear);
                        c.addAccount(fa);
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number to remove: ");
                    int removeAccountNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    Account accountToRemove = c.getAccount(removeAccountNumber);
                    if (accountToRemove != null) {
                        c.removeAccount(accountToRemove);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    c.showAllAccounts();
                    break;

                case 4:
                    System.out.print("Enter account number to get: ");
                    int getAccountNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    Account accountToGet = c.getAccount(getAccountNumber);
                    if (accountToGet != null) {
                        accountToGet.showDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
