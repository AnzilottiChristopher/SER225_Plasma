package Screens;

import java.awt.Color; 

import java.awt.Font; //importing font for text
import java.awt.image.BufferedImage;

import Combat.combatRounds;
import Combat.combatStatus;
import Combat.combatant;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.FlagManager;
import Level.Map;
import Maps.CombatMap;
import SpriteFont.SpriteFont;

public class CombatScreen extends Screen {  

    
    private Font moveFont = new Font("Monospaced", Font.PLAIN, 11);  
    private Font nameFont = new Font("Monospaced", Font.BOLD, 20); 


   // private BufferedImage testEnemy;

    /*
     * having colors defined to reuse
     */
    private Color red = new Color(225, 0, 0); 
    private Color yellow = new Color(225, 225, 0); 
    private Color  green = new Color(0, 128, 0);    


    private Rectangle yellowRect = new Rectangle(40, 65, 250, 30); 

    protected ScreenCoordinator screenCoordinator;
    protected PlayLevelScreen playLevelScreen;
    protected SpriteFont goBackButton;
    protected int currentCombatItemHovered = 0; // current menu item being "hovered" over
    protected int combatItemSelected = -1;
    protected Map combatMap;
    protected int pointerLocationX, pointerLocationY;
    protected int keyPressTimer;
    protected KeyLocker keyLock = new KeyLocker();
    protected FlagManager flagManager;
    protected int moveSelected;
    protected combatRounds currentCombat;
    protected combatant playerCombatant;
    protected combatant enemyCombatant;
    protected combatStatus combatState;

    public CombatScreen(PlayLevelScreen playLevelScreen,combatant playerCombatant ,combatant enemyCombatant)
    {
        this.playLevelScreen=playLevelScreen;
        this.screenCoordinator=playLevelScreen.screenCoordinator;
        this.enemyCombatant = enemyCombatant;
        this.playerCombatant = playerCombatant;

        
        initialize();
    }

    
    //Initialize can set and reset the screen
    @Override
    public void initialize() {


        //temportary combatant object intitialization
         playerCombatant = new combatant(); //boomer
         enemyCombatant = new combatant("random"); //placeolder enemy    

        //end temp objects 

        //tracker for player health and enemy health, so rect adjusts accordingly 
        

        
        //initalize current combat 
        currentCombat = new combatRounds(playerCombatant, enemyCombatant);
       
        // goBackButton = new SpriteFont("Go Back", 200, 119, "Comic Sans", 30, new Color(49, 207, 240));
        // goBackButton.setOutlineColor(Color.black);
        // goBackButton.setOutlineThickness(3);

        combatState = combatStatus.PROGRESS;
        combatMap = new CombatMap();
        combatMap.setAdjustCamera(false);
        keyPressTimer = 0;
        combatItemSelected = -1;
        keyLock.lockKey(Key.SPACE);

        moveSelected = 0;

    }

    @Override
    public void update() {  

        

        combatState = currentCombat.updateCombat();

        //decrease timer as time progresses
        keyPressTimer--;

        if (keyPressTimer < 0)
        {
            keyPressTimer = 0;
        }

        //down key = 0
        if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 14;
            moveSelected = 0;
            
        }

