import java.util.Scanner;

class BankAccount {
    private double balance;
    private String accountHolder;

    // Constructor to initialize the bank account with an account holder and initial balance
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to check the balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to print account information
    public void printAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize ATM with an account and scanner
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawFunds();
                    break;
                case 3:
                    depositFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to check the balance
    private void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    // Method to handle the withdrawal process
    private void withdrawFunds() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Your new balance is: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    // Method to handle the deposit process
    private void depositFunds() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: $" + account.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount("John Doe", 1000.00);

        // Create an ATM with the bank account
        ATM atm = new ATM(account);

        // Display the ATM menu and start the ATM process
        atm.displayMenu();
    }
}
