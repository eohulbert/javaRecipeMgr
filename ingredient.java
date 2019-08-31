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
public class ingredient {
    
    private String nameOfIngredient;
    private float numMeasure;
    private String measurement;
    private int numCalsPerMeasure;
    private double totalCalories;
    
    public ingredient() {
        
        this.nameOfIngredient = "";
        this.numMeasure = 0;
        this.measurement = "";
        this.numCalsPerMeasure = 0;
        this.totalCalories = 0;
    }
    /**
     * @return the nameOfIngredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }
    
    /**
     * @param nameOfIngredient the nameOfIngredient to set
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }
    
    /**
     * @return the numMeasure
     */
    public float getNumMeasure() {
        return numMeasure;
    }
    
    /**
     * @param numMeasure the numberCups to set
     */
    public void setNumMeasure(float numMeasure) {
        this.numMeasure = numMeasure;
    }
    
    /**
     * @return the measurement
     */
    public String getMeasurement() {
        return measurement;
    }
    
    /**
     * @param measurement the measurement to set
     */
    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
    
    /**
     * @return the numberCaloriesPerCup
     */
    public int getNumCalsPerMeasure() {
        return numCalsPerMeasure;
    }
    
    /**
     * @param numCalsPerMeasure the numbCalsPerMeasure to set
     */
    public void setNumCalsPerMeasure(int numCalsPerMeasure) {
        this.numCalsPerMeasure = numCalsPerMeasure;
    }
    
    /**
     * @return the totalCalories
     */
    public double getTotalCalories() {
        return totalCalories;
    }
    
    /**
     * @param totalCalories the totalCalories to set
     */
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
    
    public ingredient(String nameOfIngredient, float numMeasure, String measurement,
                      int numCalsPerMeasure, double totalCalories) {
        
        this.nameOfIngredient = nameOfIngredient;
        this.numMeasure = numMeasure;
        this.measurement = measurement;
        this.numCalsPerMeasure = numCalsPerMeasure;
        this.totalCalories = totalCalories;
    }
    
    public ingredient addIngredient(String tempNameOfIngredient) {
        
        Scanner ingScnr = new Scanner(System.in);
        String userReply = "";
        boolean loop = true;
        
        //Get Ingredient name
        System.out.print("Please enter the name of the ingredient: ");
        //Does not validate if integer or character
        nameOfIngredient = ingScnr.nextLine();
        
        //Get measurement type
        System.out.print("Please enter the measurement type: ");
        //Does not validate if integer or character
        measurement = ingScnr.nextLine().toLowerCase();
        
        //Get number of ingredient measurement
        System.out.print("Please enter the number of " + measurement
                         + "(s) of " + nameOfIngredient + " we'll need: ");
        numMeasure = ingScnr.nextFloat();
        
        //Get calories per ingredient measurement
        System.out.print("Please enter the number of calories per "
                         + measurement + ": ");
        numCalsPerMeasure = ingScnr.nextInt();
        
        //Calculate total calories of ingredient measurement
        totalCalories = (double)numMeasure * (double)numCalsPerMeasure;
        
        //Instantiates ingredient object for return
        ingredient tempIngredients = new ingredient(nameOfIngredient,
                                                    numMeasure, measurement, numCalsPerMeasure,
                                                    totalCalories);
        return tempIngredients;
    }
    
    //Converts object variables to string format for printing
    @Override
    public String toString() {
        return (nameOfIngredient + " " + numMeasure + " " + measurement
                + "(s) " + numCalsPerMeasure + " calories per " + measurement + " "
                + totalCalories + " total calories ");
    }
}
