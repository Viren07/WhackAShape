package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  For this class bag is implemented as a linked list and its methods
 *  @param <T>
 *      It is the type of the object
 *  @author viren
 *  @version 25-Feb-2025
 */
class SimpleLinkedBag<T> implements SimpleBagInterface<T>
{
    private Node<T> firstNode;
    private int numberOfEntries;
    
    
    // ----------------------------------------------------------
    /**
     * This is instantiating the first node to null and number of entries to 1
     */
    public SimpleLinkedBag()
    {
        firstNode = null; 
        numberOfEntries = 0; 
    }
    
    
    /** 
     * This is for identifying the current size of the linked list 
     * 
     * @return
     *   The current size of linked list  
     */
    @Override
    public int getCurrentSize()
    {
        return this.numberOfEntries; 
    }
    
    
    /**
     * This will tell us if the linked list is empty 
     * 
     * @return
     *   linked list is empty 
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
        
        Node<T> newNode = new Node<T>(arg);
        newNode.setNext(firstNode);
        this.firstNode = newNode; 
        this.numberOfEntries++;
            
        return true;
    }

    /**
     * This is to select an item from the linked list and return it provided 
     * the linked list is not empty
     * 
     * @reutrn
     *   The random item from the linked list 
     */
    @Override
    public T pick()
    {
        if (this.isEmpty())
        {
            return null;
        }
        
        int index = new TestableRandom().nextInt(this.numberOfEntries);
        
        Node<T> currentNode = firstNode; 
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.getNext(); 
        }
        return currentNode.getData();  
    }
    
    // ----------------------------------------------------------
    /**
     * This is get the node of an entry
     * @param arg
     *      This is the item that is to be found 
     *      
     * @return
     *      The node of the item
     */
    public Node<T> getReferenceTo(T arg)
    {
        if (arg == null) 
        {
            return null;
        }
        
        boolean found = false;
        Node<T> currentNode = firstNode;
        
        while (!found && (currentNode != null))
        {
            if (arg.equals(currentNode.getData()))
            {
                found = true; 
            }
            else
            {
                currentNode = currentNode.getNext(); 
            }
        } 
        return currentNode;
    }

    /**
    * This method will be used to remove the entry 
    * 
    * @param arg
    *   This is the value that will be removed 
    * @return
    *   if the entry is removed it will true, if not then it will return false  
    */
    @Override
    public boolean remove(T arg)
    {
        if (getReferenceTo(arg) == null)
        {
            return false; 
        }
        
        Node<T> node = getReferenceTo(arg);
        node.setData(firstNode.getData());
        numberOfEntries--; 
            
        return true;
    }
}
