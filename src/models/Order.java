package models;


import java.util.Date;
import java.util.HashMap;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class Order {
    //Attributes
    private int orderId;  
    private Date orderDate;
    private double orderTotal;
    private String status;
    //HashMap
    private HashMap<Integer, OrderLine> orderLines;  
    
    
    
    // stage 7
    
    public void addOrderLine(OrderLine ol)
    {
        int orderLineId=0;
        
        while(orderLines.containsKey(orderLineId))
        {
            orderLineId++; //assigns to OrderLineId
        }
        ol.setOrderLineId(orderLineId);
        //create set OrderLineId() in OrderLine
        orderLines.put(orderLineId, ol);
    }
    
    //Getters for orderLines
    public HashMap<Integer, OrderLine> getOrderLines()
    {
        return orderLines;
    }
    
    //Getters for other attributes
    public int getOrderId()
    {
        return orderId;
    }
    public Date getOrderDate()
    {
        return orderDate;
    }
    public double getOrderTotal()
    {
        return orderTotal;
    }
    public String getStatus()
    {
        return status;
    }
    //Setters for all attributes
    
    public void setOrderId(int orderIdIn)
    {
        orderId = orderIdIn;
    }
    public void setOrderDate(Date orderDateIn)
    {
        orderDate = orderDateIn;
    }
    public void setOrderTotal(double orderTotalIn)
    {
        orderTotal = orderTotalIn;
    }
    public void setStatus (String statusIn)
    {
        status = statusIn;
    }
     
    public void setOrderLines(HashMap<Integer, OrderLine> orderLinesIn)
    {
        orderLines = orderLinesIn;
    }  
    
    
     
    //Constructor 0 input parameters
    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "Outgoing";
        orderLines = new HashMap();
    }
    // Constructor 4 input parameters except OrderLines   
    public Order(int orderIdIn, Date orderDateIn, 
            double orderTotalIn, String statusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap();        
    }
    
}
