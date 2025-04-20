package domain;

/**
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * 
 * Description: Drum Superclass that is used to initialize the variables of a cylindrical drum and calculate its capacity
 */
public class Drum {
	private float height = 0.0f;
	private float diameter = 0.0f;
	private String contents = "UNKNOWN";
	
	
    /**
     * Default constructor that initializes a drum with height and diameter set to 0,
     * and contents set to "UNKNOWN".
     */
    public Drum() {
        this.height = 0;
        this.diameter = 0;
        this.contents = "UNKNOWN";
    }

    /**
     * Constructor that initializes a drum with specified height and diameter.
     * The contents are set to "UNKNOWN".
     *
     * @param height The height of the drum in meters.
     * @param diameter The diameter of the drum in meters.
     */
    public Drum(float height, float diameter) {
        this.height = height;
        this.diameter = diameter;
    }

    /**
     * Constructor that initializes a drum with specified height, diameter, and contents.
     *
     * @param height The height of the drum in meters.
     * @param diameter The diameter of the drum in meters.
     * @param contents The contents of the drum.
     */
    public Drum(float height, float diameter, String contents) {
        this.height = height;
        this.diameter = diameter;
        this.contents = contents;
    }

    /**
     * Retrieves the height of the drum.
     *
     * @return The height of the drum in meters.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height of the drum.
     *
     * @param The height of the drum in meters.
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Retrieves the diameter of the drum.
     *
     * @return The diameter of the drum in meters.
     */
    public float getDiameter() {
        return diameter;
    }

    /**
     * Sets the diameter of the drum.
     *
     * @param The diameter of the drum in meters.
     */
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    /**
     * Retrieves the contents of the drum.
     *
     * @return The contents of the drum.
     */
    public String getContents() {
        return contents;
    }

    /**
     * Sets the contents of the drum.
     *
     * @param contents The contents of the drum.
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Calculates the capacity of the drum in cubic meters, assuming a cylindrical shape.
     *
     * @return The capacity of the drum in cubic meters.
     */
    public float capacity() {
        return (float) (height * Math.PI * Math.pow((diameter / 2), 2));
    }

    /**
     * Returns a string representation of the drum.
     *
     * @return A simple description of the drum.
     */
    public String toString() {
        return "I'm a simple Drum";
    }
}

