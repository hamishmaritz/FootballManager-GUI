/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentparttwo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hamish
 */
public class ModelTest {

    public ModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Model newModel = new Model();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addClub method, of class Model.
     * Test Whether A Club Is Actually Added To The Array
     */
    @Test
    public void testAddClub() {
        System.out.println("addClub");
        String name = "Test";
        String location = "Test";
        String playerCount = "Test";
        Model instance = new Model();
        Model instanceTwo = new Model();
        instance.addClub(name, location, playerCount);
        String nameTwo = "Test";
        String locationTwo = "Test";
        String playerCountTwo = "Test";
        instanceTwo.addClub(nameTwo, locationTwo, playerCountTwo);
        assertEquals(instance.club, instance.club);

    }

    /**
     * Test of removeClub method, of class Model.
     * Tests Whether The Club Is Removed From Index
     */
    @Test
    public void testRemoveClub() {
        System.out.println("removeClub");
        int index = 0;
        Model instance = new Model();
        String name = "Test";
        String location = "Test";
        String playerCount = "Test";
        instance.addClub(name, location, playerCount);
        instance.removeClub(index);
    }

    /**
     * Test of addPlayer method, of class Model.
     * Tests Whether A Player Is Added To The Array
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        String name = "Joe";
        String club = "Manchester";
        String playerNumber = "14";
        Model instance = new Model();
        instance.addPlayer(name, club, playerNumber);
    }

    /**
     * Test of removePlayer method, of class Model.
     * Tests Whether A Player Is Removed From the Index
     */
    @Test
    public void testRemovePlayer() {
        System.out.println("removePlayer");
        int index = 0;
        String name = "Test";
        String location = "Test";
        String playerCount = "Test";
        Model instance = new Model();
        instance.addPlayer(name, name, playerCount);
        instance.removePlayer(index);
    }

    /**
     * Test of hasPlayer method, of class Model.
     * Test If Player Exists
     */
    @Test
    public void testHasPlayer() {
        System.out.println("hasPlayer");
        Player text = null;
        Model instance = new Model();
        boolean expResult = false;
        boolean result = instance.hasPlayer(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasClub method, of class Model.
     * Test If Clubs Exist
     */
    @Test
    public void testHasClub() {
        System.out.println("hasClub");
        FootballTeam text = null;
        Model instance = new Model();
        boolean expResult = false;
        boolean result = instance.hasClub(text);
        assertEquals(expResult, result);
    }

}