        //left = 1
        if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
            keyPressTimer = 14;
            moveSelected = 1;
        }

        //up = move 2
        if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 14;
            moveSelected = 2;
        }

        //right =  move 3
        if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
            keyPressTimer = 14;
            moveSelected = 3;
        }

        //if space is pressed, do combat stuff 
        if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0 && moveSelected != 0) {
            keyPressTimer = 14;
            combatRounds.setMoveSelec(moveSelected);
            System.out.println("move selected :" + moveSelected);
            moveSelected = 0; //de-selects move

        }

        
        //Assuming this makes the player character appear or not
        combatMap.update(null);
        
        //This unlocks the key so the key could be pressed
        if(Keyboard.isKeyUp(Key.SPACE))
        {
            keyLock.unlockKey(Key.SPACE);
        }
        
        // //This checks if the key has been pressed and then returns to level screen
        // if(!keyLock.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE))
        // {
        //     combatItemSelected = currentCombatItemHovered;
        //     if(combatItemSelected == 0)
        //     {
        //         //This changes screen

        //         // makes screen coordinator switch to play level
        //         screenCoordinator.switchToPLayLevelScreen();
                
        //        // tells play level screen that combat is over and goes back to the play level screen
        //         playLevelScreen.goBackPlayLevelScreen();
                
        //     }
        // }

        
        //responds based on CombatState
        switch (combatState)
        {
            case WIN:
                // playLevelScreen.goBackPlayLevelScreen();
                // break;
            case LOSS:
            case TIE:

                playLevelScreen.goBackPlayLevelScreen();
                break;

            case PROGRESS:

                break;
        }


    }

    public combatStatus getState()
    {
        return combatState;
    }

    
    @Override
    public void draw(GraphicsHandler graphicsHandler) {   
        
        
        combatMap.draw(graphicsHandler);
        //goBackButton.draw(graphicsHandler);
       // graphicsHandler.drawRectangle(193, 119, 130, 55, new Color(49, 207, 240), 2);  

       

        //displaying move options and names 
        graphicsHandler.drawString(playerCombatant.moveName1(), 40, 490, moveFont, Color.WHITE); //drawing text in white  

        graphicsHandler.drawString(playerCombatant.moveName2(), 180, 460, moveFont, Color.WHITE); 

        graphicsHandler.drawString(playerCombatant.moveName3(), 310, 490, moveFont, Color.WHITE); 

        //player stuffs
        graphicsHandler.drawFilledRectangle(520, 400, 250, 40, new Color(225, 225, 255)); //white rect outline for player 
        graphicsHandler.drawString(playerCombatant.getName(), 530, 435, nameFont, Color.BLACK); //name text 
        graphicsHandler.drawFilledRectangle(520, 405, (playerCombatant.getHealth()*2), 10, green); //player healthbar   

        graphicsHandler.drawImage(enemyCombatant.getPlayerImage(), 180, 300);




        // playerCombatant.getHealth()*2 for the width doesn't work, it repeats a ton  
        //switch case function for evaluating health amounts? 
 
        //enemy stuffs
        graphicsHandler.drawFilledRectangle(40, 65, 250, 36, new Color(225, 225, 255)); //white rect outline 
        graphicsHandler.drawString(enemyCombatant.getName(), 40, 94, nameFont, Color.BLACK); //name text  
        graphicsHandler.drawFilledRectangle(40, 70, (enemyCombatant.getHealth()*2), 10, green); //enemy healthbar  
         //THIS DOES THE THING!!!!
       graphicsHandler.drawImage(enemyCombatant.getEnemyImage(), 450, 250);


        // if(playerCombatant.getHealth() >= 80 && enemyCombatant.getHealth() >= 50){
        //    // graphicsHandler.drawFilledRectangle(520, 405, 200, 10, green); //player healthbar  
        //     graphicsHandler.drawFilledRectangle(40, 70, 200, 10, green); //enemy healthbar  
        // } //else if (playerCombatant.getHealth() < 80 && playerCombatant.getHealth() >) 
        // else{
        //     graphicsHandler.drawFilledRectangle(40, 70, 100, 10, yellow); //enemy healthbar  
        // }

        //conditionals to redraw the rects so the selected one turns white
        if (moveSelected == 1)
        {
            //rect 1 
            graphicsHandler.drawRectangle(20, 470, 140, 30, new Color(200, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 440, 140, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,140, 30, new Color(49, 207, 240), 5);
        }

        else if (moveSelected == 2)
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 140, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 440, 140, 30, new Color(200, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,140, 30, new Color(49, 207, 240), 5);
        }
        else if (moveSelected == 3)
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 140, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 440, 140, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470, 140, 30, new Color(200, 207, 240), 5);
        }
        else
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 140, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 440, 140, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,140, 30, new Color(49, 207, 240), 5);
        } 

        

    } 

    // public void healthShfit(int amount) {
    //     if(amount <= 100 && amount>=70){
    //         yellowRect.draw(null);
    //     }
    // }
    
}
