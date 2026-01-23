package models;


import models.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class SolarPanel extends Product {
    
    // SolarPanel class inherits all product attributes from Product,
    // adds one unique attribute wattageOutput how much power the panel produces

    //Attributes
    private int wattageOutput;
    
    // Constructor 0 - input parameter
    
    public SolarPanel ()
    {
        //Call Product()
        super();
        wattageOutput =400;
        
    }    
    
    // Constructor 4 - input parameters, except productId
    
    public SolarPanel(String productNameIn, double priceIn, int stockLevelIn, int wattageOutputIn)
    {
        //Call Product(String productNameIn, double priceIn, int stockLevelIn)
        super (productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
        
    }   
    
    // Constructor all 5 parameters
    
    public SolarPanel(int productIdIn, String productNameIn, double priceIn, 
            int stockLevelIn, int wattageOutputIn)
    {
        //Call Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
        
    }    
    
    //Getters
    
        public int getWattageOutput()
    {
        return wattageOutput;
    }
  
    
    //Setters
    
    public void setWattageOutputIn (int wattageOutputIn)
    {
        wattageOutput = wattageOutputIn;
    }    
    
}
