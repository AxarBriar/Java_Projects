package domain;

/**
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * @see Drum
 * 
 * Description: Class for creating and calculating the capacity of a Flammable Drum
 */
public class FlammableDrum extends Drum {

	private float flashpoint;
	
	 /**
     * Default constructor that initializes a flammable drum with default dimensions, 
     * contents, and a flashpoint of 0.0 degrees Celsius.
     */
    public FlammableDrum() {
        super();
        this.flashpoint = 0.0f;
    }

    /**
     * Constructor that initializes a flammable drum with specified height and diameter.
     *
     * @param height 
     * 		The height of the drum in meters.
     * @param diameter 
     * 		The diameter of the drum in meters.
     */
    public FlammableDrum(float height, float diameter) {
        super(height, diameter);
    }

    /**
     * Constructor that initializes a flammable drum with specified height, diameter, and contents.
     *
     * @param height 
     * 			The height of the drum in meters.
     * @param diameter 
     * 			The diameter of the drum in meters.
     * @param contents 
     * 			The contents of the drum.
     */
    public FlammableDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
    }

    /**
     * Constructor that initializes a flammable drum with specified height, diameter, contents, 
     * and flashpoint.
     *
     * @param height 
     * 			The height of the drum in meters.
     * @param diameter 
     * 			The diameter of the drum in meters.
     * @param contents 
     * 			The contents of the drum.
     * @param flashpoint
     * 			The flashpoint of the drum's contents in degrees Celsius.
     */
    public FlammableDrum(float height, float diameter, String contents, float flashpoint) {
        super(height, diameter, contents);
        this.setFlashpoint(flashpoint);
    }

    /**
     * Retrieves the flashpoint of the drum's contents.
     *
     * @return flashpoint 
     * 		The flashpoint of the drum's contents in degrees Celsius.
     */
    public float getFlashpoint() {
        return flashpoint;
    }

    /**
     * Sets the flashpoint of the drum's contents.
     *
     * @param flashpoint 
     * 		The flashpoint of the drum's contents in degrees Celsius.
     */
    public void setFlashpoint(float flashpoint) {
        this.flashpoint = flashpoint;
    }

    /**
     * Returns a string representation of the flammable drum, including its height, diameter, contents, capacity, and flashpoint.
     *
     * @return A descriptive string representation of the flammable drum.
     */
    @Override
    public String toString() {
        return ("  Height: " + getHeight() + "  Diameter: " + getDiameter() + "  Contents: " + getContents() + "  Capacity:  " + capacity() + " Flashpoint: " + flashpoint);
    }

    /**
     * Calculates the capacity of the flammable drum in meters.
     * 
     * @return The capacity of the drum in meters.
     */
    @Override
    public float capacity() {
        return (float) (getHeight() * Math.PI * Math.pow((getDiameter() / 2), 2));
    }
}

