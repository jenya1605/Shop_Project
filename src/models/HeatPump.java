package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class HeatPump extends Product{
    
    //Attributes
    private double efficiencyRating;
    
    //Constructor 0 - input parameter
    
    public HeatPump ()
    {
        //Call Product()
        super();
        efficiencyRating = 90;
        
    }
    
    //Constructor 4 parameters, excepr productId
    
    public HeatPump(String productNameIn, double priceIn, int stockLevelIn, double efficiencyRatingIn)
    {
        //Call Product(String productNameIn, double priceIn, int stockLevelIn)
        super (productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
        
    }
    
        //Constructor all 5 parameters
    
    public HeatPump(int productIdIn, String productNameIn, double priceIn, 
            int stockLevelIn, double efficiencyRatingIn)
    {
        //Call Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
        
    }
    
    //Getters
    
        public double getEfficiencyRating()
    {
        return efficiencyRating;
    }
  
    
    //Setters
    
    public void setEfficiencyRating (double efficiencyRatingIn)
    {
        efficiencyRating = efficiencyRatingIn;
    }
       
    
}
