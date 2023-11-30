package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the win level screen
public class TryAgainScreen extends Screen {
    protected SpriteFont faintMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;

    public TryAgainScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    /*
     * maybe think of a method that takes in a flag (unset? due to a battle with an enemy has occured/started, like "AlexBossStart") 
     * and have THAT set the flag back, so that very fight can be reset
     */
    @Override
    public void initialize() {
        faintMessage = new SpriteFont("You Fainted... Continue..?", 200, 239, "Comic Sans", 30, Color.white);
        instructions = new SpriteFont("Press SPACE to Continue or ESC to go back to the Main Menu", 120, 279,"Comic Sans", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {  
            //System.out.println("Calling goBackToCombat");
            playLevelScreen.goBackToCombat();; //reset to combat battle  
            //System.out.println("After the call");
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        faintMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
