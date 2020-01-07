/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author st52520
 */
public class EventTest {
    
    public EventTest() {
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
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Event event = new Event(new Date(117, 6, 1), "1-1");
        Event instance = null;
        int expResult = 0;
        int result = event.compareTo(event);
        assertEquals(expResult, result);
       
    }    

    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Event event = new Event(new Date(117, 6, 1), "1-1");
        
        boolean expResult = true;
        boolean result = event.equals(event);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDate method, of class Event.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Event instance = new Event(new Date(117, 6, 1), "1-1");
        Date expResult = new Date(117, 6, 1);
        Date result = instance.getDate();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = new Event(new Date(117, 6, 1), "1-1");
        String expResult = "1-1";
        String result = instance.getTitle();
        assertEquals(expResult, result);        
    }   

    
}
