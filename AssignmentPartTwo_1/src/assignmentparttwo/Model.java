/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ListModel;

/**
 * This Class Handles The ArrayLists
 * Adding Club, Removing Club
 * Adding Player, Removing Player
 * Getting Club List, PlayerList
 * @author Hamish Maritz, 1383425
 */
public class Model {

    ArrayList<Player> player = new ArrayList<>(); // New ArrayList for Players
    ArrayList<FootballTeam> club = new ArrayList<>(); // New ArrayList for Clubs
    String[] str = {}; // New String Array
    // Constructor for Arrays
    public Model() {
        this.club = new ArrayList<FootballTeam>();
        this.player = new ArrayList<Player>();

    }

    /**
     * Method That Adds A Club to the Club Array
     * @param name
     * @param location
     * @param playerCount 
     */
    public void addClub(String name, String location, String playerCount) {

        club.add(new FootballTeam(name, location, playerCount));
    }

    /**
     * Method That Removes A Club from Club Array
     * @param index 
     */
    public void removeClub(int index) {
        this.club.remove(index);
    }
    /**
     * Method That Adds A Player To The Player Array
     * @param name
     * @param club
     * @param playerNumber 
     */
    public void addPlayer(String name, String club, String playerNumber) {
   
        player.add(new Player(name, club, playerNumber));
    }

    /**
     * Method That Removes A Player From The Player Array
     * @param index 
     */
    public void removePlayer(int index) {
        this.player.remove(index);
    }

    /**
     * Method That Gets The Player List
     * @return 
     */
    public Player[] getPlayerList() {
        Player[] array = new Player[this.player.size()];
        // Gets Length Of Player ArrayList
        for (int i = 0; i < array.length; i++) {
            array[i] = this.player.get(i); 
        }
        return array; // Returns Player List
    }

    /**
     * Method That Checks If Player Exists
     * @param text
     * @return 
     */
    public boolean hasPlayer(Player text) {
        return this.player.contains(text);
    }

    /**
     * Method That Gets The Club List
     * @return 
     */
    public Club[] getClubList() {
        Club[] array = new Club[this.club.size()];
        // Gets Length Of Club ArrayList
        for (int i = 0; i < array.length; i++) {
            array[i] = this.club.get(i);
        }
        return array; // Returns Club List
    }

    /**
     * Method That Checks If Club Exists
     * @param text
     * @return 
     */
    public boolean hasClub(FootballTeam text) {
        return this.club.contains(text);

    }


}
