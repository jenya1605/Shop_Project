
package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * OrderLine is the object that stores all attributes (orderLineId, Product, quantity, lineTotal)
 * and represents a single line in the order
 * @author 30471297
 */
public class OrderLine {
    //Attributes
    private int orderLineId;  // Unique identifier for this specific order line
    private Product product;
    private int quantity;
    private double lineTotal;
    
        // Getters and Setters
    //Getter
    public Product getProduct()
    {
        return product;
    }
    
    public int getOrderLineId()
    {
        return orderLineId;
    }  
    
    public double getLineTotal()
    {
        return lineTotal;
    }   
    
    public int getQuantity()
    {
        return quantity;
    }    
    
    //Setters
    public void setProduct(Product productIn)
    {
        product = productIn;
    }  
    
    public void setOrderLineId(int orderLineIdIn)
    {
        orderLineId = orderLineIdIn;
    }  
    
    public void setQuantity(int quantityIn)
    {
        quantity = quantityIn;
    }  
     
    
    //Constructor All 4 parameters
    
    public OrderLine(int orderLineIdIn, Product productIn,
            int quantityIn, double lineTotalIn)
    {
        orderLineId = orderLineIdIn;
        product = productIn;
        quantity = quantityIn;
        lineTotal = lineTotalIn;
    }  
    
    //Constructor 3 input parameters
    public OrderLine(int orderLineIdIn, Product productIn, int quantityIn)
    {
        orderLineId = orderLineIdIn;
        product = productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice()*quantity;
        
    }
      
    //Constructor 2 input parameters product and quantity
    public OrderLine(Product productIn, int quantityIn)
    {
        orderLineId = 0;
        product = productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice()*quantity;    
    }
    
    
}
