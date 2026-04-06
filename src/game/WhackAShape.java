package game;

import cs2.*;
import java.awt.Color;
import student.TestableRandom;
import bag.SimpleBagInterface;

// -------------------------------------------------------------------------
/**
 *  This is the whack a shape game 
 * 
 *  @author viren
 *  @version 25-Feb-2025
 */
public class WhackAShape
{
    private SimpleBagInterface<Shape> bag; 
    private Window window;
    private TestableRandom randomGenerator; 
    private Button quitButton; 
    
    private static final String[] shapes = { "red circle", "blue circle",
        "red square", "blue square" };
    
    // ----------------------------------------------------------
    /**
     * This is used to create a random sized bag and fill the shapes with colors
     * and then it also sets up the window frame    
     */
    public WhackAShape()
    {
        this.bag = new SimpleLinkedBag<Shape>(); 
        this.window = new Window();
        
        this.randomGenerator = new TestableRandom();
        int bagSize = 6 + randomGenerator.nextInt(9);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.SOUTH);

        int size = this.randomGenerator.nextInt(6) + 7;
        while (bag.getCurrentSize() < size) {
            bag.add(this.buildShape(shapes[this.randomGenerator.nextInt
                                           (shapes.length)]));
        }

        window.addShape(bag.pick());
    }
    
    // ----------------------------------------------------------
    /**
     * This is used for setting up the window frame and to initialize the bag 
     * with the shapes and colors. 
     * 
     * @param input
     *      This is the list of shapes and colors 
     */
    public WhackAShape(String[] input)
    {
        this.bag = new SimpleLinkedBag<Shape>();
        this.window = new Window();
        
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.SOUTH);
        
        for (String a : input) 
        {
            try {
                bag.add(this.buildShape(a));
            }
            catch (IllegalArgumentException e) 
            {
                e.printStackTrace();
            }
        }
        this.window.addShape(bag.pick());
    }
    
    // ----------------------------------------------------------
    /**
     * This will return the window for the game 
     * @return
     *      the window for the game 
     */
    public Window getWindow() 
    {
        return this.window;
    }
    
    // ----------------------------------------------------------
    /**
     * This returns the bag of shapes 
     * @return
     *      the bag that is returned 
     */
    public SimpleBagInterface<Shape> getBag() 
    {
        return this.bag;
    }
    
    // ----------------------------------------------------------
    /**
     * This will close the window when quit is clocked 
     * @param button
     *      This is the button that will be clicked 
     */
    public void clickedQuit(Button button) 
    {
        System.exit(0);
    }
    
    // ----------------------------------------------------------
    /**
     * This is what will happen when the shape is clicked 
     * @param shape
     *      this is the shape that is clicked 
     */
    public void clickedShape(Shape shape)
    {
        window.removeShape(shape);
        this.bag.remove(shape);
        Shape nextShape = this.bag.pick();
        
        if (nextShape == null)
        {
            TextShape text = new TextShape(0, 0, "You Win!");
            text.setX(this.window.getGraphPanelWidth() / 2 - text.getWidth() 
                / 2);
            text.setY(this.window.getGraphPanelHeight() / 2 - text.getHeight() 
                / 2);
            
            this.window.addShape(text);
            this.window.repaint(); 
        }
        else
        {
            this.window.addShape(nextShape);
        }
    }
    
    /**
     * This is used to build the shape
     * 
     * @param string
     *      string tells us which shape it is 
     * @return 
     *      this is the shape that is returned
     */
    private Shape buildShape(String input)
    {
        int size = 100 + randomGenerator.nextInt(101);
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size); 
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size); 
        
        if (input == null) 
        {
            throw new IllegalArgumentException();
        }
        
        Color color; 
        
        if (input.contains("red")) 
        {
            color = Color.RED;
        } 
        else if (input.contains("blue")) 
        {
            color = Color.BLUE;
        } 
        else 
        {
            throw new IllegalArgumentException();
        }
        
        Shape currentShape; 
        if (input.contains("circle")) 
        {
            currentShape = new CircleShape(x, y, size, color);
        } 
        else if (input.contains("square")) 
        {
            currentShape = new SquareShape(x, y, size, color);
        } 
        else 
        {
            throw new IllegalArgumentException();
        }
        
        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
}
