package game;

import static org.junit.Assert.*;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  This is the test case for all the methods in the SimpleArrayBag class
 * 
 *  @author viren
 *  @version 25-Feb-2025
 */ 
public class SimpleArrayBagTest extends student.TestCase  
{
    private SimpleArrayBag<Integer> emptyBag;
    private SimpleArrayBag<Integer> fullBag;
    private SimpleArrayBag<String> bag;
  
    /**
     * This is the setup for the test cases 
     */
    public void setUp()
    {
        this.emptyBag = new SimpleArrayBag<Integer>();
        this.fullBag = new SimpleArrayBag<Integer>();
        bag = new SimpleArrayBag<>();
            
        for (int i = 0; i < 18; i++) 
        {
            this.fullBag.add(i);
        }
        
    }
    
    // ----------------------------------------------------------
    /**
     * This is testing the getCurrentSize method 
     */
    public void testGetCurrentSize()
    {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1);
        this.emptyBag.remove(1);
        assertEquals(this.emptyBag.getCurrentSize(), 0);
    }
    
    
    // ----------------------------------------------------------
    /**
     * this tests the isEmpty method 
     */
    public void testIsEmpty()
    {
        assertTrue(this.emptyBag.isEmpty());
        assertFalse(this.fullBag.isEmpty());
    }
    
    
    // ----------------------------------------------------------
    /**
     * This tests the add method
     */
    public void testAdd()
    {
        assertTrue(this.emptyBag.isEmpty()); 
        assertEquals(this.emptyBag.getCurrentSize(), 0);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1);
        assertFalse(this.emptyBag.add(null));
        assertEquals(this.emptyBag.getCurrentSize(), 1);
        assertFalse(this.fullBag.add(1));
    }
    
    // ----------------------------------------------------------
    /**
     * This tests the pick method
     */
    public void testPick()
    {
        assertNull(this.emptyBag.pick());

        bag.add("monkey");
        bag.add("donkey");
        bag.add("fish");
        
        TestableRandom.setNextInts(0, 47, 7);
        assertEquals("monkey", bag.pick()); 

    }
    
    // ----------------------------------------------------------
    /**
     * This tests the remove method
     */
    public void testRemove()
    {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1);
        assertTrue(this.emptyBag.remove(1));
        assertEquals(this.emptyBag.getCurrentSize(), 0);
        this.emptyBag.add(1); 
        this.emptyBag.add(2);
        this.emptyBag.add(3);
        assertFalse(this.emptyBag.remove(null));
        assertFalse(this.emptyBag.remove(20));
    }
}
