/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 * This Class Controls The View Of the Panel
 * Implements JSwing Objects 
 * Controls How Home, Play Game, Players, Clubs Work
 * 
 * @author Hamish Maritz 1383425
 */
public class View extends JComponent {

    // Initializes Variables/Objects
    private Database db;
    private Image image;
    private Image imageTwo;
    private Model model;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JButton playGame;
    private JButton viewPlayer;
    private JButton viewClub;
    private JTabbedPane pane;
    private JPanel panelOne;
    private JOptionPane addClubBox;
    private JButton addClubButton;
    private JButton removeClubButton;
    private JComboBox homeTeamTextBox;
    private JComboBox awayTeamTextBox;
    private JLabel loadingIcon;
    private JList clubList;
    private JTextArea messageOfTheDay;
    private JTextArea homeTeamText;
    private JTextArea awayTeamText;
    private JButton addPlayerButton;
    private JButton removePlayerButton;
    private JButton tradePlayerButton;

    
    // Getters and Setters For Panels
    
    public JButton getTradePlayerButton() {
        return tradePlayerButton;
    }

    public void setTradePlayerButton(JButton tradePlayerButton) {
        this.tradePlayerButton = tradePlayerButton;
    }

    public JButton getAddPlayerButton() {
        return addPlayerButton;
    }

    public void setAddPlayerButton(JButton addPlayerButton) {
        this.addPlayerButton = addPlayerButton;
    }

    public JButton getRemovePlayerButton() {
        return removePlayerButton;
    }

    public void setRemovePlayerButton(JButton removePlayerButton) {
        this.removePlayerButton = removePlayerButton;
    }

    public JList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(JList playerList) {
        this.playerList = playerList;
    }
    private JList playerList;

    public JTextArea getHomeTeamText() {
        return homeTeamText;
    }

    public void setHomeTeamText(JTextArea homeTeamText) {
        this.homeTeamText = homeTeamText;
    }

    public JTextArea getAwayTeamText() {
        return awayTeamText;
    }

    public void setAwayTeamText(JTextArea awayTeamText) {
        this.awayTeamText = awayTeamText;
    }

    public JComboBox getHomeTeamTextBox() {
        return homeTeamTextBox;
    }

    public void setHomeTeamTextBox(JComboBox homeTeamTextBox) {
        this.homeTeamTextBox = homeTeamTextBox;
    }

    public JComboBox getAwayTeamTextBox() {
        return awayTeamTextBox;
    }

    public void setAwayTeamTextBox(JComboBox awayTeamTextBox) {
        this.awayTeamTextBox = awayTeamTextBox;
    }

    public JLabel getLoadingIcon() {
        return loadingIcon;
    }

    public void setLoadingIcon(JLabel loadingIcon) {
        this.loadingIcon = loadingIcon;
    }

    public JTextArea getMessageOfTheDay() {
        return messageOfTheDay;
    }

    public void setMessageOfTheDay(JTextArea messageOfTheDay) {
        this.messageOfTheDay = messageOfTheDay;
    }

    public JButton getRemoveClubButton() {
        return removeClubButton;
    }

    public void setRemoveClubButton(JButton removeClubButton) {
        this.removeClubButton = removeClubButton;
    }

    public JButton getPlayGameButton() {
        return playGameButton;
    }

    public void setPlayGameButton(JButton playGameButton) {
        this.playGameButton = playGameButton;
    }
    private JButton playGameButton;

    public JButton getAddClubButton() {
        return addClubButton;
    }

    public void setAddClubButton(JButton addClubButton) {
        this.addClubButton = addClubButton;
    }

    public JOptionPane getAddClubBox() {
        return addClubBox;
    }

    public void setAddClubBox(JOptionPane addClubBox) {
        this.addClubBox = addClubBox;
    }

    public JList getClubList() {
        return clubList;
    }

    public void setClubList(JList clubList) {
        this.clubList = clubList;
    }

    public JTextField getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(JTextField displayMessage) {
        this.displayMessage = displayMessage;
    }
    private JTextField displayMessage;

    public JTable getClubTable() {
        return clubTable;
    }

    public void setClubTable(JTable clubTable) {
        this.clubTable = clubTable;
    }
    private JTable clubTable;

    public JPanel getPanelTwo() {
        return panelTwo;
    }

    public void setPanelTwo(JPanel panelTwo) {
        this.panelTwo = panelTwo;
    }

    public JPanel getPanelThree() {
        return panelThree;
    }

    public void setPanelThree(JPanel panelThree) {
        this.panelThree = panelThree;
    }

    public JPanel getPanelFour() {
        return panelFour;
    }

    public void setPanelFour(JPanel panelFour) {
        this.panelFour = panelFour;
    }


    public JPanel getPanelOne() {
        return panelOne;
    }

    public void setPanelOne(JPanel panelOne) {
        this.panelOne = panelOne;
    }

