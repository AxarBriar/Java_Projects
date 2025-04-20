/*
 * Assessment: Assignment 2
 * Author: Ewan Smith
 * Date: November 24th 2024 
 * Class: CST8116 Section 352
 * Description: A program that prompts the user to enter the dimensions of the battery and keep looping provided the user answers yes
 * Lab Professor: Mohammod Patoary
 */
public class Driver {
	public static void main(String[] args) {
		BatteryChecker batteryChecker = new BatteryChecker();
		Battery battery = new Battery();
		
		//Create Local Variables
		double diameter;
		double height;
		boolean tolerance;
		int counter = 0;
		
		//Will loop the following code as long as the user enters "yes" at the end of the loop
		do {
			diameter = User.inputDouble("Enter measured Diameter:");
			height = User.inputDouble("Enter measured Height: ");
			
			//Set the diameter and height into battery
			battery.setDiameter(diameter);
			battery.setHeight(height);
			
			//Calls on the toString method in the battery class
			//to print the dimensions of the spring
			System.out.println(battery.toString());
			
			//Call on the checkWithinTolerance method to check if the battery
			//is within the tolerance by checking the entered dimensions
			//against the reference battery and tolerance values 
			tolerance = batteryChecker.checkWithinTolerance(battery);
			
			
			
			//If the BatteryChecker method returns true
			// it is within tolerance and prints the following strings
			if (tolerance){
				System.out.println("The battery is within tolerance");
				System.out.println("Program By Ewan Smith");
			}
			// If the battery is not in tolerance, it prints the following strings
			//and increases the tolerance counter by one
			else {
				System.out.println("The battery is not within tolerance");
				System.out.println("Program By Ewan Smith");
				counter++;
			}
		} 
		//As long as the user inputs any variation of the word "yes" 
		//the program will continue to loop
		while(User.inputString("Continue checking: ").equalsIgnoreCase("yes"));
		//Prints out the number of times 
		//the battery dimensions are out of tolerance
		System.out.println("Total times out of tolerance: " + counter);
		
		
	}
}