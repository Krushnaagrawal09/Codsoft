package guessthenumberpack;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumbers_Game {

	public static void main(String[] args) {

		int rangeStartsWith = 1;
		int rangeEndsWith = 100;
		int forDontGenerateZero = 1;
		int maxAttempt = 5;
		int roundOwned = 0;
		int roundPlayed = 0;

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		boolean playAgain = true;

		while (playAgain) {
			// Step 1 : Generate the number between 1 to 100
			int generatedNumber = random.nextInt(rangeEndsWith) + forDontGenerateZero;
//			System.out.println(generatedNumber);
			System.out.println("Guess the number between 1 to 100");
			int attempt = 0;
			while (attempt < maxAttempt) {
				System.out.println("Attempts left : " + (maxAttempt - attempt));
				
				// Step 2 : Prompt the user to enter their guess
				System.out.print("Enter your guess : ");
				int userGuess = scanner.nextInt();
				
				// Step 3 : Compare the user's guess with the generated number
				if (userGuess == generatedNumber) {
					System.out.println("Congratulations! You guessed the correct number in " + (attempt + 1));
					roundOwned++;
					break;
				} else if (userGuess > generatedNumber) {
					System.out.println("Too high! Try again");
				} else {
					System.out.println("Too low! Try again");
				}
				//increase attempt
				attempt++;
			}

			// Ask if the user wants to play again
			System.out.println("Do you want to play again? (yes/no): ");
			String wantPlayAgain = scanner.next();
			if (wantPlayAgain.equalsIgnoreCase("No")) {
				playAgain = false;
			}
		
			++roundPlayed;

		}

		// Display user's score
		System.out.println("Total Rounds played : " + roundPlayed);
		System.out.println("Total Rounds won : " + roundOwned);

		if (roundPlayed > 2 && roundPlayed == roundOwned) {
			System.out.println("Congrats! you are *Conqueror Player*");
		}

		System.out.println("Thanks! for playing!!");
	}
}
