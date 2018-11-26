import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private String value;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    private boolean border = false;
    
    /**
     * Constructor for objects of class TextBox
     * 
     * @param message is the text that will be displayed in the text box
     * @param size is the text size that will be used for the text in the text box
     * @param isBordered states whether the text box is bordered or not
     * @param fg is the foreground color (or the color of the text) of the text box
     * @param bg is the background color of the text box
     * @return An object of type of TextBox
     */
    public TextBox(String message, int size, boolean isBordered, Color fg, Color bg)
    {
        value = message;
        fontSize = size;
        foreground = fg;
        background = bg;
        border = isBordered;
        display();
    }
    
    /**
     * display will create the image for the TextBox based on the 
     * properties already defined by the variables inside the TextBox
     * class so that it can be shown in the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void display()
    {
        setImage( new GreenfootImage(value, fontSize, foreground, background) );
        
        if(border == true)
        {
            getImage().setColor(Color.BLACK);
            getImage().drawRect(0, 0, getImage().getWidth() - 1, getImage().getHeight()-1);
        }
    }
    
    /**
     * setText changes the text that is displayed inside the text box
     * 
     * @param message is the new text that will be displayed in the text box
     * @return Nothing is returned
     */
    public void setText(String message)
    {
        value = message;
       
        display();
    }
    
    /**
     * getText returns the text that is displayed in the text box
     * for use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return A String that represents the text inside the text box
     */
    public String getText()
    {
        return value;
    }
}
