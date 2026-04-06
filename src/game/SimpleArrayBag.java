package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  For this class bag is implemented as an array and its methods 
 *  
 *  @param <T>
 *      It is the type of the object
 * 
 *  @author viren
 *  @version 24-Feb-2025
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T>
{
    private T[] bag; 
    private static final int MAX = 18;
    private int numberOfEntries;
   
    // ----------------------------------------------------------
    /**
     * This is instantiating the number of bags and the number of entries 
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag()
    {
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;       
        this.numberOfEntries = 0; 
    }
    
    /** 
     * This is for identifying the current size of the bag 
     * 
     * @return
     *   The current size of bag 
     */
    @Override
   public int getCurrentSize()
    {
        return this.numberOfEntries; 
    }
    
    /**
     * This will tell us if the bag is empty 
     * 
     * @return
     *   bag is empty 
      */
    @Override
    public boolean isEmpty()
    { 
        return this.numberOfEntries == 0; 
    }
   
    /**
     * This is to add an entry
     * 
     * @param arg
     *   this is the entry that gets added 
     *   
     * @return 
     *   it will return true if the entry is added 
     */
    @Override
    public boolean add(T arg)
    {
        if (arg == null)
        {
            return false; 
        }
       
        if (this.numberOfEntries < 18)
        {
            this.bag[this.numberOfEntries] = arg;
            this.numberOfEntries++; 
            return true;
        }
        return false;
    }
   
    /**
     * This is to select an item from the bag and return it provided the bag is 
     * not empty
     * 
     * @reutrn
     *   The random item from the bag 
     */
   
    @Override
    public T pick()
    {
        if (this.isEmpty())
        {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        
        return bag[index];
    }
   
    /**
     * This is the helper for remove function wherein it will identify if there 
     * is a similar an entry in the bag is equal to arg 
     * 
     * @return
     * It will return the index at which the same entry is found if not found 
     * it will return -1
      */
    private int getIndexOf(T arg)
    {
        for (int i = 0; i < this.numberOfEntries; i++)
        {
            if (bag[i].equals(arg))
            {
                return i; 
            }
        }
        return -1; 
    }
       
    /**
     * This method will be used to remove the entry 
     * 
     * @param arg
     *   This is the value that will be removed 
     * @return
     *   if the entry is removed it will true, if not then it will 
     *   return false  
     */
    @Override
    public boolean remove(T arg)
    {
        if (arg == null)
        {
            return false; 
        }
        
        int i = this.getIndexOf(arg);
        if (i == -1)
        {
            return false;
        }
             
        bag[i] = bag[this.numberOfEntries - 1 ]; 
        bag[this.numberOfEntries - 1] = null; 
        this.numberOfEntries--; 
        return true; 
    }
   

}