    public JTabbedPane getPane() {
        return pane;
    }

    public void setPane(JTabbedPane pane) {
        this.pane = pane;
    }

    public JButton getPlayGame() {
        return playGame;
    }

    public void setPlayGame(JButton playGame) {
        this.playGame = playGame;
    }

    public JButton getViewPlayer() {
        return viewPlayer;
    }

    public void setViewPlayer(JButton viewPlayer) {
        this.viewPlayer = viewPlayer;
    }

    public JButton getViewClub() {
        return viewClub;
    }

    public void setViewClub(JButton viewClub) {
        this.viewClub = viewClub;
    }
    
    /**
     * This Paints The Panel With the Desired BackGround Color
     * @param g 
     */
    public void paintComponent(Graphics g) {
        image = new ImageIcon("aut.jpg").getImage(); // Creates New Image
        imageTwo = new ImageIcon("logo.png").getImage(); // Creates New Image
        g.drawImage(image, 0, 0, null); // Draws Image
        g.drawImage(imageTwo, 10, 10, null); // Draws Imagine
    }

    public View(Model model) {
        
        this.model = model;//set the model.
        setLayout(null);//Choose to lay out components manually

        this.clubList = new JList(this.model.getClubList()); // Creates New JList for ClubList Object
        // Sets Single Selection Model
        this.clubList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
       
        // Creates New ScrollPane For ClubList
        JScrollPane scrollPaneTwo = new JScrollPane(clubList);
        scrollPaneTwo.setLocation(10, 10);
        scrollPaneTwo.setSize(370, 200);
        scrollPaneTwo.setOpaque(false);
        scrollPaneTwo.getViewport().setOpaque(false);
        this.add(scrollPaneTwo);

        //  Creates new JList For Player Object
        this.playerList = new JList(this.model.getPlayerList());
        // Sets Single Selection Model
        this.playerList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Creates New ScrollPane for PlayerList
        JScrollPane scrollPaneThree = new JScrollPane(playerList);
        scrollPaneThree.setLocation(10, 10);
        scrollPaneThree.setSize(370, 200);
        scrollPaneThree.setOpaque(false);
        scrollPaneThree.getViewport().setOpaque(false);
        this.add(scrollPaneThree);

        //Implements Gif Icon 
        ImageIcon iconLogo = new ImageIcon("loading2.gif");
        this.loadingIcon = new JLabel();
        loadingIcon.setLocation(450, 430);
        loadingIcon.setSize(50, 50);
        loadingIcon.setIcon(iconLogo);
        this.add(loadingIcon);

        // Creates new PlayGame JButton
        this.playGameButton = new JButton("Play Game!");
        playGameButton.setLocation(150, 200);
        playGameButton.setSize(100, 25);
        this.add(playGameButton);

        // Creates New Date And Format 
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        // Randomizes Message Upon Program Opening
        String[] ards = {date + "\n News: Zlatan Ibrahmivoc Has Been Traded"
            + "\n News: Arsenal Wins The Premiership!"
            + "\n News: Arsenal Leads 3-0 In Premiership!"
            + "\n News: Player Transfer Season Is Now Open!"
            + "\n News: Alex Ferguson In Talks Of Coaching",
            date + "\nNews: Chelsea Are Through To The Final!"
            + "\nNews: Mike Robinson Has Retired!"
            + "\nNews: Tom Scott Has Been Traded for $13.5 Million!"
            + "\nNews: Real Madrid Set To Play Manchester City!",
            date + "\nNews: Donald Robinson Is Out With An Injury!"
            + "\nNews: Tottingham Beats Manchester United! 2-0"
            + "\nNews: Yi Yang Is The New Striker For WestHam!"
            + "\nNews: Rumours Around Alto Davids Depature"};
        Random ran = new Random(); // New Random Object
        String s_ran = ards[ran.nextInt(ards.length)]; // Sets The String At Random
        Font myFont = new Font("Arial", Font.BOLD, 12); // New Font Object

        // Adds New Message Of The Day JTextField
        this.messageOfTheDay = new JTextArea(s_ran);
        messageOfTheDay.setLocation(50, 100);
        messageOfTheDay.setSize(300, 150);
        messageOfTheDay.setEditable(false);
        messageOfTheDay.setOpaque(false);
        messageOfTheDay.setBackground(new Color(0, 0, 0, 0));
        messageOfTheDay.setFont(myFont);
        Border blackline; 
        blackline = BorderFactory.createLineBorder(Color.black); 
        messageOfTheDay.setBorder(blackline);
        this.add(messageOfTheDay);

        // Creates HomeTeamText For PlayGame PanneTab 
        Font teamFont = new Font("Impact", Font.BOLD, 16); // New Font Object
        this.homeTeamText = new JTextArea("Home Team");
        homeTeamText.setLocation(160, 10);
        homeTeamText.setSize(180, 70);
        homeTeamText.setEditable(false);
        homeTeamText.setOpaque(false);
        homeTeamText.setFont(teamFont);
       
        // Creates New HomeTeam ComboBox in Play Game
        this.homeTeamTextBox = new JComboBox();
        homeTeamTextBox.setLocation(10, 50);
        homeTeamTextBox.setSize(370, 20);
        this.add(homeTeamTextBox);

        // Creates AwayTeamText for PlayGame PanneTab
        this.awayTeamText = new JTextArea("Away Team");
        awayTeamText.setLocation(160, 100);
        awayTeamText.setSize(180, 70);
        awayTeamText.setEditable(false);
        awayTeamText.setOpaque(false);
        awayTeamText.setFont(teamFont);
        this.add(awayTeamText);

        // Creates new AwayTeam ComboBox in Play Game
        this.awayTeamTextBox = new JComboBox();
        awayTeamTextBox.setLocation(10, 150);
        awayTeamTextBox.setSize(370, 20);
        this.add(awayTeamTextBox);

        // Welcome Screen Message
        this.displayMessage = new JTextField("Welcome To Football Manager 2018");
        displayMessage.setLocation(70, 10);
        displayMessage.setSize(240, 30);
        displayMessage.setEditable(false);
        this.add(displayMessage);

        // Add Club JOptionPane
        this.addClubBox = new JOptionPane();
        addClubBox.setSize(300, 200);
        addClubBox.setLocation(200, 200);
        addClubBox.setVisible(false);
        this.add(addClubBox);

        // Add Club Button JButton
        this.addClubButton = new JButton("Add Club");
        addClubButton.setSize(100, 50);
        addClubButton.setLocation(100, 200);
        this.add(addClubButton);

        // Remove Club Button JButton
        this.removeClubButton = new JButton("Remove Club");
        removeClubButton.setSize(100, 50);
        removeClubButton.setLocation(200, 200);
        this.add(removeClubButton);

        // Add Player Button JButton
        this.addPlayerButton = new JButton("Add Player");
        addPlayerButton.setSize(100, 50);
        addPlayerButton.setLocation(50, 200);
        this.add(addPlayerButton);
        
        // Remove Player Button JButton
        this.removePlayerButton = new JButton("Remove Player");
        removePlayerButton.setSize(100, 50);
        removePlayerButton.setLocation(250, 200);
        this.add(removePlayerButton);

        // Trade Player Button JButton
        this.tradePlayerButton = new JButton("Trade Player");
        tradePlayerButton.setSize(100, 50);
        tradePlayerButton.setLocation(150, 200);
        this.add(tradePlayerButton);

        // Home Panel 
        panelOne = new JPanel();
        panelOne.setLayout(null); 
        panelOne.setOpaque(false);
        panelOne.add(displayMessage); 
        panelOne.add(messageOfTheDay);
        this.add(panelOne);

        // Play Game Panel
        panelTwo = new JPanel();
        panelTwo.setLayout(null);
        panelTwo.setOpaque(false);
        panelTwo.add(playGameButton);
        panelTwo.add(homeTeamTextBox);
        panelTwo.add(awayTeamTextBox);
        panelTwo.add(homeTeamText);
        panelTwo.add(awayTeamText);
        this.add(panelTwo);

        // Players Panel
        panelThree = new JPanel();
        panelThree.setLayout(null);
        panelThree.setOpaque(false);
        panelThree.add(scrollPaneThree);
        panelThree.add(addPlayerButton);
        panelThree.add(removePlayerButton);
        panelThree.add(tradePlayerButton);
        this.add(panelThree);

        // Clubs Panel
        panelFour = new JPanel();
        panelFour.setLayout(null);
        panelFour.setOpaque(false);
        panelFour.add(scrollPaneTwo);
        panelFour.add(addClubButton);
        panelFour.add(removeClubButton);
        this.add(panelFour);

        // New Tabbed Panel With Menu Options
        JTabbedPane pane = new JTabbedPane();
        pane.setBounds(50, 180, 400, 300);
        pane.add("Home", panelOne);
        pane.add("Play Game", panelTwo);
        pane.add("Player Menu", panelThree);
        pane.add("Club Menu", panelFour);
        pane.setOpaque(false);
        this.add(pane);

        setSize(290, 230); // manually computed sizes
        this.update();

    }

    /**
     * This Method Updates The View Based
     * On The Items Stored In The Model
     */
    public void update() {

        this.playerList.setListData(this.model.getPlayerList());
        this.homeTeamTextBox.setModel(new DefaultComboBoxModel(this.model.club.toArray()));
        this.awayTeamTextBox.setModel(new DefaultComboBoxModel(this.model.club.toArray()));// UPDATES THE JCOMBOBOX IN PLAY GAME WITH TEAMS
        this.clubList.setListData(this.model.getClubList());

    }

}
