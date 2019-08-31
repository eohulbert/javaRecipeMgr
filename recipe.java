/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.box;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rhyshulbert
 */
public class recipe {
    
    private String recipeName;
    private int servings;
    private ArrayList<ingredient> recipeIngredients;
    private double totalRecipeCalories;
    private int singleServingCalories;
    
    public recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
    }
    
    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }
    
    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }
    
    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }
    
    /**
     * @return the recipeIngredients
     */
    public ArrayList<ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }
    
    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
    
    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    //Separate calories calculator for updating recipes in collection
    public void totalCalsCalculator() {
        //Set to zero to refresh total calorie count
        this.totalRecipeCalories = 0;
        //Loops through array list to get measurement * calories for each ingredient
        for (int i = 0; i < recipeIngredients.size(); i++) {
            ingredient currentIngredient = recipeIngredients.get(i);
            float ingredientAmount = currentIngredient.getNumMeasure();
            int ingredientCalories = currentIngredient.getNumCalsPerMeasure();
            double ingredientTotalCalories = (double)ingredientAmount * (double)ingredientCalories;
            totalRecipeCalories += ingredientTotalCalories;
        }
    }
    
    public recipe(String recipeName, int servings,
                  ArrayList<ingredient> recipeIngredients,
                  double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    public void printRecipe() {
        //Sets single serving amount
        double singleServingCalories = totalRecipeCalories / servings;
        
        //Prints out recipe name and servings
        System.out.println("Recipe: " + recipeName);
        System.out.println("Yields: " + servings + " servings");
        System.out.println("Ingredients:");
        
        //Gets recipes from array list
        for (int j = 0; j < recipeIngredients.size(); j++) {
            //Prints out ingredients
            System.out.println(recipeIngredients.get(j));
        }
        
        //Prints out single serving calories
        System.out.println("Each serving has: " + singleServingCalories
                           + " calories");
    }
    
    //Adds new ingredients to recipes in collection
    public void addRecipeIngredient() {
        //Instantiates ingredient object
        ingredient myIngredient = new ingredient();
        
        //Accesses add ingredient method
        myIngredient.addIngredient("test");
        
        //Adds return value from addIngredient() to array list
        recipeIngredients.add(myIngredient);
        
        //Loops each ingredient, calculates and adds to total recipe calories
        totalCalsCalculator();
    }
    
    //Adds new ingredients to recipes in collection
    public void deleteRecipeIngredient() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Which ingredient do you want to delete? ");
        int deleteIngredient = scnr.nextInt();
        //Removes ingredient from array
        recipeIngredients.remove(deleteIngredient);
        
        //Loops each ingredient, calculates and adds to total recipe calories
        totalCalsCalculator();
    }
    
    public recipe createNewRecipe(String tempName) {
        tempName = recipeName;
        boolean addMore = true;
        Scanner scnr = new Scanner(System.in);
        String reply;
        
        //Gets recipeName from user
        System.out.print("Please enter the recipe name: ");
        recipeName = scnr.nextLine();
        
        //Gets servings amount from user
        System.out.print("Please enter the number of servings: ");
        servings = scnr.nextInt();
        
        //Loop to add ingredients until no more needed
        do {
            
            //Prompt user if they want to add more ingredients
            System.out.print("Do you need to add ingredients? (y or n) ");
            reply = scnr.next();
            
            //If user wants to add ingredients
            if (reply.toLowerCase().equals("y")) {
                
                //Instantiates ingredient object
                ingredient myIngredient = new ingredient();
                
                //Accesses add ingredient method
                myIngredient.addIngredient("test");
                
                //Adds return value from addIngredient() to array list
                recipeIngredients.add(myIngredient);
                
                //All other options
            } else {
                
                //Sets boolean to false
                addMore = false;
            }
            
            //While boolean is true
        } while (addMore);
        
        //Loops each ingredient, calculates and adds to total recipe calories
        for (int i = 0; i < recipeIngredients.size(); i++) {
            ingredient currentIngredient = recipeIngredients.get(i);
            float ingredientAmount = currentIngredient.getNumMeasure();
            int ingredientCalories = currentIngredient.getNumCalsPerMeasure();
            double ingredientTotalCalories = (double)ingredientAmount * (double)ingredientCalories;
            totalRecipeCalories += ingredientTotalCalories;
        }
        
        //Instantiates recipe object for return
        recipe newRecipe
        = new recipe(recipeName, servings, recipeIngredients,
                     totalRecipeCalories);
        return newRecipe;
    }
}

