import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private Account account;
    private Bank bank;
    private Scanner scanner;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public ATM(Account account, Bank bank, Scanner scanner) {
        this.account = account;
        this.bank = bank;
        this.scanner = scanner;
    }

    public void start() {
        int choice=0;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void showHistory() {
        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactions.isEmpty()) {
            System.out.println("No transactions in this session.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: Rs. ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds!");
        } else {
            account.setBalance(account.getBalance() - amount);

            transactions.add(new Transaction(
                    "Withdrawal", amount, "Cash withdrawn successfully"));

            System.out.println("Please collect your cash.");
            System.out.printf("Remaining balance: Rs. %.2f%n",
                    account.getBalance());
        }
    }

    private void deposit() {
        System.out.print("Enter deposit amount: Rs. ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            account.setBalance(account.getBalance() + amount);

            transactions.add(new Transaction(
                    "Deposit", amount, "Amount deposited successfully"));

            System.out.println("Deposit successful!");
            System.out.printf("Updated balance: Rs. %.2f%n",
                    account.getBalance());
        }
    }

    private void transfer() {
        System.out.print("Enter recipient account ID: ");
        String recipientId = scanner.next();

        if (recipientId.equals(account.getAccountId())) {
            System.out.println("You cannot transfer money to your own account.");
            return;
        }

        Account recipient = bank.findAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }

        System.out.print("Enter transfer amount: Rs. ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds!");
        } else {
            account.setBalance(account.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);

            transactions.add(new Transaction(
                    "Transfer", amount,
                    "Transferred to account " + recipientId));

            System.out.println("Transfer successful!");
            System.out.printf("Remaining balance: Rs. %.2f%n",
                    account.getBalance());
        }
    }

    private void checkBalance() {
        System.out.printf("Current balance: Rs. %.2f%n",
                account.getBalance());
    }
}
