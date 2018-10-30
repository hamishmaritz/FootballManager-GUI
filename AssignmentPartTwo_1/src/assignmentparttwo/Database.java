/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *This Class handles the Database Components
 * Implements Creating Of Tables and Updating Results
 * 
 * @author Hamish
 */
public class Database {
    // Initializes Variables and Objects
    Connection conn = null; // New Connection
    String url = "jdbc:derby://localhost:1527/FootballDB;create=true"; // URL Of DB
    String username = " ";  //No DB Username
    String password = " ";   // No DB Password
    Statement statement; // New Statement Object
    ResultSet rs; // New ResultSet Object
    Model mb = new Model(); // New Model Object
    View view = new View(this.mb); // New View OBject

    /**
     * This Method Connects To The Database
     * If No Connection Successful Prints Out Error
     * @return 
     */
    public Connection autoConnectFootBallDB() {
        try { 
            conn = DriverManager.getConnection(url); // Gets The Connection Of the URL
        } catch (SQLException e) {
            // Error Checking
            System.out.println("Error, Not Working");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);

        }
        return conn; // Return the Connection
    }

    /**
     * This Method Creates a new Clubs Table If None Exist
     * If Exists Then Skips and Prints out It Exists
     */
    public void createClubsTable() {
        
        try {
            statement = conn.createStatement(); // New Statement
            String newTableName = "CLUBS"; 
            // SQL Statement for Creating Table
            String sqlCreate = "create table " + newTableName + " (NAME VARCHAR(20),"
                    + "LOCATION varchar(20), PLAYERS varchar(20))";
            statement.executeUpdate(sqlCreate); // Execute Creating Table
            System.out.println("DB Updated!");
        } catch (Exception e) {
            String newTableName = "CLUBS";
            System.out.println("Success! " + newTableName + "Exists!");
        }
    }

     /**
     * This Method Creates a new GAMES Table If None Exist
     * If Exists Then Skips and Prints out It Exists
     */
    public void createPlayGameTable() {
        try {
            statement = conn.createStatement(); // New Statement
            String newTableName = "GAMES";
            // SQL Statement for Creating Table
            String sqlCreate = "create table " + newTableName + " (NAME VARCHAR(20),"
                    + "WINS int)";
            statement.executeUpdate(sqlCreate);
        } catch (Exception e) {
            String newTableName = "GAMES";
            System.out.println("Success!" + newTableName + "Exists!");
        }
    }

     /**
     * This Method Creates a new Players Table If None Exist
     * If Exists Then Skips and Prints out It Exists
     */
    public void createPlayersTable() {
        try {
            statement = conn.createStatement(); // New Statement
            String newTableName = "PLAYERS";
            // SQL Statement for Creating Table
            String sqlCreate = "create table " + newTableName + " (NAME VARCHAR(20),"
                    + "CLUB VARCHAR(20), NUMBER VARCHAR(20))";
            statement.executeUpdate(sqlCreate);
        } catch (Exception e) {
            String newTableName = "PLAYERS";
            System.out.println("Success!" + newTableName + "Exists!");
        }
    }

    /**
     * This Method Gets The Clubs Table
     * Can Be Called From Other Classes
     */
    public void getClubsTable() {
        try {
            statement = conn.createStatement(); // New Statement
            rs = statement.executeQuery("SELECT NAME, LOCATION, "
                    + "PLAYERS FROM CLUBS"); // Execute Query
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }

    /**
     * This Method Reads In The Table Data
     * Prints To Console On Program Start
     */
    public void readTableData() {
        try {
            statement = conn.createStatement(); // New Statement
            String sql = "SELECT * FROM CLUBS";
            rs = statement.executeQuery(sql); // Result Set Executes Statement
            FootballTeam footTeam = new FootballTeam(null, null, null); // New FootballTeam Object

            // Reads In Data From Table And Adds To Club Array
            while (rs.next()) {
                String pName = rs.getString("name");
                String pLocation = rs.getString("location");
                String pNumber = rs.getString("players");
                this.mb.addClub(pName, pLocation, pNumber);
                // this.view.update(); 
            }
            System.out.println("CURRENT TEAMS IN TABLE:");
            System.out.println(this.mb.club.toString());
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();

        }
    }
    
}
