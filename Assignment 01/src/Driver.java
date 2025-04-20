/*
 * Assessment: Assignment 1
 * Author: Ewan Smith
 * Date: October 6th, 2024
 * Class: CST8116 Section 352
 * Description: A program that asks the user inputs for the volume of a cylinder pyramid
 * Lab Professor: Leanne Seaward
 */

import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		//Initializing a string value to be formatted and outputted to the user upon calculating the total volume
		String statement = "My dear human, the volume of your spectacular pyramid is:";
		
		//Asking user to input the radius and height
		Scanner input = new Scanner(System.in);
		double radius, height;
		System.out.print("Dear human, please enter the base cylinder radius: ");
		radius = input.nextDouble();
		System.out.print("Oh mighty human, kindly enter the base cylinder height: ");
		height = input.nextDouble();
		
		//Creates the pyramid object that calls on the worker method in the Cylinder class to calculate the volume
		Cylinder pyramid = new Cylinder(radius,height);
		double volume = pyramid.computeVolume();
		
		//Outputs the statement to the user along with the author of the program
		System.out.printf("%s %.3f",statement, volume);
		System.out.println();
		System.out.println("Program by Ewan Smith");
		
		input.close();
		
	}

}
