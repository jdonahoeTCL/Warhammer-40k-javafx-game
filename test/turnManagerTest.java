/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Faraz
 */
public class turnManagerTest {
    
    public turnManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pass method, of class turnManager.
     */
    @Test
    public void testPass() {
        System.out.println("pass");
        unit[] one = new unit[1] ;
        unit[] two = new unit[1];
        one[0] = new SpaceMarine("Unit 1",true);
        two[0] = new SpaceMarine("Unit 2",false);
        turnManager instance = new turnManager();
        instance.pass(one, two);
        boolean expResult = true;
        boolean result = instance.getTurn();
    }

    /**
     * Test of player1Turn method, of class turnManager.
     */
    @Test
    public void testPlayer1Turn() {
        System.out.println("player1Turn");
        turnManager instance = new turnManager();
        boolean expResult = true;
        boolean result = instance.player1Turn();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of player2Turn method, of class turnManager.
     */
    @Test
    public void testPlayer2Turn() {
        System.out.println("player2Turn");
        turnManager instance = new turnManager();
        boolean expResult = false;
        boolean result = instance.player2Turn();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of incPhase method when phase is 1, of class turnManager.
     */
    @Test
    public void testIncPhase() {
        System.out.println("incPhase");
        turnManager instance = new turnManager();
        int expResult = 2;
        instance.incPhase();
        int result = instance.getPhase();
        assertEquals(expResult, result);
       
    }
        /**
     * Test of incPhase method when called twice to get phase a phase of 3, of class turnManager.
     */
    @Test
    public void testIncPhase1() {
        System.out.println("incPhase");
     turnManager instance = new turnManager();
        int expResult = 3;
        instance.incPhase();
        instance.incPhase();
        int result = instance.getPhase();
        assertEquals(expResult, result);
       
    }
        /**
     * Test of incPhase method when called three times, of class turnManager.
     */
    @Test
    public void testIncPhase2() {
        System.out.println("incPhase");
        turnManager instance = new turnManager();
        int expResult = 3;
        instance.incPhase();
        instance.incPhase();
        instance.incPhase();
        instance.incPhase();
        
        int result = instance.getPhase();
        assertEquals(expResult, result);
       
    }
    
 

    /**
     * Test of decPhase method when phase is 1, of class turnManager.
     */
    @Test
    public void testDecPhase() {
        System.out.println("decPhase");
        turnManager instance = new turnManager();
        int expResult = 1;
        instance.decPhase();
        int result = instance.getPhase();
        assertEquals(expResult, result);
    }

    /**
     * Test of decPhase method when phase is 2, of class turnManager.
     */
    @Test
    public void testDecPhase1() {
        System.out.println("decPhase");
        turnManager instance = new turnManager();
        int expResult = 1;
        instance.incPhase();
        instance.decPhase();
        int result = instance.getPhase();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of decPhase method when phase is 3, of class turnManager.
     */
    @Test
    public void testDecPhase2() {
        System.out.println("decPhase");
        turnManager instance = new turnManager();
        int expResult = 2;
        instance.incPhase();
        instance.incPhase();
        instance.decPhase();
        int result = instance.getPhase();
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of getPhase method, of class turnManager.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        turnManager instance = new turnManager();
        int expResult = 1;
        int result = instance.getPhase();
        assertEquals(expResult, result);

    }
    
    
    /**
     * Test of getPhase method, of class turnManager when phase is 2.
     */
    @Test
    public void testGetPhase1() {
        System.out.println("getPhase");
        turnManager instance = new turnManager();
        instance.incPhase();
        int expResult = 2;
        int result = instance.getPhase();
        assertEquals(expResult, result);

    }

    /**
     * Test of isMove method when phase is 1, of class turnManager.
     */
    @Test
    public void testIsMove() {
        System.out.println("isMove");
        turnManager instance = new turnManager();
         boolean expResult = true;
         boolean result = instance.isMove();
        assertEquals(expResult, result);
      
    }
    
     /**
     * Test of isMove method when phase is not 1, of class turnManager.
     */
    @Test
    public void testIsMove1() {
        System.out.println("isMove");
        turnManager instance = new turnManager();
        instance.incPhase();
         boolean expResult = false;
         boolean result = instance.isMove();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of isShoot method when phase is not 2, of class turnManager.
     */
    @Test
    public void testIsShoot() {
        System.out.println("isShoot");
        turnManager instance = new turnManager();
        boolean expResult = false;
        boolean result = instance.isShoot();
        assertEquals(expResult, result);
      
    }

        /**
     * Test of isShoot method when phase is 2, of class turnManager.
     */
    @Test
    public void testIsShoot1() {
        System.out.println("isShoot");
        turnManager instance = new turnManager();
        instance.incPhase();
        boolean expResult = true;
        boolean result = instance.isShoot();
        assertEquals(expResult, result);
      
    }
     /**
     * Test of isAssualt method when phase is not 3, of class turnManager.
     */
    @Test
    public void testIsAssualt() {
        System.out.println("isAssualt");
        turnManager instance = new turnManager();
        boolean expResult = false;
        boolean result = instance.isAssualt();
        assertEquals(expResult, result);
  
    }
         /**
     * Test of isShoot method is not 3, of class turnManager.
     */
       public void testIsAssualt1() {
        System.out.println("isAssualt");
        turnManager instance = new turnManager();
        instance.incPhase();
        instance.incPhase();
        boolean expResult = true;
        boolean result = instance.isAssualt();
        assertEquals(expResult, result);
  
    }
    
    
}
