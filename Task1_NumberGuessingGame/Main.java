
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalAttempts = 0;

        System.out.println("================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("================================");

        String playAgain;

        do {
            // Difficulty selection
            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            int maxNumber;
            int maxAttempts;

            switch (choice) {
                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;

                case 2:
                default:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;
            }

            // Generate a random number
            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.");

            // Guessing loop
            while (attempts < maxAttempts) {

                System.out.print("\nAttempt " + (attempts + 1)
                        + "/" + maxAttempts + " - Enter your guess: ");

                int guess = scanner.nextInt();

                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Please enter a number between 1 and "
                            + maxNumber + ".");
                    continue;
                }

                attempts++;

                if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct! You guessed the number!");
                    System.out.println("You guessed it in " + attempts
                            + " attempts.");
                    guessedCorrectly = true;
                    break;
                }
            }

            // Round result
            if (!guessedCorrectly) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + secretNumber);
            }

            totalAttempts += attempts;

            System.out.println("\n========== ROUND SUMMARY ==========");
            System.out.println("Round: " + round);
            System.out.println("Result: "
                    + (guessedCorrectly ? "Won" : "Lost"));
            System.out.println("Attempts used: " + attempts);
            System.out.println("Total attempts across rounds: " + totalAttempts);
            System.out.println("===================================");

            round++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThanks for playing!");
        System.out.println("Total rounds played: " + (round - 1));
        System.out.println("Total attempts: " + totalAttempts);

        scanner.close();
    }
}
