package game;
// -------------------------------------------------------------------------
/**
 *  This is used to run the Project 
 * 
 *  @author viren
 *  @version 25-Feb-2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Useless Class
     */
    public ProjectRunner()
    {
        
    }
    
    // ----------------------------------------------------------
    /**
     * This is to run the project 
     * @param args
     *      Command Line Argument
     */
    public static void main(String[] args)
    {
        if (args.length > 0) 
        {
            new WhackAShape(args);
        }
        else 
        {
            new WhackAShape();
        }
    }

}
