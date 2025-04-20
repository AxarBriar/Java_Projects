/**
 * This program prompts the user to input their personal information and then calls
 * on the methods in the Fitness Tracker class to calculate the appropriate data
 * 
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 */
package Assignment1_Test;

import java.util.Scanner;

import starter_code.FitnessTracker;


public class FitnessTrackerTest {

	public static void main(String[] args) {
		/**
		 * Creates the Scanner object to receive inputs from the user
		 */
		Scanner input = new Scanner(System.in);
		
		/**
		 * Initializes the variables to be inputed by the user
		 */
		String firstName, lastName, gender;
		int stepsTaken, caloriesBurned, activeMins, caloriesMaintained;
	
		/**Prompts the user for the first name**/
		System.out.println("Enter first name: ");
		firstName = input.nextLine();
		
		/**Prompts the user for the last name**/
		System.out.println("Enter last name: ");
		lastName = input.nextLine();
		
		/**Prompts the user for the gender**/
		System.out.println("Enter gender (male/female): ");
		gender = input.nextLine();
		
		/**Prompts the user for the daily steps**/
		System.out.println("Enter daily steps: ");
		stepsTaken = input.nextInt();
		
		/**Prompts the user for the daily calories**/
		System.out.println("Enter daily calories burned: ");
		caloriesBurned = input.nextInt();
		
		/**Prompts the user for the daily minutes**/
		System.out.println("Enter daily active minutes: ");
		activeMins = input.nextInt();
		
		/**Prompts the user for the daily maintenance calories**/
		System.out.println("Enter daily maintaince calories: ");
		caloriesMaintained = input.nextInt();
		
		/**Creates the tracker object to call methods in the FitnessTracker class**/
		FitnessTracker tracker = new FitnessTracker(firstName, lastName, gender, stepsTaken, caloriesBurned, activeMins, caloriesMaintained);
		tracker.calculateDistance(stepsTaken, gender);
		tracker.weeklyAverageMins(activeMins);
		tracker.fitnessLevel(caloriesBurned, activeMins);
		tracker.calorieLevel(caloriesMaintained, caloriesBurned);
		tracker.displayFitnessData();
		
		/** Closes the Scanner*/
		input.close();
	}

}
