package game;

import cs2.Shape;

// -------------------------------------------------------------------------
/**
 *  This is the bag interface for shapes 
 *  @param <T>
 *      Type of item in the bag  
 * 
 *  @author viren
 *  @version 25-Feb-2025
 */
public interface SimpleBagInterface<T> 
{

    // ----------------------------------------------------------
    /**
     * This removes a shape from the bag 
     * @param shape
     *      The shape that is removed 
     */
    void remove(Shape shape);
    

    // ----------------------------------------------------------
    /**
     * This is for picking a random shape 
     * @return 
     *      A random shape 
     */
    Shape pick();
    

    // ----------------------------------------------------------
    /**
     * This will add a shape to the bag 
     * @param buildShape
     *      this is the shape that is to be added 
     */
    void add(Shape buildShape);

    
    // ----------------------------------------------------------
    /**
     * This is to find the number of shapes in the bag currently 
     * @return
     *      The number of shapes
     */
    int getCurrentSize();

    
}
