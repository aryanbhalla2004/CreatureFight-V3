/**
 * TODO (16): Add an assignment comment block below
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class CreatureWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    private int turnNumber;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    
    //TODO (1): Declare a boolean instance variable called playerOneMenusAdded
    private boolean playerOneMenusAdded;
    
    //TODO (2): Declare a boolean instance variable called playerTwoMenusAdded
    private boolean playerTwoMenusAdded;
    
    private String playerOneName = "1";
    private String playerTwoName = "2";
    

    /**
     * Default constructor for objects of class CreatureWorld.
     * 
     * @param There are no parameters
     * @return an object of class CreatureWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 400x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);

        prepareCreatures();

        turnNumber = 0;
        
        //TODO (3): Initialize playerOneMenusAdded and playerTwoMenusAdded to false;
        playerOneMenusAdded = false;
        playerTwoMenusAdded = false;
        
        Greenfoot.start();
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parametersa
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);

        if( turnNumber == 0 )
        {
            playerOneName = JOptionPane.showInputDialog( "Please enter your name, Player One:", null );
            playerTwoName = JOptionPane.showInputDialog( "Please enter your name, Player Two:", null );
            turnNumber = 1;
        }
        else if( turnNumber == 1 ) 
        {
            showText( "Your turn, " + playerOneName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        else
        {
            showText( "Your turn, " + playerTwoName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        //TODO (4): If player one's menus have not been added...
        if(playerOneMenusAdded == false)
        {
            //TODO (5): Initialize oneFightMenu to be a new Menu object with parameters " Fight ", " Scratch \n Flamethrower ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands object
            oneFightMenu = new Menu(" Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
            
            //TODO (6): Initialize oneSwitchMenu to be a new Menu object with parameters " Switch ", " Golem \n Ivysaur ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands object
            oneFightMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            
            //TODO (7): Add the oneFightMenu at an x location of 173 and a y location of 100 pixels less than the height
            addObject(oneFightMenu, 173, getHeight() -100); 
            
            //TODO (8): Add the oneSwitchMenu at an x location of 241 and a y location of 100 pixels less than the height
            addObject(oneSwitchMenu, 241, getHeight() -100); 
            
            //TODO (9): Set the player one menus added variable to represent that the menus have been added
            playerOneMenusAdded = true;
        }
         //TODO (10): If player two's menus have not been added...
        if(playerTwoMenusAdded == false)
        {
            //TODO (11): Initialize twoFightMenu to be a new Menu object with parameters " Fight ", " Tackle \n Thunderbolt ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands object
            twoFightMenu = new Menu(" Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
            
            //TODO (12): Initialize twoSwitchMenu to be a new Menu object with parameters " Switch ", " Lapras \n Pidgeot ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands object
            twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());

            //TODO (13): Add the twoFightMenu at an x location of 135 and a y location of 75
            addObject(twoFightMenu, 135, 75);
            
            //TODO (14): Add the twoSwitchMenu at an x location of 199 and a y location of 75
            addObject(twoSwitchMenu, 199, 75);
            
            //TODO (15): Set the player two menus added variable to represent that the menus have been added
            playerTwoMenusAdded = true;
        }
            
        
       
        
            
            
            

        if( playerOneCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            showText(playerTwoName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }

        if( playerTwoCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            showText(playerOneName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }

    /**
     * prepareCreatures adds the creatures for both players to the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {
        addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);

        addObject( playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
    }
    
    /**
     * getPlayerOne returns player one's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }

    /**
     * getPlayerTwo returns player two's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }

    /**
     * getTurnNumber returns a number that represents which player's
     * turn it is (either player 1 or player 2)
     * 
     * @param There are no parameters
     * @return An integer that represents which player's turn it is
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }
    
    /**
     * setTurnNumber changes the turn number to the appropriate
     * number for which player's turn it is
     * 
     * @param turn is the number that represents which player's turn it is
     * @return Nothing is returned
     */
    public void setTurnNumber( int turn )
    {
        turnNumber = turn;
    }

}
