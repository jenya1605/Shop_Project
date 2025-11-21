package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class DBManager {
private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://Data\\ShopDB.accdb";
    
    
    //Method Write Order to Database - Stage 8
    
//public void writeOrder(Order o)
public void writeOrder(Order o, String customerUsername)
    {
     try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
        stmt.executeUpdate("INSERT INTO Orders (OrderDate,Username,OrderTotal,Status)" +
                    " Values ("
                    + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()) + "',"  // create in order class
                    + "'" + customerUsername + "',"           
                    + "'" + o.getOrderTotal() + "'," // create in order class
                    + "'" + o.getStatus() + "'"     // create in order class
                    + ")");        
        
        }
        catch(Exception ex)
        {
            System.out.println("Error writing Order: " + ex.getMessage());
        }
    }    
    
    
    public ArrayList<Customer> loadCustomers()
    {
        ArrayList<Customer>allCustomers = new ArrayList();
        try
        {
          Class.forName(driver); 
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT*FROM Customers");
          
          while(rs.next())
          {
              String username = rs.getString("Username");
              String password = rs.getString("Password");
              String firstName = rs.getString("FirstName");
              String lastName  = rs.getString("LastName");
              String addressLine1 = rs.getString("AddressLine1");
              String addressLine2 = rs.getString("AddressLine2");
              String town = rs.getString("Town");
              String postcode = rs.getString("Postcode"); 
              
              // Customer(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn,
            //String addressLine1In, String addressLine2In,String townIn,String postcodeIn)
              Customer c = new Customer(username, password, 
                      firstName,lastName , addressLine1, addressLine2, town, postcode);
                  allCustomers.add(c);
          }
        }
        catch(Exception ex)
        {
            System.out.println("Error loading Staff:"+ex.getMessage());
        }
        finally
        {
            return allCustomers;
        }
    }
            
    public ArrayList<Staff> loadStaff()
    {
        ArrayList<Staff>allStaff = new ArrayList();
        try
        {
          Class.forName(driver); 
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT*From Staff");
          
          while(rs.next())
          {
              String username = rs.getString("Username");
              String password = rs.getString("Password");
              String firstName = rs.getString("FirstName");
              String lastName  = rs.getString("LastName");
              String position = rs.getString("Position");
              double salary = rs.getDouble("Salary");
              
              // Staff(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn,
            //String positionIn, String salaryIn)
              Staff s = new Staff(username, password, 
                      firstName,lastName , position, salary);
                  allStaff.add(s);
          }
        }
        catch(Exception ex)
        {
            System.out.println("Error loading Staff:"+ex.getMessage());
        }
        finally
        {
            return allStaff;
        }
    }  
    public Customer customerLogin(String username, String password)
    {
        ArrayList<Customer> allCustomers = loadCustomers();
 
        
        
        for(Customer c: allCustomers)
            
        {
            if(c.getUsername().equals(username)&&c.getPassword().equals(password))
            {
                return c;
            }
        }
        return null; // if username and password are not in any 'c'
    }
     public Staff staffLogin(String username, String password)
     {
         ArrayList<Staff> allStaff = loadStaff();
         for(Staff s:allStaff)
         {
             if(s.getUsername().equals(username)&&s.getPassword().equals(password))
             {
                return s; 
             }
         }
         return null; // if username and password are not in any 's'
     }
     
     public ArrayList<Product> loadProducts(){
     ArrayList<Product> allProducts = new ArrayList();
    
    try
    {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(connectionString);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
        while(rs.next())
        {
            int productID = rs.getInt("ProductID");
            String productName = rs.getString("ProductName");
            double price = rs.getDouble("Price");
            int stockLevel = rs.getInt("StockLevel");
            String productType = rs.getString("ProductType");
            int wattageOutput = rs.getInt("WattageOutput");
            double efficiencyRating = rs.getDouble("EfficiencyRating");

            //String1.equals(String2) compare 2 strings
            if(productType.equals("Heat Pump"))
            {
          //        Heatpump(int productIDIn, productNameIn, priceIn, stockLevelIn, productTypeIn, efficiencyRatingIn)
                HeatPump h = new HeatPump(productID, productName, price, stockLevel, efficiencyRating);
                allProducts.add(h);
            }
            else if(productType.equals("Solar Panel"))
            {
             // SolarPanel(int productIDIn, productNameIn, priceIn, stockLevelIn, productTypeIn, wattageOutputIn)
                SolarPanel s = new SolarPanel(productID, productName, price, stockLevel, wattageOutput);
                allProducts.add(s);
            }
            
            }
    }
    catch(Exception ex)
    {
    System.out.println("Error loading products" +ex.getMessage());
    
    }

    finally
        {
            return allProducts;
        }
        
}
}
             
    



    
    

