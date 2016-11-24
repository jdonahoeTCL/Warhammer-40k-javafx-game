/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josh
 */



public class D6Test extends D6{
    
    public D6Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of roll method, of class D6 using wrapper for random
     */
    @Test
    public void testRoll() {
      
        System.out.println("roll");
        int num = 1;
        int success = 6;
        D6.IRandom randomgenerator = new D6.MockedRandomWrapper(1);
        D6 instance = new D6(randomgenerator);
        int expResult = 1;
        int result = instance.roll(num, success);
        assertEquals(expResult, result);
    }
    
         /**
     * Test of roll method, when random generated is lower than success 
     */
    @Test
    public void testRollRandomLowerThanSuccess() {
      
        System.out.println("roll lower than success");
        int num = 1;
        int success = 6;
        D6.IRandom randomgenerator2 = new D6.MockedRandomWrapper(0);
        D6 newinstance = new D6(randomgenerator2);
        int expResult = 0;
        int result = newinstance.roll(num, success);
        assertEquals(expResult, result);
    }

     /**
     * Test of roll method, of class D6 using wrapper for random with a larger num value
     */
    @Test
    public void testRollWithBiggerNum() {
      
        System.out.println("roll big num");
        int num = 4;
        int success = 1;
        D6.IRandom randomgenerator1 = new D6.MockedRandomWrapper(0);
        D6 instance = new D6(randomgenerator1);
        int expResult = 4;
        int result = instance.roll(num, success);
        assertEquals(expResult, result);
    }
        


    /**
     * Test of charge method, of class D6. Rolls two 1, so expected should be 2.
     */
    @Test
    public void testCharge() {
        System.out.println("charge");
         D6.IRandom randomgenerator1 = new D6.MockedRandomWrapper(0);
        D6 instance = new D6(randomgenerator1);
        int expResult = 2;
        int result = instance.charge();
        assertEquals(expResult, result);
    }

       /**
     * Test of charge method, of class D6. Tries .5 as random number generated.
     */
    @Test
    public void testCharge2() {
        System.out.println("charge");
         D6.IRandom randomgenerator1 = new D6.MockedRandomWrapper(.5);
        D6 instance = new D6(randomgenerator1);
        int expResult = 8;
        int result = instance.charge();
        assertEquals(expResult, result);
    }
    
}
