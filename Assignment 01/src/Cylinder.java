/*
 * Assessment: Assignment 1
 * Author: Ewan Smith
 * Date: October 6th
 * Class: CST8116 Section 352
 * Description: A program that calculates the volume of a cylinder pyramid
 * Lab Professor: Leanne Seaward
 */

public class Cylinder {
		private double baseVolume;
		private double middleVolume;
		private double topVolume;
		private double radius;
		private double height;
		private double totalVolume;
		
	//Initialize the Setters and Getters	
		public void setRadius(double newRadius) {
			this.radius = newRadius;
		}
		
		public void setHeight(double newHeight) {
			this.height = newHeight;
		}
		
		public double getRadius() {
			return radius;
		}
		
		public double getHeight() {
			return height;
		}
		
	//Create an Overloaded Constructor	
		public Cylinder(double radius, double height) {
			this.radius = radius;
			this.height = height;
		}
		
		//Worker Method to calculates the volume of each cylinder in the pyramid and adds them together to recieve the total volume
		public double computeVolume() {
			baseVolume = height*Math.PI*Math.pow(radius,2);
			middleVolume = height*Math.PI*(Math.pow(0.8*radius,2));
			topVolume = height*Math.PI*(Math.pow(0.64*radius,2));
			totalVolume = baseVolume + middleVolume + topVolume;
			return totalVolume;
		}
}




