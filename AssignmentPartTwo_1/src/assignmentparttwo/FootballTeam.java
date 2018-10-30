/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

/**
 * This Class Extends The Club Class
 * This Class Handles the FootballTeams
 * Win, Loss, Match Points
 * @author Hamish
 */
public class FootballTeam extends Club {

    // Initializes Variables
    private int winCount;
    private int lossCount;
    private int matchPoints;
    
    // Default Constructor
    public FootballTeam(String club, String name, String playerNumber) {
        super(club, name, playerNumber);
    }

    // Getters And Setters
    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public void setMatchPoints(int matchPoints) {
        this.matchPoints = matchPoints;
    }

}
