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

import java.util.ArrayList;


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

    //alex, herscovici, blake, dr j, judy
    //robot,robot, alex, 
    //student student herscovici
    //chef chef blake
    //julia peter drj
    //construction construction judy
    static Combat.combatant[] enemies = {new combatant("robot"), //0
                                        new combatant("robot"), //1
                                        new combatant("alex"), //2
                                        new combatant("student"), //3
                                        new combatant("student"), //4
                                        new combatant("herscovici"),//5
                                        new combatant("chef"), //6
                                        new combatant("chef"), //7
                                        new combatant("blake"), //8
                                        new combatant("julia"), //9
                                        new combatant("peter"), //10
                                        new combatant("drj"), //11
                                        new combatant("construction"), //12
                                        new combatant("construction"), //13
                                        new combatant("judy"), //14
                                        new combatant("random"), //never used, used to stop array length error
                                    };


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

        //Boss completion flags
        flagManager.addFlag("Boss1Complete", false);
        flagManager.addFlag("Boss2Start", false);
        flagManager.addFlag("Boss2Complete", false);
        flagManager.addFlag("Boss2Pass", true);
        flagManager.addFlag("Boss3Start", false);
        flagManager.addFlag("Boss3Complete", false);
        flagManager.addFlag("Boss3Pass", true);
        flagManager.addFlag("Boss4Start", false);
        flagManager.addFlag("Boss4Complete", false);

        flagManager.addFlag("DefaultMusic", false);



        //Move NPC
        flagManager.addFlag("hasPassed", false);

        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTalkedToJudyCar", false);
        flagManager.addFlag("hasTalkedToAlex", false);
        flagManager.addFlag("hasTalkedToBlake", false);
        flagManager.addFlag("hasTalkedToDrJ", false);

        //combat screen
        flagManager.addFlag("CombatStarted", false);
        flagManager.addFlag("CombatFinish", false);

        //Combat Screen Music
        flagManager.addFlag("AlexBossStart", false);
        flagManager.addFlag("RoboEnemyStart", false);
        flagManager.addFlag("HerscBossStart", false);
        flagManager.addFlag("BlakeBossStart", false);

        //Alex Enemy Flag Trigger
        flagManager.addFlag("Enemy1", false);
        flagManager.addFlag("Enemy2", false);

        flagManager.addFlag("Enemy4", false);
        flagManager.addFlag("Enemy5", false);

        flagManager.addFlag("Enemy7", false);
        flagManager.addFlag("Enemy8", false);

        flagManager.addFlag("Enemy10", false);
        flagManager.addFlag("Enemy11", false);

        flagManager.addFlag("Enemy13", false);
        flagManager.addFlag("Enemy14", false);

        //teleporting
        flagManager.addFlag("TeleportCompleted", false);
        flagManager.addFlag("PlayerHasTeleportedBack", false);


        //SleepWall Visibility
        //flagManager.addFlag("Boss3Complete", false);

        flagManager.addFlag("hasTalked", false);
        flagManager.addFlag("startingMusic", false);
        flagManager.addFlag("tenseMusic", false);


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


        combatScreen = new CombatScreen(this,playerCombatant,enemies[victoryCount], this.flagManager);
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
             // bring up a temporary screen
             case SUSPENDED:
             tempScreen.setTempScreenState("RUNNING");
             tempScreen.update();
             break;

            //UPDATES BASED ON COMBAT
            case COMBATMODE:
                combatScreen.update();

           
                


                //UPDATES BASED ON RESULT OF COMBAT
                switch (combatScreen.getState())
                {
                    case WIN:
                    case TIE:  //tie in favor of the player... for now

                    //reset flag that starts combat
                    map.getFlagManager().unsetFlag("hasTalkedToDinosaur");

                    //incriment victories
                    victoryCount++;
                    System.out.println("vic count:" + victoryCount);

                    //advance who the current enemy is
                    combatScreen.setEnemy(enemies[victoryCount]);
                    
                    //heal player after combat
                    playerCombatant.maxHeal();


                    break;

                    case LOSS:

                    //victory doesn't incriment
                    //this.initialize();
                    System.out.println("You lost... whomp whomp");
                    //victoryCount++;
                    playerCombatant.maxHeal();
                    enemies[victoryCount].maxHeal();

                    
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
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            map.getFlagManager().unsetFlag("hasTalked");
        }
        if(map.getFlagManager().isFlagSet("HerscBossStart"))
        {
            music.stopLoop();
            music.background("Resources/SoulMaster.wav");
            music.playLoop();
            map.getFlagManager().unsetFlag("HerscBossStart");
        }
        if (map.getFlagManager().isFlagSet("BlakeBossStart"))
        {
            music.stopLoop();
            music.background("Resources/MaskedDedede.wav");
            music.playLoop();
            map.getFlagManager().unsetFlag("BlakeBossStart");
        }

        //!This is main music controller
        if(map.getFlagManager().isFlagSet("startingMusic"))
        {
            music.stopLoop();
            if (!flagManager.isFlagSet("Boss1Complete"))
            {
                music.background("Resources/RoboticMusic.wav");
            }
            if (flagManager.isFlagSet("Boss1Complete") && !flagManager.isFlagSet("Boss2Start"))
            {
                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
            }
            if (flagManager.isFlagSet("Boss2Start") && !flagManager.isFlagSet("Boss2Complete"))
            {
                music.background("Resources/PuzzleMusic.wav");
                //map.getFlagManager().unsetFlag("Boss2Start");
            }
            if (flagManager.isFlagSet("Boss2Complete") && !flagManager.isFlagSet("Boss3Start"))
            {
                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                //map.getFlagManager().unsetFlag("Boss2Complete");
            }
            if (flagManager.isFlagSet("Boss3Start") && !map.getFlagManager().isFlagSet("Boss3Complete"))
            {
                music.background("Resources/SugarlandShimmy.wav");
                //map.getFlagManager().unsetFlag("Boss3Start");
            }
            if (flagManager.isFlagSet("Boss4Start"))
            {
                music.background("Resources/TheWarsEnd.wav");
                //map.getFlagManager().unsetFlag("Boss4Start");
            }

            if (flagManager.isFlagSet("DefaultMusic"))
            {
                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                map.getFlagManager().unsetFlag("DefaultMusic");
            }
            music.playLoop();

            map.getFlagManager().unsetFlag("startingMusic");
            //System.out.println("We are here Flags");
        }

        if (map.getFlagManager().isFlagSet("RoboEnemyStart") ||
            map.getFlagManager().isFlagSet("PQEnemyStart"))
        {
            music.stopLoop();
        }
        if(map.getFlagManager().isFlagSet("tenseMusic"))
        {
            music.background("Resources/A violent encounter.wav");
            music.playLoop();
            map.getFlagManager().unsetFlag("tenseMusic");
            //System.out.println("We are here Flags");
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

    /*public void loadMap()
    {
        Map map;
        int MapID=0;
        switch(MapID)
        {
            case 0:
                map
        }
    }*/


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

    /*  public void goBack()
    {
        playLevelScreenState=PlayLevelScreenState.RUNNING;
        map.getFlagManager().setFlag("PlayerHasTeleportedBack");
        map.getFlagManager().unsetFlag("TeleportCompleted");
    }*/

    
    public void TeleportBack()
    {
        map.getFlagManager().setFlag("PlayerHasTeleportedBack");
        playLevelScreenState=PlayLevelScreenState.RUNNING;
        map.getFlagManager().unsetFlag("TeleportCompleted");
        map.getFlagManager().unsetFlag("Teleported2");
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

    public static int getVictoryCount()
    {
        return victoryCount;
    }

}