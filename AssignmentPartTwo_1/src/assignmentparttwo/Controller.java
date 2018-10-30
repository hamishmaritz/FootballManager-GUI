/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;



/**
 * Controller Class that handles all Event Method JSwing Components
 * Handles JButton, JScrollPane, JOptionPane Methods
 * Handles for Play Game, Player, Club Pannetab Methods
 * 
 * @author Hamish Maritz, 1383425
 *
 */
public class Controller extends JFrame {

    
    // Initialize Variables/Objects
    private Model model;
    private View view;
    Database db = new Database();

    
    /**
     * This is the method that adds a Club to the Clubs Array
     * Stores The Club into the "CLUBS" Table in the JDBC DB
     * @param 
     * @exception SQL Exceptions
     */
    private void eventHandleOptionPane() {
        try {
            // Enter Clubs Details
            String clubName = JOptionPane.showInputDialog("Enter Team Name:");
            String clubLocation = JOptionPane.showInputDialog("Enter Club Location:");
            String playerCount = JOptionPane.showInputDialog("Enter Player Count:");

            // Adds User Input Into Club ArrayList
            this.model.addClub(clubName, clubLocation, playerCount);
            
            System.out.println("Updated!");
            System.out.println("Team Added!");
            System.out.println("Current Teams in Array: " + this.model.club.toString());

            // SQL Query Inserting Values into CLUBS Tabble
            String sql = "INSERT INTO clubs"
                    + "(name, location, players) VALUES"
                    + "(?,?,?)";
            Connection myConnection2 = db.autoConnectFootBallDB(); // Connection To DB
            PreparedStatement preparedStatement = myConnection2.prepareStatement(sql); // PreparedStatement Object
            preparedStatement.setString(1, clubName);// Set String as ClubName
            preparedStatement.setString(2, clubLocation); // Set String as Club Location
            preparedStatement.setString(3, playerCount); // Set String as PlayerCount
            preparedStatement.executeUpdate(); // Update Panel
            preparedStatement.close(); 
            System.out.println("Team Added To Clubs Table");
            this.view.update();
        } catch (Throwable ex) {
            // Catch SQL Exception
            System.err.println("SQL Exception: " + ex.getMessage()); 
        }
    }

