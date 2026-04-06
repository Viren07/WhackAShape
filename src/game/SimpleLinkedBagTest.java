package game;

import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  This is to test the methods used in Simple Linked Bag class
 * 
 *  @author viren
 *  @version 25-Feb-2025
 */
public class SimpleLinkedBagTest extends student.TestCase
{
    private SimpleLinkedBag<Integer> emptyBag;
    private SimpleLinkedBag<Integer> fullBag;
    private SimpleLinkedBag<String> bag;
    
    /**
     * This is the setup which will be used for the test cases 
     */
    public void setUp()
    {
        this.emptyBag = new SimpleLinkedBag<Integer>();
        this.fullBag = new SimpleLinkedBag<Integer>();
        bag = new SimpleLinkedBag<>();
        
        
        for (int i = 0; i < 18; i++) 
        {
            this.fullBag.add(i);
        }
    }
    
    // ----------------------------------------------------------
    /**
     * This tests the getCurrentSize method
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
     * This is to test the isEmpty method. 
     */
    public void testIsEmpty()
    {
        assertTrue(this.emptyBag.isEmpty());
        assertFalse(this.fullBag.isEmpty());
    }
    
    // ----------------------------------------------------------
    /**
     * This will test the add method. 
     */
    public void testAdd()
    {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1);
        assertFalse(this.emptyBag.add(null));
        assertEquals(this.emptyBag.getCurrentSize(), 1);
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
        
        TestableRandom.setNextInts(0);
        assertEquals("fish", bag.pick());
        
        TestableRandom.setNextInts(1);
        assertEquals("donkey", bag.pick());
        
        TestableRandom.setNextInts(2);
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
