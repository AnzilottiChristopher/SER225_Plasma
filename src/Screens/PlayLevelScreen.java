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

    protected TryAgainScreen tryAgainScreen;
    //protected static String[] enemies;
    protected static int victoryCount;


    Music music = new Music();
    JukeboxScript jukebox = new JukeboxScript();
    static Combat.combatant[] enemies = {new combatant("robot"),
                                        new combatant("robot"),
                                        new combatant("alex"),
                                        new combatant("random")};


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

        //Destruction of NPC's flags
        flagManager.addFlag("Boss1Complete", false);

        //try again screen 
        flagManager.addFlag("hasLostBattle", false);

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

        //Alex Enemy Flag Trigger
        flagManager.addFlag("Enemy1", false);
        flagManager.addFlag("Enemy2", false);

        //teleporting
        flagManager.addFlag("TeleportCompleted", false);
        flagManager.addFlag("PlayerHasTeleportedBack", false);


        //SleepWall Visibility
        flagManager.addFlag("Boss3Complete", false);

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


        combatScreen = new CombatScreen(this,playerCombatant,enemies[victoryCount], flagManager);
        winScreen = new WinScreen(this); 

        tryAgainScreen = new TryAgainScreen(this);
    }

    public void update() { 
        //System.out.println(playLevelScreenState);
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

             case BATTLE_LOSS: 
                //System.out.println("battle loss reached from combatScreen class"); 
                tryAgainScreen.update(); //allows for try again screen to update
            break;
            //UPDATES BASED ON COMBAT
            case COMBATMODE: 
                //tryAgainScreen.update();
                combatScreen.update();

           
                //UPDATES BASED ON RESULT OF COMBAT
                switch (combatScreen.getState())
                {
                    case WIN:  
                    map.getFlagManager().unsetFlag("hasTalkedToDinosaur");

                    //incriment victories
                    victoryCount++;
                    //advance who the current enemy is
                    combatScreen.setEnemy(enemies[victoryCount]);
                    
                    //heal player after combat
                    playerCombatant.maxHeal();

                    
                    break; 
                    
                    case TIE:  //tie in favor of the player... for now

                    //reset flag that starts combat
                    map.getFlagManager().unsetFlag("hasTalkedToDinosaur");

                    //incriment victories
                    victoryCount++;
                    //advance who the current enemy is
                    combatScreen.setEnemy(enemies[victoryCount]);
                    
                    //heal player after combat
                    playerCombatant.maxHeal();

                    break;

                    case LOSS:

                    System.out.println("unsetting has Dino talked in Play switch case");
                    map.getFlagManager().unsetFlag("hasTalkedToDinosaur");

                    //victory doesn't incriment
                    System.out.println("You lost... whomp whomp");
                    playerCombatant.maxHeal();
                    enemies[victoryCount].maxHeal(); 


                   // System.out.println("Calling tryAgainScreen here..."); 
                   // map.getFlagManager().setFlag("hasLostBattle"); //on the right track 
                    //System.out.println("loss flag is set"); 
                   // tryAgainScreen.update();

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

        //   if(map.getFlagManager().isFlagSet("hasLostBattle")){
        //     playLevelScreenState = PlayLevelScreenState.BATTLE_LOSS; 
        //     // map.getFlagManager().setFlag("CombatFinish"); 
        //     // map.getFlagManager().setFlag("hasTalkedToDinosaur"); 
        //     //System.out.println(getPlayLevelScreenState());
        // } 

        }
        // if flag is set it returns back to play level
        else if(map.getFlagManager().isFlagSet("CombatFinish")) //this determines the WIN condition I
        {
          
          playLevelScreenState=PlayLevelScreenState.RUNNING;

        } 
        // else  if(map.getFlagManager().isFlagSet("hasLostBattle")){
        //     playLevelScreenState = PlayLevelScreenState.BATTLE_LOSS; 
        //     // map.getFlagManager().setFlag("CombatFinish"); 
        //     // map.getFlagManager().setFlag("hasTalkedToDinosaur"); 
        //     //System.out.println(getPlayLevelScreenState());
        // }  

        



        // if flag is set at any point during gameplay, initiial soundtrack will not play
        if (map.getFlagManager().isFlagSet("hasTalked")) {
            music.stopLoop();
            map.getFlagManager().unsetFlag("hasTalked");
        }
        if(map.getFlagManager().isFlagSet("startingMusic"))
        {
            music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
            music.playLoop();
            map.getFlagManager().unsetFlag("startingMusic");
            //System.out.println("We are here Flags");
        }

        if (map.getFlagManager().isFlagSet("RoboEnemyStart"))
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
            case BATTLE_LOSS:  //trying this?
                tryAgainScreen.draw(graphicsHandler); 
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


    public void pauseCombatScreen(){   
        System.out.println("Pause fct before"); 
        //map.getFlagManager().unsetFlag("hasTalkedToDinosaur"); 
        playLevelScreenState = PlayLevelScreenState.BATTLE_LOSS;   
  

       // map.getFlagManager().setFlag("hasLostBattle"); //on the right track 
        // map.getFlagManager().unsetFlag("CombatStarted");
       // map.getFlagManager().unsetFlag("startingMusic");
       if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("Professor Alex"))
                {
                    map.getFlagManager().unsetFlag("AlexBossStart");

                    music.stopLoop();
                    //flagManager.setFlag("startingMusic");
                    //flagManager.setFlag("Boss1Complete");
                }
            if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("CyberBobcat") && getVictoryCount() == 1)
            {
                    System.out.println("unsetting enemy2 in Pause");
                    map.getFlagManager().unsetFlag("Enemy 2");
                    //map.getFlagManager().unsetFlag("RoboEnemyStart"); 
                    System.out.println("after pause for robot2");


                    music.stopLoop();
                    //flagManager.setFlag("startingMusic");
            } 
      //  map.getFlagManager().unsetFlag("CombatStarted"); 
        System.out.println("Pause fct after");

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
       //initialize();
        screenCoordinator.setGameState(GameState.MENU);  
      //  update(); 
        
        //unsetting combat flags, otherwise combat doesn't work
    } 

    //method to tell playerLevelscreen to call combat again?
    public void goBackToCombat(){     
        System.out.println("spacebar was pressed! before...");  
         map.getFlagManager().setFlag("hasTalkedToDinosaur");  //subsequently setCombat flag too 
        //playLevelScreenState = PlayLevelScreenState.COMBATMODE; //check which flags trigger which enemy

        // System.out.println("goBackToCombat ----- setting hasDino");
        // System.out.println("after  hasDino");


        //map.getFlagManager().setFlag("hasTalked");
        //map.getFlagManager().unsetFlag("hasLostBattle"); 
        //map.getFlagManager().setFlag("CombatStarted"); 
        //change screen state back to 

         if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("Professor Alex"))
                { 
                    System.out.println("alex start flag");
                    map.getFlagManager().setFlag("AlexBossStart");

                    music.stopLoop();
                    //flagManager.setFlag("startingMusic");
                    //flagManager.setFlag("Boss1Complete");
                }
        if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("CyberBobcat") && getVictoryCount() == 1)
            {
                    System.out.println("robo 2 flags being set again");
                    map.getFlagManager().setFlag("Enemy 2");
                    map.getFlagManager().setFlag("RoboEnemyStart");

                    music.stopLoop();
                    //flagManager.setFlag("startingMusic");
            } 

        System.out.println("after gobacktoCombat"); 

        //screenCoordinator.setGameState(GameState.COMBATSCREEN); //probably not the right setting
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED,COMBATMODE,SUSPENDED, BATTLE_LOSS
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