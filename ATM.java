import java.util.Scanner;

public class ATM {

    // Account class to simulate a bank account
    static class Account {
        private String accountHolder;
        private double balance;

        // Constructor to initialize account holder and balance
        public Account(String accountHolder, double balance) {
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Method to check balance
        public double checkBalance() {
            return balance;
        }

        // Method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }
    }

    // Main method to simulate ATM operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an account with an initial balance of 1000
        Account account = new Account("John Doe", 1000.0);

        // ATM menu options
        int option;
        do {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Check balance
                    System.out.println("Balance: $" + account.checkBalance());
                    break;

                case 2:
                    // Deposit money
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw money
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    // Exit the ATM system
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);

        scanner.close();
    }
}
