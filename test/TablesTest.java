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
public class TablesTest {
    
    public TablesTest() {
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
     * Test of all values for getToHit method, of class Tables.
     */
    @Test
    public void testGetToHit() {
        System.out.println("getToHit");
        int[] toHitArray={0,6,5,4,3,2};
        Tables instance = new Tables();
        int expResult =0;
        int result =0;
        for(int i =0;i<6;i++)
        {
       expResult = toHitArray[i];
       result = instance.getToHit(i);
       assertEquals(expResult, result);
        }
    }

    /**
     * Test all values of getToHitAssualt method, of class Tables.
     */
    
 
    @Test
    public void testGetToHitAssualt() {
        System.out.println("getToHitAssualt");
        int[][] toHitAssualt={{4,4,5,5,5,5,5,5,5,5},
                                           {3,4,4,4,5,5,5,5,5,5},
                                           {3,3,4,4,4,4,5,5,5,5},
                                           {3,3,3,4,4,4,4,4,5,5},
                                           {3,3,3,3,4,4,4,4,4,4},
                                           {3,3,3,3,3,4,4,4,4,4},
                                           {3,3,3,3,3,3,4,4,4,4},
                                           {3,3,3,3,3,3,3,4,4,4},
                                           {3,3,3,3,3,3,3,3,4,4},
                                           {3,3,3,3,3,3,3,3,3,4}};
       
        int expResult = 0;
        int result = 0;
        Tables instance = new Tables();
        for(int i =0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
             expResult = toHitAssualt[i][j];
             result = instance.getToHitAssualt(i, j);
             assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test all values of getToWound method, of class Tables.
     */
    
    @Test
    public void testGetToWound() {
        int[][] toWound={{4,5,6,20,20,20,20,20,20,20},
                             {3,4,5,6,6,20,20,20,20,20},
                             {2,3,4,5,6,6,20,20,20,20},
                             {2,2,3,4,5,6,6,20,20,20},
                             {2,2,2,3,4,5,6,6,20,20},
                             {2,2,2,2,3,4,5,6,6,20},
                             {2,2,2,2,2,3,4,5,6,6},
                             {2,2,2,2,2,2,3,4,5,6},
                             {2,2,2,2,2,2,2,3,4,5},
                             {2,2,2,2,2,2,2,2,3,4}};
        int expResult = 0;
        int result = 0;
        Tables instance = new Tables();
        for(int i =0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
             expResult = toWound[i][j];
             result = instance.getToWound(i, j);
             assertEquals(expResult, result);
            }
        }
    }

}
