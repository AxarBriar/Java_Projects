/**
 * This program acts as the test file to test for any potential bugs in the Fitness Tracker class
 * 
 * The test assumes the user is male and they took 4000 steps
 * 
 * The second test assumes the user burned 3000 calories and maintained 2000 calories
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 */

package Assignment1_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import starter_code.FitnessTracker;


class FitnessTrackerTest2 {

	FitnessTracker tracker;
	
	/**
	 * Sets up the Fitness Tracker object before each test
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		tracker = new FitnessTracker("","","",0,0,0,0);
	}
	
	/**
	 * Tears down the Fitness Tracker object after each test by setting it to null
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		tracker = null;
	}

	/**
	 * Tests the calculate distance method in the Fitness Tracker Class
	 */
	@Test @DisplayName("testCalculateDistance")
	public void calculateDistance() {
		assertTrue(tracker.calculateDistance(4000, "female") == 2800);
	}
	
	/**
	 * Tests the calculate calorie deficit method in the Fitness Tracker Class 
	 */
	@Test @DisplayName("testCalorieDeficit")
	public void calculateCalorieDeficit() {
		assertTrue(tracker.calorieLevel(2000, 3000) == -1000);
	}
}
