/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

/**
 *This Class Handles The Constructor For The Clubs
 * Handles Methods Club Name, Club, Club Player Number
 * Returns ToString with Team Name, Location, Number of Players
 * 
 * @author Hamish Maritz, 1383425
 */

public class Club {
    
    //Initialize Variables
    String club; // Club Name
    String name; // Club Location
    String playerNumber; // Club Player Numbers
    
    // Club Constructor
    public Club(String club, String name, String playerNumber){
    this.club = club;
    this.name = name;
    this.playerNumber = playerNumber;
}
    // Setters
    public void setClub(String club){
        this.club = club;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNumber(String playerNumber){
        this.playerNumber = playerNumber;
    }
    
    // Getters
    public String getClub(){
        return club;
    }
    
    public String getName(){
        return name;
    }
    
    public String getNumber()
    {
        return playerNumber;
    }
    
    // Return String
    @Override
    public String toString(){
        
        return "Team Name: " +club +" | Location: "+ name + " | Number Of Players: " + playerNumber;
    
}
}
