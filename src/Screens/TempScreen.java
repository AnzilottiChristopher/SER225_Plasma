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
import Maps.TempMap;
import SpriteFont.SpriteFont;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import Screens.PlayLevelScreen;
import Scripts.TestMap.JukeboxScript;
import Utils.Direction;
import Utils.Point;

public class TempScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Player player;
    protected PlayLevelScreen playLevelScreen;
    protected TempScreenState tempScreenState;
    protected SpriteFont goBackButton;
    protected Map map;
    //protected PlayLevelScreenState playLevelScreenState;
    protected int pointerLocationX, pointerLocationY;
    protected int keyPressTimer;
    protected KeyLocker keyLock = new KeyLocker();
    protected FlagManager flagManager;

    public TempScreen(PlayLevelScreen playLevelScreen)
    {
        this.playLevelScreen=playLevelScreen;
        this.screenCoordinator=playLevelScreen.screenCoordinator;
        initialize();
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        flagManager=new FlagManager();
        flagManager.addFlag("TeleportedBack", false);

        //setup map
        this.map=new TempMap();
        map.setFlagManager(flagManager);

        //setting up player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        //this.player.setLocation(5000, 0);
        //this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.tempScreenState=TempScreenState.RUNNING;
        this.player.setFacingDirection(Direction.RIGHT);

        map.getTextbox().setInteractKey(player.getInteractKey());

        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }
        playLevelScreen=new PlayLevelScreen(screenCoordinator);



    }

    @Override
    public void update() {

        switch(tempScreenState){
            case RUNNING:
                player.update();
                map.update(player);
                break;
            case SUSPENDED:
                playLevelScreen.update();
                break;
        }

        if(map.getFlagManager().isFlagSet("TeleportedBack"))
        {
            tempScreenState=TempScreenState.SUSPENDED;
            playLevelScreen.TeleportBack();
            
        }


    }

   

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        // TODO Auto-generated method stub
        switch (tempScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case SUSPENDED:
                playLevelScreen.draw(graphicsHandler);
                break;
        }
        //map.draw(player, graphicsHandler);

        //throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
    
    private enum TempScreenState {
        RUNNING,SUSPENDED
    }
}
