package calendar;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TreeTest {

    public TreeTest() {
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
     * Test of add method, of class Tree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TestNode data = new TestNode("test");
        EventSet ev = mock(EventSet.class);
        Tree instance = new Tree();
        instance.add(ev);
        when(ev.compareTo(any())).then((iom) -> {
            return 1;
        });
        assertTrue(instance.contain(ev));
    }

    /**
     * Test of erase method, of class Tree.
     */
    @Test
    public void testErase() {
        System.out.println("erase");
        TestNode data = new TestNode("test");
        Tree instance = new Tree();
        instance.add(data);
        instance.erase(data);
        assertFalse(instance.contain(data));
    }

    /**
     * Test of contain method, of class Tree.
     */
    @Test
    public void testContain() {
        System.out.println("contain");
        TestNode n = new TestNode("test");
        Tree instance = new Tree();
        boolean expResult = false;
        boolean result = instance.contain(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Tree.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Object data = null;

        TestNode n = new TestNode("test");

        Tree instance = new Tree();
        Object expResult = null;
        Object result = instance.getData(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class Tree.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Tree instance = new Tree();
        EventSet ev = mock(EventSet.class);
        instance.add(ev);
        
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Tree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tree instance = new Tree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class TestNode implements Comparable {

        String name;

        public TestNode(String name) {
        }

        @Override
        public int compareTo(Object t) {
            return name.compareTo((String) t);
        }

    }

}
