package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class Product {
    
    //Attributes
    
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    @Override
    //stage 6
    public String toString()
    {
      String productOutput = productName + " is " + price;       
      return productOutput;
    }
    
    // Constructor
    // 0 input parameters
    public Product()
    {
        productId = 001;
        productName = "Energy";
        price = 100.00;
        stockLevel = 1;
    }
    
    //Constructor
    //3 input parameters
    
    public Product(String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = 001; //this variable is temporary and will be rewritten by the database
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
        
    }
    
    // Constructor 4 input parameters
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }

    //Getter methods for all attributes
    public int getProductId() 
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int stockLevel()
    {
        return stockLevel;
    }
    //Setter methods for all attributes

    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setStockLevel(int stockLevel)
    {
        this.stockLevel = stockLevel;
    }
    
    public boolean getIsAvailable() {
    
       throw new UnsupportedOperationException("Not supported yet"); 
    //GeneratedMethodBody;
    }    
            
    
    
}

