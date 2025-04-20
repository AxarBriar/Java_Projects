package assn3;

/**
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * 
 * Description: Provides getter and setter methods for each ingredient and recipe details
 */

public class Recipe {
	private String name;
	private float sugar;
	private float eggs;
	private float flour;
	private float yeast;
	private float butter;
	private int breadQuantity;
	
    /**
     * Default constructor
     */
    public Recipe() {
        this.breadQuantity = 0;
    }
    
    /**
     * Constructor with name parameter
     * @param name 
     * 		The name of the bread recipe
     */
    public Recipe(String name) {
        this.name = name;
        this.breadQuantity = 0;
    }

    /**
     * Returns the name of the recipe.
     *
     * @return The recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the recipe.
     *
     * @param name 
     * 		The recipe name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the amount of sugar.
     *
     * @return The sugar amount in cups
     */
    public float getSugar() {
        return sugar;
    }

    /**
     * Sets the amount of sugar.
     *
     * @param sugar 
     * 		The sugar amount in cups to set
     */
    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    /**
     * Returns the number of eggs.
     *
     * @return The number of eggs
     */
    public float getEggs() {
        return eggs;
    }

    /**
     * Sets the number of eggs.
     *
     * @param eggs 
     * 		The number of eggs to set
     */
    public void setEggs(float eggs) {
        this.eggs = eggs;
    }

    /**
     * Returns the amount of flour.
     *
     * @return The flour amount in cups
     */
    public float getFlour() {
        return flour;
    }

    /**
     * Sets the amount of flour.
     *
     * @param flour 
     * 		The flour amount in cups to set
     */
    public void setFlour(float flour) {
        this.flour = flour;
    }

    /**
     * Returns the amount of yeast.
     *
     * @return The yeast amount in tablespoons
     */
    public float getYeast() {
        return yeast;
    }

    /**
     * Sets the amount of yeast.
     *
     * @param yeast 
     * 		The yeast amount in tablespoons to set
     */
    public void setYeast(float yeast) {
        this.yeast = yeast;
    }

    /**
     * Returns the amount of butter.
     *
     * @return The butter amount in cups
     */
    public float getButter() {
        return butter;
    }

    /**
     * Sets the amount of butter.
     *
     * @param butter 
     * 		The butter amount in cups to set
     */
    public void setButter(float butter) {
        this.butter = butter;
    }

    /**
     * Returns the quantity of bread to be made.
     *
     * @return The bread quantity
     */
    public int getBread() {
        return breadQuantity;
    }

    /**
     * Sets the quantity of bread to be made.
     *
     * @param breadQuantity 
     * 		The number of breads to set
     */
    public void setBread(int breadQuantity) {
        this.breadQuantity = breadQuantity;
    }
}
