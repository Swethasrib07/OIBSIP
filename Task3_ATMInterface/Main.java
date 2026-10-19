import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        Account loggedInAccount = null;
        int attempts = 0;

        System.out.println("================================");
        System.out.println("        WELCOME TO ATM");
        System.out.println("================================");

        while (attempts < 3) {
            System.out.print("Enter User ID: ");
            String userId = scanner.next();

            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            loggedInAccount = bank.authenticate(userId, pin);

            if (loggedInAccount != null) {
                System.out.println("\nLogin successful!");
                break;
            }

            attempts++;

            System.out.println("Incorrect User ID or PIN.");

            if (attempts < 3) {
                System.out.println("Attempts remaining: " + (3 - attempts));
            }
        }

        if (loggedInAccount == null) {
            System.out.println("\nAccess denied. Too many incorrect attempts.");
        } else {
            ATM atm = new ATM(loggedInAccount, bank, scanner);
            atm.start();
        }

        scanner.close();
    }
}
