package domain;

/**
  *@author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * @see Drum
 * 
 *  Description: Class for creating and calculating the capacity of a Toxic Drum
 */

public class ToxicDrum extends Drum {
	private String toxicity;
	public static final String CLASS_IA = "extremeely hazardous";
	public static final String CLASS_IB = "highly hazardous";
	public static final String CLASS_II = "moderately hazardous";
	public static final String CLASS_III = "slightly hazardous";
	
	/**
     * Default constructor that initializes a toxic drum with default dimensions,
     * contents, and a toxicity classification of CLASS_III.
     */
    public ToxicDrum() {
        super();
        this.toxicity = CLASS_III;
    }

    /**
     * Constructor that initializes a toxic drum with specified height and diameter.
     *
     * @param height 
     * 		The height of the drum in meters.
     * @param diameter 
     * 		The diameter of the drum in meters.
     */
    public ToxicDrum(float height, float diameter) {
        super(height, diameter);
    }

    /**
     * Constructor that initializes a toxic drum with specified height, diameter, and contents.
     *
     * @param height 
     * 			The height of the drum in meters.
     * @param diameter 
     * 		The diameter of the drum in meters.
     * @param contents 
     * 		The contents of the drum.
     */
    public ToxicDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
    }

    /**
     * Constructor that initializes a toxic drum with specified height, diameter, contents,
     * and toxicity classification.
     *
     * @param height 
     * 			The height of the drum in meters.
     * @param diameter 
     * 			The diameter of the drum in meters.
     * @param contents 
     * 		The contents of the drum.
     * @param toxicity 
     * 		The toxicity classification of the drum's contents.
     */
    public ToxicDrum(float height, float diameter, String contents, String toxicity) {
        super(height, diameter, contents);
        this.toxicity = toxicity;
    }

    /**
     * Retrieves the toxicity classification of the drum's contents.
     *
     * @return The toxicity classification of the drum's contents.
     */
    public String getToxicity() {
        return toxicity;
    }

    /**
     * Sets the toxicity classification of the drum's contents.
     *
     * @param toxicity 
     * 		The toxicity classification of the drum's contents.
     */
    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }

    /**
     * Returns a string representation of the toxic drum, including its height, diameter, contents, capacity, and toxicity classification.
     *
     * @return A descriptive string representation of the toxic drum.
     */
    @Override
    public String toString() {
        return ("  Height: " + getHeight() + "  Diameter: " + getDiameter() + " Contents: " + getContents() + " Capacity: " + capacity() + " Toxicity Class: " + toxicity);
    }

    /**
     * Calculates the capacity of the toxic drum in cubic meters, which have a capacity of 75% of a cylindrical drum.
     *
     * @return The capacity of the drum in cubic meters.
     */
    @Override
    public float capacity() {
        return (float) ((0.75) * (getHeight() * Math.PI * Math.pow((getDiameter() / 2), 2)));
    }
}



