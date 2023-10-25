package Screens;

import Combat.combatant;
import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TempMap;
import Maps.TestMap;
import Players.Cat;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.JukeboxScript;
import Utils.Direction;
import Utils.Point;

import Engine.Music;


// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {  


    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected TempScreen tempScreen;
    protected CombatScreen combatScreen;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected combatant playerCombatant;
    //protected static String[] enemies;
    protected static int victoryCount;

    Music music = new Music();
    JukeboxScript jukebox = new JukeboxScript();
    static Combat.combatant[] enemies = {new combatant("robot"),
                                        new combatant("robot"),
                                        new combatant("robot"),
                                        new combatant("alex"),};


    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {

        this.screenCoordinator = screenCoordinator;

    }


    public void initialize() {

        //String[] enemies = {"robot", "robot", "robot"};
        playerCombatant = new combatant();

        // setup state
        flagManager = new FlagManager();
        //flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasStartedGame", false);
        flagManager.addFlag("hasInteractedWithStudent", false);
        flagManager.addFlag("enemy1Interaction", false);
        flagManager.addFlag("enemy2Interaction", false);

        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTalkedToJudyCar", false);
        flagManager.addFlag("hasTalkedToAlex", false);

        //combat screen
        flagManager.addFlag("CombatStarted", false);
        flagManager.addFlag("CombatFinish", false);
        flagManager.addFlag("TeleportCompleted", false);
        flagManager.addFlag("PlayerHasTeleportedBack", false);
        

        flagManager.addFlag("hasTalked", false); 
        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        music.playLoop();
        music.setCount(1);

        
        // define/setup map
        this.map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        //this.player.setLocation(5000, 0);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);


        // let pieces of map know which button to listen for as the "interact" button
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
        tempScreen=new TempScreen(this);
        //combatScreen=new CombatScreen(this);


        combatScreen = new CombatScreen(this,playerCombatant,enemies[victoryCount]);
        winScreen = new WinScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;

            //UPDATES BASED ON COMBAT
            case COMBATMODE:
                combatScreen.update();

            case SUSPENDED:
                tempScreen.update();
                //map.update(player);


                //UPDATES BASED ON RESULT OF COMBAT
                switch (combatScreen.getState())
                {
                    case WIN:
                    case TIE:  //tie in favor of the player... for now

                    map.getFlagManager().setFlag("BeatDino");
                    victoryCount++;
                    System.out.println("Victories:" + victoryCount);

                    System.out.println("PlayLevelScreen recieves = "+ combatScreen.getState() +
                    "\nFlag:" + map.getFlagManager().isFlagSet("BeatDino"));

                    break;

                    case LOSS:
                    //if you lose, talk to dino again
                    System.out.println("PlayLevelScreen recieves = "+ combatScreen.getState() +
                    "\nFlag:" + map.getFlagManager().isFlagSet("BeatDino"));
                    
                    //if you lose the fight... RESET GAME
                    this.initialize();

                    // Scripts.TestMap.DinoScript.class.

                    // Level.NPC.dinosaur.setIsHidden(false);
                    // map.getFlagManager().unsetFlag("hasTalkedToDinosaur");

                    
                    break;

                    case PROGRESS:
                    //do nothing, no results yet
                    break;
                }
        }

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }

        // if flag is set  it starts up the combat screen
        else if(map.getFlagManager().isFlagSet("hasTalkedToDinosaur"))
        {
          
          playLevelScreenState=PlayLevelScreenState.COMBATMODE;

          //sets flag for when combat starts
          map.getFlagManager().setFlag("CombatStarted");
        }
        // if flag is set it returns back to play level
        else if(map.getFlagManager().isFlagSet("CombatFinish"))
        {
          
          playLevelScreenState=PlayLevelScreenState.RUNNING;
          
          
        }
        // if flag is set at any point during gameplay, initiial soundtrack will not play
        if (map.getFlagManager().isFlagSet("hasTalked")) {
            music.stopLoop();

        }
        //if the player interacts with the door the they are teleported
        if(map.getFlagManager().isFlagSet("TeleportCompleted"))
        {
            playLevelScreenState=PlayLevelScreenState.SUSPENDED;
        }
        if(map.getFlagManager().isFlagSet("PlayerHasTeleportedBack"))
        {
            playLevelScreenState=PlayLevelScreenState.RUNNING;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case COMBATMODE:
                combatScreen.draw(graphicsHandler);
                break;
            case SUSPENDED:
                tempScreen.draw(graphicsHandler);
        }
    }

    


    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }


    public  void goBackPlayLevelScreen()
    {
        playLevelScreenState=PlayLevelScreenState.RUNNING;
        map.getFlagManager().setFlag("CombatFinish");
        map.getFlagManager().unsetFlag("CombatStarted");
        map.getFlagManager().unsetFlag("hasTalkedToDinosaur");
    }

    public void TeleportBack()
    {
        playLevelScreenState=PlayLevelScreenState.RUNNING;
        map.getFlagManager().setFlag("PlayerHasTeleportedBack");
    }



    public void resetLevel() {
        initialize();
    }


    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED,COMBATMODE,SUSPENDED
    }

    public static combatant getCurrentEnemy()
    {
        return enemies[victoryCount];
    }

}