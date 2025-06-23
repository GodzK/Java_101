import java.io.*;
import java.util.*;

// Interface
interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void displayBalance();
}

// Abstract class
abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public abstract void accountType();
}

// Concrete class using inheritance and interface
class SavingsAccount extends Account implements BankOperations {
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount(String accountNumber, String holderName) {
        super(accountNumber, holderName);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new Exception("Insufficient balance.");
            }
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

    @Override
    public void accountType() {
        System.out.println("Account Type: Savings");
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

// Main class
public class Bank {
    // Static field
    static Scanner scanner = new Scanner(System.in);

    // Final method
    public final static void printWelcome() {
        System.out.println("=== Welcome to Java Bank ===");
    }

    public static void main(String[] args) {
        printWelcome();

        // ArrayList to store multiple accounts
        ArrayList<SavingsAccount> accounts = new ArrayList<>();

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();

        // Create account using constructor
        SavingsAccount acc = new SavingsAccount(accNum, name);
        accounts.add(acc);

        acc.accountType();
        acc.deposit(500);
        acc.withdraw(100);
        acc.addInterest();
        acc.displayBalance();

        // File I/O: Save balance to file
        try (FileWriter writer = new FileWriter("account_balance.txt")) {
            writer.write("Account Holder: " + name + "\n");
            writer.write("Balance: $" + acc.balance + "\n");
            System.out.println("Account info saved to file.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        // Loop to show multiple account balances
        System.out.println("\nAll Accounts:");
        for (SavingsAccount a : accounts) {
            System.out.println(a.holderName + ": $" + a.balance);
        }
    }
}
