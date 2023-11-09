package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the guide screen
public class GuideScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    
    protected SpriteFont guideTitle;
    protected SpriteFont arrows; 
    protected SpriteFont sprint ;
    protected SpriteFont space;  
    protected SpriteFont combatGuide;
    protected SpriteFont arrSelect; 
    protected SpriteFont spaceAttk;

    protected SpriteFont returnInstructionsLabel;

    Music music = new Music();

    public GuideScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false); 

        guideTitle = new SpriteFont("HOW TO PLAY!", 15, 7, "Times New Roman", 30, Color.white);
        arrows = new SpriteFont("* ARROW KEYS --  Move Up, Down, Left, Right! ", 100, 70, "Times New Roman", 25, Color.white); 
        sprint = new SpriteFont("* HOLD SHIFT --  Sprint!", 100, 120, "Times New Roman", 25, Color.white); 
        space = new SpriteFont("* SPACE --  Interact/Select! ", 100, 160, "Times New Roman", 25, Color.white);  
        
        combatGuide = new SpriteFont("WHILE IN COMBAT! ", 100, 260, "Times New Roman", 30, Color.white);  
        arrSelect = new SpriteFont("* ARROWS --  Hover over a Move!", 110, 300, "Times New Roman", 25, Color.white);
        spaceAttk = new SpriteFont("* SPACE --  To Use selected Move! ", 110, 340, "Times New Roman", 25, Color.white);

        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, "Times New Roman", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        music.setCount(1);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            music.stopLoop();
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        guideTitle.draw(graphicsHandler);
        arrows.draw(graphicsHandler); 
        sprint.draw(graphicsHandler); 
        combatGuide.draw(graphicsHandler); 
        arrSelect.draw(graphicsHandler); 
        spaceAttk.draw(graphicsHandler);  
        space.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
