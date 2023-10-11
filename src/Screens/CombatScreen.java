package Screens;

import java.awt.Color;

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

    public CombatScreen(PlayLevelScreen playLevelScreen)
    {
        this.playLevelScreen=playLevelScreen;
        this.screenCoordinator=playLevelScreen.screenCoordinator;
        
        initialize();
    }

    
    //Initialize can set and reset the screen
    @Override
    public void initialize() {
        
       
        goBackButton = new SpriteFont("Go Back", 200, 119, "Comic Sans", 30, new Color(49, 207, 240));
        goBackButton.setOutlineColor(Color.black);
        goBackButton.setOutlineThickness(3);
        combatMap = new CombatMap();
        combatMap.setAdjustCamera(false);
        keyPressTimer = 0;
        combatItemSelected = -1;
        keyLock.lockKey(Key.SPACE);

    }

    @Override
    public void update() {
        
        //Assuming this makes the player character appear or not
        combatMap.update(null);
        
        //This unlocks the key so the key could be pressed
        if(Keyboard.isKeyUp(Key.SPACE))
        {
            keyLock.unlockKey(Key.SPACE);
        }
        
        //This checks if the key has been pressed and then returns to level screen
        if(!keyLock.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE))
        {
             combatItemSelected = currentCombatItemHovered;
            if(combatItemSelected == 0)
            {
                //This changes screen

                // makes screen coordinator switch to play level
                screenCoordinator.switchToPLayLevelScreen();
                
               // tells play level screen that combat is over and goes back to the play level screen
                playLevelScreen.goBackPlayLevelScreen();

                
            }
        }

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        combatMap.draw(graphicsHandler);
        goBackButton.draw(graphicsHandler);
        graphicsHandler.drawRectangle(193, 119, 130, 55, new Color(49, 207, 240), 2);
    }
    
}
