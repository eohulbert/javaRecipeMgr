/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.box;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author rhyshulbert
 */
//This is the MAIN class
public class main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a Recipe Box
        recipeBox myRecipeBox = new recipeBox();
        
        //Sets boolean for loop
        Boolean loop = true;
        Scanner menuScnr = new Scanner(System.in);
        
        //Print a menu for the user to select an option
        do {
            //Menu options for user to select
            System.out.print("Menu\n" + "1. Add Recipe\n"
                             + "2. Print All Recipe Details\n"
                             + "3. Print All Recipe Names\n"
                             + "4. Edit Recipe\n"
                             + "5. Delete Recipe\n"
                             + "0. Quit\n"
                             + "\nPlease select a menu item: ");
            int input = menuScnr.nextInt();
            
            switch (input) {
                case 1:
                    //Add new recipe to recipeBox
                    myRecipeBox.addNewRecipe();
                    break;
                case 2:
                    //Prints all recipe names for user to choose from
                    myRecipeBox.printAllRecipeNames();
                    
                    //Promt user for AllRecipeDetails to print
                    System.out.print("Which recipe name? ");
                    String selectedRecipeName = menuScnr.next();
                    
                    //Prints all details of chosen recipe
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    break;
                case 3:
                    //Prints out all recipe names
                    myRecipeBox.printAllRecipeNames();
                    break;
                case 4:
                    //Prints out all recipe names
                    myRecipeBox.printAllRecipeNames();
                    
                    //Runs method to select what options to edit, then sets
                    myRecipeBox.updateRecipe();
                    break;
                case 5:
                    //Calls method to ask user what recipe to delete, deletes
                    myRecipeBox.deleteRecipe();
                    break;
                case 0:
                    //Sets loop false and ends program
                    loop = false;
                    System.out.println("Bye!");
                    break;
                default:
                    //For when integer input does not match cases
                    System.out.println("Try again...");
                    break;
            }
        } while (loop); //Loops while boolean is true
    }
}
