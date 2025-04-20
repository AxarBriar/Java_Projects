package assn3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * 
 * Description: Provides the methods used to load recipes from the file,
 * manage the quantity of bread, generate the shopping list and saving the list
 * to a file.
 */

public class RecipeManager {
    /** A list of all loaded recipes */
    private List<Recipe> recipes;

    /**
     * Constructs a new RecipeManager with an empty list of recipes.
     */
    public RecipeManager() {
        recipes = new ArrayList<>();
    }

    /**
     * Loads recipes from a given text file.
     *
     * @param readFile 
     * 		The file path to read recipes from
     * @throws IOException 
     * 		If an error occurs while reading the file
     */
    public void loadRecipes(String readFile) throws IOException {
        recipes.clear();

        try (FileReader recipeReader = new FileReader(readFile);
             Scanner reader = new Scanner(recipeReader)) {

            Recipe currentRecipe = null;

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("Recipe ")) {
                    if (currentRecipe != null) {
                        recipes.add(currentRecipe);
                    }

                    String recipeName = line.substring(7).trim();
                    currentRecipe = new Recipe();
                    currentRecipe.setName(recipeName);

                } else if (currentRecipe != null) {
                    String[] items = line.split("\\s+");
                    if (items.length == 2) {
                        String ingredient = items[0].toLowerCase();
                        try {
                            float amount = Float.parseFloat(items[1]);

                            switch (ingredient) {
                                case "eggs":
                                    currentRecipe.setEggs(amount);
                                    break;
                                case "yeast":
                                    currentRecipe.setYeast(amount);
                                    break;
                                case "flour":
                                    currentRecipe.setFlour(amount);
                                    break;
                                case "butter":
                                    currentRecipe.setButter(amount);
                                    break;
                                case "sugar":
                                    currentRecipe.setSugar(amount);
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount entry for " + ingredient + ": " + items[1]);
                        }
                    }
                }
            }

            if (currentRecipe != null) {
                recipes.add(currentRecipe);
            }

        } catch (IOException e) {
            System.out.println("The file could not be read: " + e.getMessage());
        }
    }

    /**
     * Retrieves a recipe at a specific index in the list.
     *
     * @param index 
     * 		The index of the recipe
     * @return The recipe at the specified index
     * @throws IndexOutOfBoundsException 
     * 		If the index is invalid
     */
    public Recipe getRecipe(int index) {
        if (index < 0 || index >= recipes.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return recipes.get(index);
    }

    /**
     * Gets the number of recipes loaded in the manager.
     *
     * @return The number of recipes
     */
    public int getRecipeCount() {
        return recipes.size();
    }

    /**
     * Orders a certain quantity of bread using a selected recipe.
     *
     * @param index 
     * 		The index of the recipe to use
     * @param breadQuantity 
     * 		The number of loaves to order
     * @throws IndexOutOfBoundsException 
     * 		If the recipe index is invalid
     * @throws IllegalArgumentException 
     * 		If the quantity is negative
     */
    public void orderBread(int index, int breadQuantity) {
        if (index < 0 || index >= recipes.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (breadQuantity < 0) {
            throw new IllegalArgumentException("Bread quantity cannot be negative");
        }

        Recipe recipe = recipes.get(index);
        recipe.setBread(recipe.getBread() + breadQuantity);
    }

    /**
     * Generates a formatted shopping list based on all ordered breads.
     * 
     * @return A string representation of the total ingredients required
     */
    public String generateShoppingList() {
        String shoppingList = "";
        float totalEggs = 0, totalYeast = 0, totalFlour = 0, totalSugar = 0, totalButter = 0;

        for (Recipe recipe : recipes) {
            if (recipe.getBread() > 0) {
                shoppingList += recipe.getBread() + " " + recipe.getName() + " loaf/loaves.\n";

                totalYeast += recipe.getYeast() * recipe.getBread();
                totalFlour += recipe.getFlour() * recipe.getBread();
                totalSugar += recipe.getSugar() * recipe.getBread();
                totalEggs += recipe.getEggs() * recipe.getBread();
                totalButter += recipe.getButter() * recipe.getBread();
            }
        }

        shoppingList += "You will need a total of:\n";
        if (totalYeast > 0) {
            shoppingList += (int) totalYeast + " grams of yeast\n";
        }
        if (totalFlour > 0) {
            shoppingList += (int) totalFlour + " grams of flour\n";
        }
        if (totalSugar > 0) {
            shoppingList += (int) totalSugar + " grams of sugar\n";
        }
        if (totalEggs > 0) {
            shoppingList += (int) totalEggs + " egg(s)\n";
        }
        if (totalButter > 0) {
            shoppingList += (int) totalButter + " grams of butter\n";
        }

        return shoppingList;
    }

    /**
     * Saves the provided shopping list to a specified file.
     *
     * @param shoppingList 
     * 		The shopping list content to save
     * @param writeFile 
     * 		The file path to save the list to
     */
    public void saveShoppingList(String shoppingList, String writeFile) {
        try (FileWriter shoppingSaved = new FileWriter(writeFile)) {
            shoppingSaved.write(shoppingList);
        } catch (IOException e) {
            System.out.println("The file could not be saved: " + e.getMessage());
        }
    }
}
