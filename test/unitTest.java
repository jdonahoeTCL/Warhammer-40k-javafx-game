/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
public class unitTest {
    
    public unitTest() {
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
     * Test of resolveCloseCombat method, of class unit.
     */
    @Test
    public void testResolveCloseCombat() {
        System.out.println("resolveCloseCombat");
        turnManager tM = new turnManager();
        Pane root = new Pane();
        unit instance = new unitImpl();
        instance.resolveCloseCombat(tM, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attackResolveNoOrder method, of class unit.
     */
    @Test
    public void testAttackResolveNoOrder() {
        System.out.println("attackResolveNoOrder");
        unit first = null;
        unit second = null;
        Pane root = null;
        unit instance = new unitImpl();
        instance.attackResolveNoOrder(first, second, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attackResolveInOrder method, of class unit.
     */
    @Test
    public void testAttackResolveInOrder() {
        Weapon wp = new WeaponImpl("y", 1,2,3,true, true, true, true,true,3);
        System.out.println("attackResolveInOrder");
        Circle c1 = new Circle (10.0, 10.0, 2.0);
        Circle c2 = new Circle (10.0, 10.0, 2.0);
        Circle c3 = new Circle (10.0, 10.0, 2.0);
        
        unit first = new unitImpl("s",1, 2, 3, 4,5,6 ,7,8,9,wp,wp,true,true,true,true ,c1,true);
        unit second = new unitImpl("s",1, 2, 3, 4,5,6 ,7,8,9,wp,wp,true,true,true,true ,c2,true);
        Pane root = new Pane();
        boolean firstHit = false;
        unit instance = new unitImpl("s",1, 2, 3, 4,5,6 ,7,8,9,wp,wp,true,true,true,true ,c3,true);
        instance.attackResolveInOrder(first, second, root, firstHit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shoot method, of class unit.
     */
    @Test
    public void testShoot() {
        System.out.println("shoot");
        turnManager tM = null;
        int Distance = 0;
        D6 d6 = null;
        Tables t = null;
        Pane root = null;
        unit instance = new unitImpl();
        instance.shoot(tM, Distance, d6, t, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of charge method, of class unit.
     */
    @Test
    public void testCharge() {
        System.out.println("charge");
        turnManager tM = null;
        int distance = 0;
        Pane root = null;
        unit instance = new unitImpl();
        instance.charge(tM, distance, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPos method, of class unit.
     */
    @Test
    public void testSetPos() {
        System.out.println("setPos");
        double x = 0.0;
        double y = 0.0;
        unit instance = new unitImpl();
        instance.setPos(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosX method, of class unit.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        unit instance = new unitImpl();
        double expResult = 0.0;
        double result = instance.getPosX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosY method, of class unit.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        unit instance = new unitImpl();
        double expResult = 0.0;
        double result = instance.getPosY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of die method, of class unit.
     */
    @Test
    public void testDie() {
        System.out.println("die");
        Pane root = new Pane();
        unit instance = new unitImpl();
        instance.die(root);
      
    }

    /**
     * Test of handleMouseClick method, of class unit.
     */
    @Test
    public void testHandleMouseClick() {
        System.out.println("handleMouseClick");
        MouseEvent e = null;
        turnManager tM = null;
        Circle movementAssist = null;
        Pane root = null;
        Line targetingAssist = null;
        unit instance = new unitImpl();
        instance.handleMouseClick(e, tM, movementAssist, root, targetingAssist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class unit.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        unit instance = new unitImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class unitImpl extends unit {
        
    String name;
    int WS;
    int BS;
    int S;//unit's strength
    int T;//unit's toughness
    int W;//unit's wounds 
    int I;//Unit's initiave
    int A;//unit's number of close combat attacks
    int Ld;//unit's leadership
    int Sv;//unit's ARMOR save
    Weapon gun;
    Weapon melee;
    boolean shot;
    boolean moved;
    boolean charged;
    boolean team;
    Circle rep;
    boolean alive;
    
       public unitImpl () {
            
       }
       public unitImpl ( String wx, int a, int b, int c, int d,int e,int f , int h,int i, int j,Weapon m,Weapon n, boolean o , boolean p,boolean q ,boolean r,Circle w1,boolean t) {
          
         
    WS = a;//unit's weaponskill
    BS = b;//unit's ballistic skill
    S = c;//unit's strength
    T = d;//unit's toughness
    W = e;//unit's wounds 
    I = f;//Unit's initiave
    A = h;//unit's number of close combat attacks
    Ld = i;//unit's leadership
    Sv = j;
    gun =m;
    melee = n;
    shot = o;
    moved = p;
    charged = q;
    team =r;
    alive =t;
    name =wx;
    rep = w1;
           
           
       }
    }
       public class WeaponImpl extends Weapon{
           
          
    String name;//weapon's name
    int Range;//weapon's range 
    int S;//weapon's strength
    int AP;//weapon ap AP=0 if unit has no AP
    boolean isRapidFire;
    boolean isMelee;
    boolean isMelta;
    boolean isAssault;
    boolean isHeavy;
    int Shots;
           
       public WeaponImpl( String we, int b,int c,int d,boolean e, boolean f, boolean g, boolean h,boolean i,int j ) {
               
             name = we;
               Range =b;
               S = c;
               AP = d;
                isRapidFire =e;
    isMelee =f;
    isMelta=g;
    isAssault =h;
    isHeavy =i;
    Shots =j;
          
               
           }
                   
           
       
       }
    
    
}
