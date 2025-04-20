package assn3;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 * 
 * Description: Allows users to view recipes, create shopping lists for those recipes
 * and save them to a file.
 */

public class RecipeManagerTest {
	
	private static RecipeManager recipemanager;
	private static Scanner input;
	private static final String RECIPE_FILE = "recipelist.txt";
	private static final String SHOPPING_LIST_FILE = "shoppinglist.txt";
	
    public static void main(String[] args) {
        recipemanager = new RecipeManager();
        input = new Scanner(System.in);
        String name;

        System.out.println("Please enter your name: ");
        name = input.nextLine();

        System.out.println("Welcome to " + name + "'s recipe manager.");

        try {
            recipemanager.loadRecipes(RECIPE_FILE);
        } catch (IOException e) {
            System.out.println(RECIPE_FILE + " failed to load");
            System.exit(1);
        }

        menu();
    }

    /**
     * Displays the main menu and handles user selection in a loop.
     */
    public static void menu() {
        int selection = 0;
        input = new Scanner(System.in);
        menuOptions();

        do {
            try {
                selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                    case 1:
                        showRecipes();
                        break;
                    case 2:
                        createList();
                        break;
                    case 3:
                        printList();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    case 0:
                        menu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (0-4): ");
            }
        } while (selection != 4);

        input.close();
    }

    /**
     * Displays a list of available recipes to the user.
     */
    private static void showRecipes() {
        System.out.println("Available Recipes: ");
        for (int i = 0; i < recipemanager.getRecipeCount(); i++) {
            Recipe recipe = recipemanager.getRecipe(i);
            System.out.println((i + 1) + ". " + recipe.getName());
        }
        System.out.println();
        menu();
    }

    /**
     * Allows the user to select a recipe and specify the quantity
     * of bread to generate a shopping list entry.
     */
    private static void createList() {
        int recipeIndex;
        int breadQuantity;
        System.out.println("Which recipe would you like? ");
        try {
            recipeIndex = Integer.parseInt(input.nextLine()) - 1;

            // Trigger IndexOutOfBoundsException if invalid
            recipemanager.getRecipe(recipeIndex);

            System.out.println("How much of this bread would you like: ");
            breadQuantity = Integer.parseInt(input.nextLine());

            recipemanager.orderBread(recipeIndex, breadQuantity);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("That recipe does not exist. Please choose a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid quantity. " + e.getMessage());
        }

        System.out.println();
        menu();
    }

    /**
     * Displays the shopping list and optionally saves it to a file.
     */
    private static void printList() {
        String shoppingList = recipemanager.generateShoppingList();
        System.out.println(shoppingList);
        System.out.println("\n--- Shopping List ---");
        System.out.println("Do you want to save this list (Y/N)? ");
        String response = input.nextLine().trim();

        if (response.equalsIgnoreCase("Y")) {
            recipemanager.saveShoppingList(shoppingList, SHOPPING_LIST_FILE);
        }

        System.out.println();
        menu();
    }

    /**
     * Prints the available options in the main menu.
     */
    public static void menuOptions() {
        System.out.println("1. Show available recipes.");
        System.out.println("2. Create Shopping List.");
        System.out.println("3. Print Shopping List.");
        System.out.println("4. Quit Program.");
        System.out.println("0. Reprint this menu.");
        System.out.println("Please enter your choice: ");
    }
}
