/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

/**
 * Class That Contains The PlayGame Methods
 * Stores the Team 1 and Team 2 Objects
 * Stores the Team 1 and 2 Scores
 * @author Hamish
 */
public class PlayGame {

    // Initializes Variables/Objects
    private Club t1; // Sets New Club Object as t1
    private Club t2; // Sets New Club Object as t2
    private int t1Score; // Sets Int as T1 Score
    private int t2Score; // Sets Int as T2 Score

    // Getters
    public Club getTeam1() {
        return t1;
    }

    public Club getTeam2() {
        return t2;
    }

    public int getTeam1Score() {
        return t1Score;
    }

    public int getTeam2Score() {
        return t2Score;
    }

    // Setters
    public void setTeam1(Club t1) {
        this.t1 = t1;
    }

    public void setTeam2(Club t2) {
        this.t2 = t2;
    }

    public void setTeam1Score(int t1Score) {
        this.t1Score = t1Score;
    }

    public void setTeam2Score(int t2Score) {
        this.t2Score = t2Score;
    }

    // Returns Teams and Scores
    @Override
    public String toString() {
        return "| Team: " + t1.getName() + " Score:  " + t1Score + "| " + "| Team: " + t2.getName() + " Score: " + t2Score + " |";
    }
}
