package Screens;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.CombatMap;
import SpriteFont.SpriteFont;

public class CombatScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont goBackButton;
    protected int currentCombatItemHovered = 0; // current menu item being "hovered" over
    protected int combatItemSelected = -1;
    protected Map combatMap;

    //This constructor is used to help change the screens
    public CombatScreen(ScreenCoordinator screenCoordinator)
    {
        this.screenCoordinator = screenCoordinator;
    }
    
    //Initialize can set and reset the screen
    @Override
    public void initialize() {
        goBackButton = new SpriteFont("Go Back", 200, 119, "Comic Sans", 30, new Color(49, 207, 240));
        goBackButton.setOutlineColor(Color.black);
        goBackButton.setOutlineThickness(3);
        combatMap = new CombatMap();

    }

    @Override
    public void update() {
       
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
      
    }
    
}
