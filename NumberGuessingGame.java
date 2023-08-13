import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int round = 1;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (round <= 3) { // Play 3 rounds
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("I have generated a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            while (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == generatedNumber) {
                    hasGuessedCorrectly = true;
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " in " + attempts + " attempts.");
                    System.out.println("Round " + round + " Score: " + roundScore);
                } else if (userGuess < generatedNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            round++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Total Attempts: " + totalAttempts);

        scanner.close();
    }
}