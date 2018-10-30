/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import javax.swing.JFrame;

/**
 * This Main Class Controls The Program Opening
 * Controls The Database Opening 
 * @author Hamish Maritz, 1383425
 */
public class Main {
    public static void main(String[] args) {
        Database db = new Database(); // New Database Object
        db.autoConnectFootBallDB(); // Connect to DB
        db.createClubsTable(); // Create Club Table
        db.createPlayGameTable(); // Create Game Table
        db.createPlayersTable(); // Create Players Table
        db.readTableData(); // Read Table Data
        JFrame frame = new Controller("Football Manager"); // Create new JFrame
        frame.setVisible(true); // Set Visible
    }
}
