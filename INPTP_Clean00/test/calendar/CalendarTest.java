package calendar;

import java.util.Date;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarTest {

    public CalendarTest() {
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
     * Test of addEvent method, of class Calendar.
     */
    @Test
    public void testAddEvent1() {
        System.out.println("addEvent");
        Event event = new Event(new Date(117, 6, 1), "1-4");
        Calendar instance = new Calendar();
        instance.addEvent(event);
        assertTrue(instance.iterator().hasNext());
    }

    @Test
    public void testAddEvent2() {
        System.out.println("addEvent");
        Event event = new Event(new Date(117, 6, 1), "1-4");
        Event event1 = new Event(new Date(117, 5, 2), "2-5");
        Calendar instance = new Calendar();
        instance.addEvent(event);
        instance.addEvent(event1);
        assertTrue(instance.iterator().hasNext());
        assertEquals(new Date(117, 5, 2), instance.iterator().next().date);
    }

    /**
     * Test of eventsList method, of class Calendar.
     */
    @Test
    public void testEventsList() {
        System.out.println("eventsList");
        Date date = new Date(117, 6, 1);
        Calendar instance = new Calendar();
        instance.addEvent(new Event(new Date(117, 6, 1), "1-1"));

        EventSet result = instance.eventsList(date);

        assertEquals(date, result.date);
    }

    @Test
    public void testEventsList1() {
        System.out.println("eventsList1");
        Date date = new Date(117, 6, 1);
        Calendar instance = new Calendar();
        instance.addEvent(new Event(new Date(117, 6, 1), "1-1"));
        EventSet result = instance.eventsList(date);

        assertEquals(1, result.eventSet.size());
    }

    /**
     * Test of deleteAll method, of class Calendar.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        Date date = new Date(117, 6, 1);
        Calendar instance = new Calendar();
        instance.addEvent(new Event(new Date(117, 6, 1), "1-1"));
        instance.deleteAll(date);
        assertFalse(instance.iterator().hasNext());        
    }

    /**
     * Test of iterator method, of class Calendar.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Calendar instance = new Calendar();
        Iterator<EventSet> expResult = null;
        Iterator<EventSet> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
