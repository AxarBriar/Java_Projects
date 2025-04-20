package starter_code;

/**
 * This program takes personal information from the user 
 * to determine their fitness level using the predetermined criteria. Upon receiving the information
 * it will output to the user their fitness level and the criteria for why they fell into that criteria
 * 
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 */

public class FitnessTracker {
	/**
	 * Initializes static values for how many meters a person walks based on their gender 
	 */
	private static final double MALE_STEP = 0.8;
	private static final double FEMALE_STEP = 0.7;
	
	private String firstName;
	private String lastName;
	private String gender;
	private int stepsTaken;
	private int caloriesBurned;
	private int caloriesMaintened;
	private int activeMins;
	
	/**
	 *  
	 * Creates FitnessTracker constructor to receive the user information
	 *  
	 *  
	 * @param firstName
	 * 			The user's first name
	 * @param lastName
	 * 			The user's last name
	 * @param gender
	 * 			The user's gender
	 * @param stepsTaken
	 * 			The steps taken by the user
	 * @param caloriesBurned
	 * 			The calories burned by the user
	 * @param activeMins
	 * 			The daily active minutes of the user
	 * @param caloriesMaintained
	 * 			The calories maintained by the user
	 */
	public FitnessTracker(String firstName, String lastName, String gender, int stepsTaken, int caloriesBurned, int activeMins, int caloriesMaintained) {
		setFirstName (firstName);
		setLastName (lastName);
		setGender (gender);
		setStepsTaken(stepsTaken);
		setCaloriesBurned (caloriesBurned);
		setActiveMins (activeMins);
		setCaloriesMaintened (caloriesMaintained);
	}

	/**
	 * Returns the user's first name
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name
	 * @param firstName
	 * 		The user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return's the user's last name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name
	 * @param lastName
	 * 		The user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return's the user's gender
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the user's gender
	 * @param gender
	 * 		The user's gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 *  Return the steps taken
	 * @return stepsTaken
	 */
	public int getStepsTaken() {
		return stepsTaken;
	}

	/**
	 * Sets the steps taken
	 * @param stepsTaken
	 * 		The daily steps taken by the user
	 */
	public void setStepsTaken(int stepsTaken) {
		this.stepsTaken = stepsTaken;
	}
	
	/**
	 * Return the calories burned by the user
	 * @return caloriesBurned
	 */
	public int getCaloriesBurned() {
		return caloriesBurned;
	}

	/**
	 * Sets the caloriesBurned by the user
	 * @param caloriesBurned
	 * 		The calories burned by the user
	 */
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	/**
	 * Returns the user's active minutes
	 * @return activeMins
	 */
	public int getActiveMins() {
		return activeMins;
	}

	/**
	 * Sets the user's active minutes
	 * @param activeMins
	 * 		The minutes the user is active daily
	 */
	public void setActiveMins(int activeMins) {
		this.activeMins = activeMins;
	}
	
	/**
	 * Returns the user's maintained calories
	 * @return caloriesMaintained
	 */
	public int getCaloriesMaintened() {
		return caloriesMaintened;
	}

	/**
	 * Sets the user's maintained calories
	 * @param caloriesMaintened
	 * 		The calories maintained by the user
	 */
	public void setCaloriesMaintened(int caloriesMaintened) {
		this.caloriesMaintened = caloriesMaintened;
	}
	
	/**
	 * Takes the steps taken and the gender to calculate the distance
	 * @param stepsTaken
	 * 		The steps taken by the user
	 * @param gender
	 * 		The user's gender
	 * @return distance
	 * 		The distance walked by the user
	 */
	public double calculateDistance(int stepsTaken, String gender) {
		double distance = 0;
		
		if (gender.equalsIgnoreCase("male")) {
			distance = stepsTaken * MALE_STEP;
		}
		else if (gender.equalsIgnoreCase("female")){
			distance = stepsTaken * FEMALE_STEP;
		}
		return distance;
	}
	
	/**
	 * Takes the user's active minutes and calculates the weekly average
	 * @param activeMins
	 * 		The daily active minutes of the user
	 * @return activeMins
	 */
	public int weeklyAverageMins(int activeMins) {
		return activeMins*=7;
	}
	
	/**
	 * Takes how many calories the user burned and how long they are active each day and returns their fitness level
	 * 
	 * @param caloriesBurned
	 * 		The calories burned by the user
	 * @param activeMins
	 * 		The minutes that the user is active daily
	 * @return A string displaying the user's fitness level
	 */
	public String fitnessLevel(int caloriesBurned, int activeMins) {
		if (caloriesBurned > 2000 && activeMins > 150) {
			return "Active";
		}
		else if ((caloriesBurned > 1000 || caloriesBurned < 2000) && (activeMins > 75 || activeMins < 150)) {
			return "Moderately Active";
		}
		else {
			return "Sedentary";
		}
		
	}
	/**
	 * Takes the users maintained calories and burned calories and calculates their calorie level
	 * @param caloriesMaintained
	 * 		The user's maintained calories
	 * @param caloriesBurned
	 * 		The user's burned calories
	 * @return caloriesMainted - caloriesBurned
	 * 		Returns the calorie level
	 */
	public double calorieLevel(int caloriesMaintained, int caloriesBurned) {
		return caloriesMaintained - caloriesBurned;
	}
	
	/**
	 * Takes the data entered by the user and calculated by the appropriate methods and displays it to the user
	 */
	public void displayFitnessData() {

		System.out.println("---User Fitness Data---");
		System.out.printf("Name: " + firstName + " " + lastName);
		System.out.println();
		System.out.printf("Gender: " + gender);
		System.out.println();
		System.out.printf("Daily Steps: " + stepsTaken);
		System.out.println();
		System.out.printf("Distance walked: " + this.calculateDistance(stepsTaken, gender)+ " "+ "metres");
		System.out.println();
		System.out.printf("Fitness Level: " + this.fitnessLevel(caloriesBurned, activeMins));
		System.out.println();
		System.out.printf("Daily Calorie Deficit/Surplus: " + this.calorieLevel(caloriesMaintened, caloriesBurned));
		System.out.println();


		System.out.println("Fitness Level Criteria:");
		System.out.println("Active: More than 150 active minutes per week and over 2000 calories burned.");
		System.out.println("Moderately Active: 75-150 active minutes per week or 1000-2000 calories burned.");
		System.out.println("Sedentary: Less than 75 active minutes per week and under 1000 calories burned.");
	}






}