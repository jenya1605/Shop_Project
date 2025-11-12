package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30471297
 */
public class User {
   
    //Attributes
    
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    
    //Constructor 
    //User 0 input parameters
    public User()
    {
        username = "user1";
        password = "111";
        firstname = "Name";
        lastname = "Secondname";
    }
    
    //Constructor. All 4 input parameters
     public User(String usernameIn, String passwordIn, String firstnameIn, String lastnameIn)
     {
         username = usernameIn;
         password = passwordIn;
         firstname = firstnameIn;
         lastname = lastnameIn;
     }
     
     // Getter methods for all attributes

    public String getUsername()
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname() 
    {
        return lastname;
    }
    
    //Setter methods for all attributes

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

     
     
    
}