    /**
     * This Method Handles "Play Game"
     * Once JButton is Clicked Method eventHandlePlayGame() Is Called
     * Sets The Teams From homeTeamTextBox and awayTeamTextBox
     * Randomizes Results For The Winner and Loser
     * Stores Results in GAMES Table in JDBC Table
     */
    private void eventHandlePlayGame() {
        
        // Gets The Values Inside the JComboBox 
        String xHome = String.valueOf(this.view.getHomeTeamTextBox().getSelectedItem());
        String xAway = String.valueOf(this.view.getAwayTeamTextBox().getSelectedItem());

        // Splits The Strings and Gets Name of Teams
        String homeSplit[] = xHome.split(" "); // Sets New String Array
        String homeFinal = homeSplit[2]; // Sets Array Index at '2' to homeFinal String
        String awaySplit[] = xAway.split(" "); // Sets new String Array
        String awayFinal = awaySplit[2]; // Sets Array Index at '2' to awayFinal String

        
        FootballTeam home = null; // New FootballTeam Object
        
        for (FootballTeam c : this.model.club) {
            // Checks To See If Club List Contains Selected Home Team
            if (c.getClub().contains(homeFinal)) {
                home = c; // Sets The Home Team
                System.out.println("Home Team Added");
                System.out.println("------");
            }
        }

        FootballTeam away = null; // New FootballTeam Object 
        for (FootballTeam d : this.model.club) {
          // Checks To See If Club List Contains Selected Away Team
            if (d.getClub().contains(awayFinal)) {
                away = d; // Sets The Away Team
                System.out.println("Away Team Added");
                System.out.println("------");
            }
        }
        PlayGame match = new PlayGame(); // Creates New Play Match Object
        match.setTeam1(home); // Sets Team 1 As Home
        match.setTeam2(away); // Sets Team 2 As Away
        match.setTeam1Score(0); // Sets Default Score as 0
        match.setTeam2Score(0); // Sets Default Score as 0

        Random rand = new Random(); // Creates new Random Object
        int n = rand.nextInt(2) + 1; // Create Int using Rand Between 1-2
        try {
            // If N Equals 1 Home Team Has Won; Updates Values
            if (n == 1) {
                home.setWinCount(home.getWinCount() + 1); // Increases Home Win Count
                away.setLossCount(away.getLossCount() + 1); // Increases Away Lose Count
                match.setTeam1Score(match.getTeam1Score() + 1); // Increase Home Score
                System.out.println("| ---------------------- |");
                System.out.println("  The Home Team Has Won!");
                System.out.println("|" + home + "|");
                System.out.println("| ---------------------- |");
                System.out.println(home.getWinCount()); // Displays Win Count
                // OptionPane Displaying Winner Results
                JOptionPane.showMessageDialog(null, "WINNER: \n" + home + " \n Current Win Count: "
                        + home.getWinCount() + "\n Current Loss Count: " + home.getLossCount());
                // Inserts Home Team Wins Into JDBC Table GAMES
                String sql = "INSERT INTO games"
                        + "(name, wins) VALUES"
                        + "(?,?)";
                Connection myConnection2 = db.autoConnectFootBallDB();
                PreparedStatement preparedStatement = myConnection2.prepareStatement(sql);
                preparedStatement.setString(1, homeFinal);
                preparedStatement.setInt(2, home.getWinCount());
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } else if (n == 2) {     
                // If N Equals 2 Away Team Has Won; Updates Values
                away.setWinCount(away.getWinCount() + 1); // Increases Away Win Count
                home.setLossCount(home.getLossCount() + 1); /// Increases Home Lose Count
                match.setTeam2Score(match.getTeam2Score() + 1); // Increases Away Score
                System.out.println("| ---------------------- |");
                System.out.println("  The Away Team Has Won!");
                System.out.println("|" + away + "|");
                System.out.println("| ---------------------- |");
                System.out.println(away.getWinCount()); // Displays Win Count
                // OptionPane Displaying Winner Results
                JOptionPane.showMessageDialog(null, "WINNER: " + away + " \n Current Win Count: "
                        + away.getWinCount() + "\n Current Loss Count: " + away.getLossCount());
                // Inserts Away Team Wins Into JDBC Table GAMES
                String sql = "INSERT INTO games"
                        + "(name, wins) VALUES"
                        + "(?,?)";
                Connection myConnection2 = db.autoConnectFootBallDB();
                PreparedStatement preparedStatement = myConnection2.prepareStatement(sql);
                preparedStatement.setString(1, awayFinal);
                preparedStatement.setInt(2, away.getWinCount());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error in eventHandleGame()");
        }

    }

   /**
    * This Method Handles The JButton Remove Club from Clubs
    * Removes Selected Club From Index
    * 
    */
    private void eventHandleRemoveClub() {
        // If Club is at Selected Index then Remove Club 
        int index = this.view.getClubList().getSelectedIndex();
        if (index != -1) {
            this.model.removeClub(index);
        }
        this.view.update();
        System.out.println("Club Removed!");
    }

    /**
     * This Method Handles Opening The Window
     * Prints to Console Displaying Window Opened
     */
    private void eventHandleWindowOpened() {
        System.out.println("Window opened!");
        this.view.update();
    }

    /**
     * This Method Handles The JButton Add Player in Players
     * User inserts Name, Club, Location 
     * Adds Player to Player ArrayList
     * Stores Player Information in JDBC Table PLAYERS
     * 
     */
    private void eventHandleAddPlayer() {
        try {
            // OptionPane Querying For Input
            String pName = JOptionPane.showInputDialog("Enter Player Name:");
            String pClub = JOptionPane.showInputDialog("Enter Club :");
            String pNumber = JOptionPane.showInputDialog("Enter Player Number:");
            // Adds Player To Player Array
            this.model.addPlayer(pName, pClub, pNumber); 
            System.out.println("Updated!");
            System.out.println("Player Added!");
            System.out.println("Current Players in Array: " + this.model.player.toString());
            
            // SQL Query That Adds Player Into PLAYERS Table in JDBC
            String sql = "INSERT INTO players"
                    + "(name, club, number) VALUES"
                    + "(?,?,?)";
            Connection myConnection2 = db.autoConnectFootBallDB();
            PreparedStatement preparedStatement = myConnection2.prepareStatement(sql);
            preparedStatement.setString(1, pName);
            preparedStatement.setString(2, pClub);
            preparedStatement.setString(3, pNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            this.view.update();
        } catch (SQLException e) {
            System.out.println("Error!");
        }

    }
    /**
     * This Method handles Removing A Player 
     * Using the Remove Player Button in Player
     * 
     */
    private void eventHandleRemovePlayer() {
        // Gets Selected Index then Removes Player From ArrayList
        int index = this.view.getPlayerList().getSelectedIndex();
        if (index != -1) {
            this.model.removePlayer(index);
        }
        this.view.update();
        System.out.println("Player Removed!");
    }

    /**
     * This Method Handles Trading a Player
     * Under Player with Trade Player JButton
     * Query for Player Name and New Team
     * Will then Refresh the JPanel
     * Will Move Player To Selected Team
     */
    private void eventHandleTradePlayer() {
        // Query for Player Name
        String pName = JOptionPane.showInputDialog("Enter Player:");
        
        for (Player player : this.model.player) {
            // If Player Name is Equal To User Input Then Continue
            if (player.getpName().equals(pName)) {
                // Query For New Club
                String newClub = JOptionPane.showInputDialog("Enter New Club:");
                // New FootballTeam Extended Club Object with newClub String
                FootballTeam nClub = new FootballTeam(null, newClub, null);
                // Set Name of New Club
                nClub.setName(newClub);

                for (FootballTeam p : this.model.club) {
                    // If Club List Contains Name Of Queried Club Then Continue
                    if (p.getClub().contains(newClub)) {
                        // Display If It's Contained
                        System.out.println("It's Contained!");
                        player.setpClub(newClub); // Set Players New Club
                        System.out.println(pName + " Added To: " + newClub);
                    }
                }
                // SQL Query That Updates PLAYER Table with the new Players Club
                try {
                    String query1 = "UPDATE players SET club = ?"
                            + "WHERE name = ?";
                    Connection myConnection2 = db.autoConnectFootBallDB();
                    PreparedStatement preparedStatement = myConnection2.prepareStatement(query1);
                    preparedStatement.setString(1, newClub);
                    preparedStatement.setString(2, pName);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }

    /**
     * Controller Class that Handles ActionListeners
     * Adding Example Clubs and Players
     * @param name 
     */
    public Controller(String name) {
        super(name);
        
        this.model = new Model(); // Creates new Model View
        // Adds Example Clubs and Players
        this.model.addClub("Arsenal", "London", "16");
        this.model.addClub("Manchester United", "Manchester", "16");
        this.model.addClub("Southhampton Rovers", "Southam", "16");
        this.model.addClub("Liverpool FC", "Liverpool", "16");
        this.model.addPlayer("Yi Yang", "Manchester", "10");
        this.model.addPlayer("Hamish Maritz", "Liverpool", "8");
        
        this.view = new View(this.model); // Creates new View Object

        // Add Club Action Listener
        this.view.getAddClubButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleOptionPane();
            }
        });
        // Remove Club Action Listener
        this.view.getRemoveClubButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleRemoveClub();
            }
        });

        // Play Game Button Action Listener
        this.view.getPlayGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandlePlayGame();
            }
        });
        // Add Player Action Listener
        this.view.getAddPlayerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleAddPlayer();
            }
        });
        // Remove Player Action Listener
        this.view.getRemovePlayerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleRemovePlayer();
            }
        });
        // Trade Player Action Listener
        this.view.getTradePlayerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleTradePlayer();
            }
        });

        //getContentPane().setLayout(null);
        this.getContentPane().add(this.view);

        // Set program to stop when window closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500); // Manually Computed Sizes
        setResizable(false); // Dont Allow Resizable

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                eventHandleWindowOpened();
            }
        });

    }

}
