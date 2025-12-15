package models;


import java.util.HashMap;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class Customer extends User{
    //Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;// check if it is 'orders' instead orderLines
    private LinkedList<Integer>cardNumbers;
    
    public LinkedList<Integer>getCardNumbers()
    {
        return cardNumbers;
    }
    public void setCardNumbers(LinkedList<Integer> cardNumbersIn)
    {
        cardNumbers = cardNumbersIn;
    }
    
    public void addNewCard(Integer newCard)
    {
        cardNumbers.add(newCard);
    }  
    
    public void removeCard(Integer nodeNo)
    {
        cardNumbers.remove(nodeNo);
    } 
    
    public void addFirstCard(Integer newCard)
    {
        cardNumbers.addFirst(newCard);
    }           
    
    
    //Constructor 0 input parameter
    public Customer ()
    {
        //call User()
        super();
       
       addressLine1 = "QueenStreet";
       addressLine2 = "Flat1";
       town = "Edinburgh";
       postcode = "EH99JJ";
       isRegistered = true;
       orders = new HashMap();
       cardNumbers = new LinkedList();
       
    }
    //Constructor 8 parameters, (except isRegistered)
    public Customer(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn,
            String addressLine1In, String addressLine2In,String townIn,String postcodeIn)
    {
        //Call User(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn)
        super(usernameIn,passwordIn,firstnameIn,lastnameIn);
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
        isRegistered = false;
        orders = new HashMap();
        cardNumbers = new LinkedList();
        
    }
    //Getters
    public String getAddressLine1()
    {
        return addressLine1;
    }
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public String getTown()
    {
        return town;
    }
       public String getPostcode()
    {
        return postcode;
    } 
           public Boolean getIsRegistered()
    {
        return isRegistered;
    }

    public HashMap <Integer, Order> getOrders() {
        return orders;                            // 'orders' ??
    }

        
    //Setters
    public void setAddressLine1(String addressLine1In)
    {
        addressLine1 = addressLine1In;
    }
    public void setAddressLine2(String addressLine2In)
    {
        addressLine2 = addressLine2In;
    }
    public void setTown(String townIn)
    {
        town = townIn;
    }
    public void setPostcode(String postcodeIn)
    {
        postcode = postcodeIn;
    }
    public void setIsRegistered(Boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }    

    public void setOrders(HashMap<Integer, Order> ordersIn) {
        orders = ordersIn;
    }
   
    
}
