package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class Staff extends User {
    //Attributes
    private String position;
    private double salary;
    
    //Constructor 0 - input parameter
    
    public Staff ()
    {
        //Call User()
        super();
        position = "TechSupport";
        salary = 3000;
        
    }
    // Constructor all 6 parameters 
    
    public Staff (String usernameIn, String passwordIn, String firstnameIn, 
            String lastnameIn, String positionIn, double salaryIn)
    {
        //Call User(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn)
        super(usernameIn, passwordIn, firstnameIn, lastnameIn);
        position = positionIn;
        salary = salaryIn;
    }
    
    //Getters
    
    public String getPosition()
    {
        return position;
    }
    public double getSalary()
    {
        return salary;
    }
    
    //Setters
    
    public void setPosition (String positionIn)
    {
        position = positionIn;
    }
    public void setSalary (double salaryIn)
    {
        salary = salaryIn;
    }
             
}
