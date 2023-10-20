package Screens;

import java.awt.Color;

import Combat.combatRounds;
import Combat.combatStatus;
import Combat.combatant;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
import Level.Map;
import Maps.CombatMap;
import SpriteFont.SpriteFont;

public class CombatScreen extends Screen {
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
        //combatant playerCombatant = new combatant();
        //end temp objects
        
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
        graphicsHandler.drawRectangle(193, 119, 130, 55, new Color(49, 207, 240), 2);


        if (moveSelected == 1)
        {
            //rect 1
            graphicsHandler.drawRectangle(100, 450, 55, 55, new Color(200, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 400, 55, 55, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(220, 450, 55, 55, new Color(49, 207, 240), 5);
        }

        else if (moveSelected == 2)
        {
            //rect 1
            graphicsHandler.drawRectangle(100, 450, 55, 55, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 400, 55, 55, new Color(200, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(220, 450, 55, 55, new Color(49, 207, 240), 5);
        }
        else if (moveSelected == 3)
        {
            //rect 1
            graphicsHandler.drawRectangle(100, 450, 55, 55, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 400, 55, 55, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(220, 450, 55, 55, new Color(200, 207, 240), 5);
        }
        else
        {
            //rect 1
            graphicsHandler.drawRectangle(100, 450, 55, 55, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(160, 400, 55, 55, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(220, 450, 55, 55, new Color(49, 207, 240), 5);
        }

    }
    
}
