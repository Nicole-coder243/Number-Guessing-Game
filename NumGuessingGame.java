// This is a simple number guessing game in Java.
// The user has to guess a randomly generated number between 1 and 1000.
import java.util.Random;
import java.util.Scanner;
public class NumGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // creates a random number generator
        int number = random.nextInt(1000) + 1; // this generates a random number between 1 and 1000
        int guess = 0; // this is the variable that stores the user's guess
        int attempts = 0; // this is the variable that counts the number of attempts
        int maxAttempts = 5; // this is the maximum number of attempts allowed
        System.out.println("Welcome to Makayla's Number Guessing Game!");
        System.out.println("All you have to do is guess a number between 1 and 1,000.");
        System.out.println("You will have 5 attempts to guess the number.");
        System.out.println("If you guess the number, you win! If not, you lose.");
        System.out.println("If you are closer to the number, you will be given an indication of hot or warm.");
        System.out.println("If you are far from the number, you will be given an indication of cold.");
        System.out.println("Good luck! Let's start the game!");
        while (attempts < maxAttempts) {
            System.out.println("Enter your guess: ");
            if (!scanner.hasNextInt()) { // validate input
                System.out.println("Invalid input! Please enter a number between 1 and 1000.");
                scanner.next(); // clear invalid input
                continue;
            }
            guess = scanner.nextInt();
            if (guess < 1 || guess > 1000) { // check range
                System.out.println("Out of range! Please enter a number between 1 and 1000.");
                continue;
            }
            attempts++; // increment attempts
            if (guess == number) {
                System.out.println("Woohoo! You guessed the number in " + attempts + " attempts!");
                System.out.println("Nicely done! You are a genius!");
                break;
            }
            int difference = Math.abs(number - guess);
            if (difference <= 50) {
                System.out.println("You are fiery hot! You are very close to the number!");
            } else if (difference <= 100) {
                System.out.println("You are smoothly warm! You are getting closer to the number!");
            } else if (difference <= 600) {
                System.out.println("Brrr! You are cold! You are far from the number!");
            } else {
                System.out.println("Right now you are extremely super cold! You are very far from the number!");
            }
            // providing hints only once during the 3rd attempt
            if (attempts == 3) {
                System.out.println("Hint: The number is " + (number % 2 == 0 ? "even" : "odd") + ".");
                if (number < 10) {
                    System.out.println("Hint: The number is a single-digit number.");
                } else if (number < 100) {
                    System.out.println("Hint: The number is a double-digit number.");
                } else {
                    System.out.println("Hint: The number is a triple-digit number.");
                }
            }
            // attempts remaining
            if (attempts < maxAttempts) {
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            } else {
                System.out.println("Oops! You have reached the maximum number of attempts!");
                System.out.println("The number was " + number + ". See you next time! Over and out!");
            }
        }
        // close the scanner to prevent resource leaks
        scanner.close();
    }
}