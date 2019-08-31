/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.box;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rhyshulbert
 */
public class recipeBox {
    
    private ArrayList<recipe> listOfRecipes = new ArrayList<>();
    
    public recipeBox() {
        this.listOfRecipes = new ArrayList();
    }
    
    /**
     * @param recipes
     */
    public void recipeBox(ArrayList<recipe> recipes) {
        this.listOfRecipes = listOfRecipes;
    }
    
    /**
     * @return the recipes
     */
    public ArrayList<recipe> getListOfRecipes() {
        return listOfRecipes;
    }
    
    /**
     * @param recipes the recipes to set
     */
    public void setListOfRecipes(ArrayList recipes) {
        this.listOfRecipes = listOfRecipes;
    }
    
    /**
     * @param selectedRecipeName
     * @return the recipeDetails
     */
    public String printAllRecipeDetails(String selectedRecipeName) {
        
        //Accesses listOfRecipes in collection
        for (recipe LOR : listOfRecipes) {
            //Matches user input recipe
            if (LOR.getRecipeName().equalsIgnoreCase(selectedRecipeName)) {
                //Prints details of current recipe
                LOR.printRecipe();
                break;
            }
        }
        
        return selectedRecipeName;
    }
    
    public void printAllRecipeNames() {
        
        int i = 1;
        
        //Gets recipes from array list
        for (recipe LOR : listOfRecipes) {
            //Prints variable increment with recipe names in collection
            System.out.println((i++) + ": "
                               + LOR.getRecipeName());
            
        }
        
    }
    
    public void addNewRecipe() {
        
        //Instantiates new recipe class
        recipe nextRecipe = new recipe();
        
        //Accesses recipe class method to create new recipe
        nextRecipe.createNewRecipe("tempRecipeName");
        
        //Add new recipe to recipeBox array list
        listOfRecipes.add(nextRecipe);
        
    }
    
    public void updateRecipe() {
        //Instantiates new scanner class
        Scanner scnr = new Scanner(System.in);
        
        //Prompt user for recipe to edit
        System.out.print("Which recipe? ");
        String recipeName = scnr.next();
        
        //Prompt user for what recipe part to edit
        System.out.print("What do you want to edit?\n"
                         + "1. Name\n"
                         + "2. Servings\n"
                         + "3. Ingredients\n"
                         + "4. Add Ingredient\n"
                         + "5. Delete Ingredient\n");
        int itemNum = scnr.nextInt();
        
        switch (itemNum) {
            case 1:
                //Prompt user for new recipe name to set
                System.out.println("What would you like the new name to be?");
                String newRecipeName = scnr.next();
                
                //Accesses listOfRecipes in collection
                for (recipe LOR : listOfRecipes) {
                    //Matches user input recipe
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        //Sets new user input recipe name to current recipe
                        LOR.setRecipeName(newRecipeName);
                        break;
                    }
                }
                break;
            case 2:
                //Prompt user for new serving amount
                System.out.print("What would you like the new serving to be? ");
                int newServing = scnr.nextInt();
                
                //Accesses listOfRecipes in collection
                for (recipe LOR : listOfRecipes) {
                    //Matches user input recipe
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        //Sets new serving amount in current recipe
                        LOR.setServings(newServing);
                        break;
                    }
                }
                break;
            case 3:
                
                //Variable for incrementing list for print
                int j = 1;
                
                //Accesses listOfRecipes in collection
                for (recipe LOR : listOfRecipes) {
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        for (ingredient LOI : LOR.getRecipeIngredients()) {
                            //Prints list of ingredient names to user
                            System.out.println((j++) + ": "
                                               + LOI.getNameOfIngredient());
                        }
                    }
                }
                
                //Prompt user for ingredient to edit
                System.out.print("Which ingredient do you want to edit? ");
                String editIngredient = scnr.next();
                
                //Sets new array of ingredients into current recipe in collection
                for (recipe LOR : listOfRecipes) {
                    //Matches user input recipe name in array
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        for (ingredient LOI : LOR.getRecipeIngredients()) {
                            if (LOI.getNameOfIngredient()
                                .equalsIgnoreCase(editIngredient)) {
                                
                                //Prompt user for ingredient part to edit
                                System.out.print("What do you want to edit?\n"
                                                 + "1. Ingredient Name\n"
                                                 + "2. Amount\n"
                                                 + "3. Measurement\n"
                                                 + "4. Calories\n"
                                                 + "5. Add Ingredient\n");
                                int editNum = scnr.nextInt();
                                
                                //Switch case for user input
                                switch (editNum) {
                                        //To set new ingredient name
                                    case 1:
                                        //Prompt user for new ingredient name
                                        System.out.print("What do you want the"
                                                         + " ingredient name to be? ");
                                        String newName = scnr.next();
                                        
                                        //Set new ingredient name
                                        LOI.setNameOfIngredient(newName);
                                        break;
                                        //To set new ingredient amount
                                    case 2:
                                        //Prompt user for new ingredient amount
                                        System.out.print("What do you want the"
                                                         + " ingredient amount to be? ");
                                        float newAmt = scnr.nextFloat();
                                        
                                        //Set new ingredient amount
                                        LOI.setNumMeasure(newAmt);
                                        break;
                                        //To set new ingredient measurement
                                    case 3:
                                        //Prompt user for new ingredient measurement
                                        System.out.print("What do you want the"
                                                         + " ingredient measurement to be? ");
                                        String newMeasure = scnr.next();
                                        
                                        //Set new ingredient measurement
                                        LOI.setMeasurement(newMeasure);
                                        break;
                                        //To set new ingredient calories
                                    case 4:
                                        //Prompt user for new ingredient calories
                                        System.out.print("What do you want the"
                                                         + " ingredient calories to be? ");
                                        int newCalories = scnr.nextInt();
                                        
                                        //Set new ingredient calories
                                        LOI.setNumCalsPerMeasure(newCalories);
                                        break;
                                    default:
                                        //For when integer input does not match cases
                                        System.out.println("Try again...");
                                        break;
                                }
                            }
                        }
                        
                        break;
                    }
                }
                break;
            case 4:
                
                //Accesses listOfRecipes in collection
                for (recipe LOR : listOfRecipes) {
                    //Matches user input recipe name in array
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        
                        //Add new ingredient to recipe ingredients list
                        LOR.addRecipeIngredient();
                    }
                }
                break;
            case 5:
                
                //Variable for incrementing list for print
                int i = 1;
                
                //Accesses listOfRecipes in collection
                for (recipe LOR : listOfRecipes) {
                    //Matches user input recipe name in array
                    if (LOR.getRecipeName().equalsIgnoreCase(recipeName)) {
                        for (ingredient LOI : LOR.getRecipeIngredients()) {
                            //Prints list of ingredient names to user
                            System.out.println((i++) + ": "
                                               + LOI.getNameOfIngredient());
                            
                        }
                        //Delete ingredient from recipe ingredient list
                        LOR.deleteRecipeIngredient();
                        break;
                    }
                }
                break;
            default:
                //For when integer input does not match cases
                System.out.println("Try again...");
                break;
        }
        
    }
    
    public void deleteRecipe() {
        //Initiates new scanner class
        Scanner menuScnr = new Scanner(System.in);
        
        //Accesses printAllRecipeNames method in recipeBox
        printAllRecipeNames();
        
        //Get recipe name to delete
        System.out.println("Which recipe number? ");
        int recipeNumber = menuScnr.nextInt();
        
        //Remove from arraylist minus 1 as list print numbering starts at 1
        listOfRecipes.remove(recipeNumber - 1);
    }
    
}

