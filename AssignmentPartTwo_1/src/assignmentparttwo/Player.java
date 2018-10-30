/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

/**
 * Class that Contains Player Details
 * Stores the Player Name, Club, Player Number
 * 
 * @author Hamish
 */
public class Player {
    // Initializes Variables
    String pName;
    String pClub;
    String pNumber;

    // Default Constructor
    public Player(String pName, String pClub, String pNumber) {

        this.pName = pName;
        this.pClub = pClub;
        this.pNumber = pNumber;
    }
    // Getters and Setters
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpClub() {
        return pClub;
    }

    public void setpClub(String pClub) {
        this.pClub = pClub;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }
    // Returns Player Name, Club and Position
    @Override
    public String toString() {

        return "Player Name: " + pName + " | Club: " + pClub + " | Position: " + pNumber;

    }
}
