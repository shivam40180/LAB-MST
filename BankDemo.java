import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }

    public double getBalance(int enteredPin) {
        if (enteredPin == pin) {
            return balance;
        } else {
            System.out.println("Incorrect PIN! Access denied.");
            return -1;
        }
    }

    public void deposit(double amount, int enteredPin) {
        if (enteredPin == pin) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful! New balance: " + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Incorrect PIN! Transaction denied.");
        }
    }

    public void withdraw(double amount, int enteredPin) {
        if (enteredPin == pin) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: " + balance);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Incorrect PIN! Transaction denied.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount("123456789", "Shivam Kumar", 1000000.0, 4321);

        account.displayAccountInfo();

        System.out.print("\nEnter PIN to Deposit: ");
        int pin = sc.nextInt();
        System.out.print("Enter amount to Deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount, pin);

        System.out.print("\nEnter PIN to Withdraw: ");
        pin = sc.nextInt();
        System.out.print("Enter amount to Withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount, pin);

        System.out.print("\nEnter PIN to Check Balance: ");
        pin = sc.nextInt();
        double balance = account.getBalance(pin);
        if (balance != -1)
            System.out.println("Your Current Balance: " + balance);

        sc.close();
    }
}
