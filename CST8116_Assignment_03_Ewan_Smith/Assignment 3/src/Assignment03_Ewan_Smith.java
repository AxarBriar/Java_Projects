/*
 * Assessment: Assignment 3
 * Author: Ewan Smith
 * Date: December 6th 2024 
 * Class: CST8116 Section 352
 * Description: A program that simulates the roll of a dice ten times and then outputs the result of each roll and how many each number is rolled
 * Lab Professor: Mohammod Patoary
 */
public class Assignment03_Ewan_Smith {

	public static void main(String[] args) {
		// The program rolls a 6-sided dice NUM_ROLLS times, records the results,
		// and then counts how many times each number was rolled.
		final int NUM_ROLLS = 10;
		int[] rollResults = new int[NUM_ROLLS];
		//countResults[i] represents the number of times i+1 is rolled
		int[] countResults = new int[6];
		// Roll the dice NUM_ROLLS times
		for(int count = 0; count < NUM_ROLLS; ++count) {
		 // Math.random() generates a random number between 0.0 and 1.0, multiply by 6 to get 0-5,
		 // add 1 to get a number between 1 and 6 for each roll
		 rollResults[count] = (int)(Math.random() * 6) + 1;
		 // Increment the count for the rolled number
		 countResults[rollResults[count] - 1]++;
		}
		// Display the results
		for(int rollNum = 0; rollNum < rollResults.length; ++rollNum) { //Prints the result of each roll
		 System.out.printf("Result of roll #%d is: %d%n", rollNum+1, rollResults[rollNum]);
		}
		System.out.println("\nCount of each number rolled:");
		for(int i = 0; i < countResults.length; ++i) {   //Prints how many times each number was rolled
		 System.out.printf("Number %d was rolled %d times.%n", i + 1, countResults[i]);
		}
		System.out.println("Program by Ewan Smith");

	}

}
