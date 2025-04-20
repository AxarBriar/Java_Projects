/*
 * Assessment: Assignment 2
 * Author: Ewan Smith
 * Date: November 24th 2024 
 * Class: CST8116 Section 352
 * Description: A program that recieves battery dimensions and checks if they are within tolerance
 * Lab Professor: Mohammod Patoary
 */

public class BatteryChecker {
	
	 
	// EPSILON_DIAMETER as the acceptable diameter tolerance (in mm)
	// EPSILON_HEIGHT as the acceptable height tolerance (in mm)
	private static final double EPSILON_DIAMETER = 0.1 + Math.pow(10, -14);
	private static final double EPISILON_HEIGHT = 0.3 + Math.pow(10, -14);
	
	
	
	public boolean checkWithinTolerance(Battery battery) { 
		//Create local variables
		double minDiameter;
		double maxDiameter;
		double minHeight;
		double maxHeight;
		
		//Calculates the min and max values of diameter and height using the reference values
		minDiameter = Math.abs(Battery.EXPECTED_DIAMETER - EPSILON_DIAMETER);
		maxDiameter = Math.abs(Battery.EXPECTED_DIAMETER + EPSILON_DIAMETER);
		minHeight = Math.abs(Battery.EXPECTED_HEIGHT - EPISILON_HEIGHT);
		maxHeight = Math.abs(Battery.EXPECTED_HEIGHT + EPISILON_HEIGHT);
		
		//Checks if the inputted diameter and height are within tolerance and returns true if it is
		if ((battery.getDiameter() >= minDiameter && battery.getDiameter() <= maxDiameter)&&
				(battery.getHeight() >= minHeight && battery.getHeight() <= maxHeight)){
			return true;
		}
		//If the inputted diameter and height are not within tolerance than return false
		else {
		return false; 
		}		
	}
}
