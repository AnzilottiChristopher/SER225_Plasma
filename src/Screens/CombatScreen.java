package Screens;

import java.awt.Color; 

import java.awt.Font; //importing font for text
import java.awt.image.BufferedImage;

import Combat.combatRounds;
import Combat.combatStatus;
import Combat.combatant;
import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.FlagManager;
import Level.Map;
import Maps.CombatMap;
import SpriteFont.SpriteFont;

public class CombatScreen extends Screen {


    protected boolean checkMove1;
    protected int moveTimer;

    protected boolean checkMove2;
    protected boolean checkMove3;

    private Color moveTextBox = new Color(204, 204, 204, 50); //makes a transparent color


    private Font moveFont = new Font("Monospaced", Font.PLAIN, 14);
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
    protected Music music = new Music();

    public CombatScreen(PlayLevelScreen playLevelScreen,combatant playerCombatant ,combatant enemyCombatant, FlagManager flagManager)
    {
        this.playLevelScreen=playLevelScreen;
        this.screenCoordinator=playLevelScreen.screenCoordinator;
        this.enemyCombatant = enemyCombatant;
        this.playerCombatant = playerCombatant;
        this.flagManager = flagManager;

        initialize();
    }

    public void setEnemy(combatant enemyCombatant)
    {
        System.out.println("Making new combat - setEnemy method");
        this.enemyCombatant = enemyCombatant;
        currentCombat = new combatRounds(playerCombatant, enemyCombatant);
    }

    
    //Initialize can set and reset the screen
    @Override
    public void initialize() {        

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



        checkMove1 = false;
        checkMove2 = false;
        checkMove3 = false;

        moveTimer = 5;

        moveSelected = 0;

    }

    @Override
    public void update() {




//        if (flagManager.isFlagSet("AlexBossStart") && !flagManager.isFlagSet("Boss1Complete"))
//        {
////            music.stopLoop();
////            music.background("Resources/ObstacleInPath.wav");
////            music.playLoop();
//            flagManager.unsetFlag("AlexBossStart");
//        }

        if (flagManager.isFlagSet("RoboEnemyStart"))
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            flagManager.unsetFlag("RoboEnemyStart");
        }
        combatState = currentCombat.updateCombat();

        //decrease timer as time progresses
        keyPressTimer--;

        if (keyPressTimer < 0)
        {
            keyPressTimer = 0;
        }

        //win button
        if (Keyboard.isKeyDown(Key.NINE) && keyPressTimer == 0) {
            keyPressTimer = 14;
            combatState = combatStatus.WIN;
            System.out.println("AUTO WIN");
        }

        if (Keyboard.isKeyDown(Key.ZERO) && keyPressTimer == 0) {
            keyPressTimer = 14;
            combatState = combatStatus.LOSS;
            System.out.println("AUTO LOSS");
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
            if(moveSelected == 1){
                checkMove1 = true;
                moveTimer = 45;
            }
            else if(moveSelected == 2){
                checkMove2 = true;
                moveTimer = 45;
            }
            else if(moveSelected == 3){
                checkMove3 = true;
                moveTimer = 45;
            }
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
                if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("Professor Alex"))
                {
                    music.stopLoop();
                    flagManager.setFlag("startingMusic");
                    flagManager.setFlag("Boss1Complete");
                }
                if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("CyberBobcat"))
                {
                    music.stopLoop();
                    flagManager.setFlag("startingMusic");
                }
                if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("Professor Herscovici"))
                {
                    music.stopLoop();
                    flagManager.setFlag("startingMusic");
                    flagManager.setFlag("Boss2Complete");
                    flagManager.unsetFlag("Boss2Pass");
                    //flagManager.setFlag("Boss3Start");
                }
                if (PlayLevelScreen.getCurrentEnemy().getName().equalsIgnoreCase("Professor Blake"))
                {
                    music.stopLoop();
                    flagManager.setFlag("startingMusic");
                    flagManager.setFlag("DefaultMusic");
                    flagManager.setFlag("hasTalkedToBlake");
                    flagManager.setFlag("Boss3Complete");
                }
                playLevelScreen.goBackPlayLevelScreen();
                break;
            case LOSS:
                break;
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


        if(checkMove1 == true){
            graphicsHandler.drawFilledRectangleWithBorder(420, 360, 300, 40, moveTextBox, Color.WHITE, 5);
            graphicsHandler.drawString("Boomer used " + playerCombatant.moveName1() + "!", 440, 380, moveFont, Color.WHITE); //drawing text in white

            graphicsHandler.drawFilledRectangleWithBorder(50, 150, 350, 40, moveTextBox, Color.RED, 5);
            graphicsHandler.drawString(enemyCombatant.getName() + " used " + enemyCombatant.moveName1() + "!", 60, 170, moveFont, Color.WHITE); //drawing text in white
            moveTimer--;
            if(moveTimer <= 0){
                checkMove1 = false;
            }

        }
        else if(checkMove2 == true){
            graphicsHandler.drawFilledRectangleWithBorder(420, 360, 300, 40, moveTextBox, Color.WHITE, 5);
            graphicsHandler.drawString("Boomer used " + playerCombatant.moveName2() + "!", 440, 380, moveFont, Color.WHITE); //drawing text in white

            graphicsHandler.drawFilledRectangleWithBorder(50, 150, 350, 40, moveTextBox, Color.RED, 5);
            graphicsHandler.drawString(enemyCombatant.getName() + " used " + enemyCombatant.moveName2() + "!", 60, 170, moveFont, Color.WHITE);
            moveTimer--;
            if(moveTimer <= 0){
                checkMove2 = false;
            }

        }
        else if(checkMove3 == true){
            graphicsHandler.drawFilledRectangleWithBorder(420, 360, 330, 40, moveTextBox, Color.WHITE, 5);
            graphicsHandler.drawString("Boomer used " + playerCombatant.moveName3() + "!", 440, 380, moveFont, Color.WHITE); //drawing text in white

           graphicsHandler.drawFilledRectangleWithBorder(50, 150, 350, 40, moveTextBox, Color.RED, 5);
            graphicsHandler.drawString(enemyCombatant.getName() + " used " + enemyCombatant.moveName3() + "!", 60, 170, moveFont, Color.WHITE);
            moveTimer--;
            if(moveTimer <= 0){
                checkMove3 = false;
            }

        }

        //player stuffs
        graphicsHandler.drawFilledRectangle(520, 400, 250, 40, new Color(225, 225, 255)); //white rect outline for player 
        graphicsHandler.drawString(playerCombatant.getName(), 530, 435, nameFont, Color.BLACK); //name text 
        graphicsHandler.drawFilledRectangle(520, 405, (playerCombatant.getHealth()*2), 10, green); //player healthbar   

        graphicsHandler.drawImage(playerCombatant.getBattleImage(), 180, 250);




        // playerCombatant.getHealth()*2 for the width doesn't work, it repeats a ton  
        //switch case function for evaluating health amounts? 
 
        //enemy stuffs
        graphicsHandler.drawFilledRectangle(40, 65, 250, 36, new Color(225, 225, 255)); //white rect outline 
        graphicsHandler.drawString(enemyCombatant.getName(), 40, 94, nameFont, Color.BLACK); //name text  
        graphicsHandler.drawFilledRectangle(40, 70, (enemyCombatant.getHealth()*2), 10, green); //enemy healthbar  
         //THIS DOES THE THING!!!!
       graphicsHandler.drawImage(enemyCombatant.getBattleImage(), 420, 110);


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
            graphicsHandler.drawRectangle(20, 470, 170, 30, new Color(200, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(155, 440, 170, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,180, 30, new Color(49, 207, 240), 5);
        }

        else if (moveSelected == 2)
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 170, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(155, 440, 170, 30, new Color(200, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,180, 30, new Color(49, 207, 240), 5);
        }
        else if (moveSelected == 3)
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 170, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(155, 440, 170, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470, 180, 30, new Color(200, 207, 240), 5);
        }
        else
        {
            //rect 1
            graphicsHandler.drawRectangle(20, 470, 170, 30, new Color(49, 207, 240), 5);
            //rect 2
            graphicsHandler.drawRectangle(155, 440, 170, 30, new Color(49, 207, 240), 5);
            //rect 3
            graphicsHandler.drawRectangle(300, 470,180, 30, new Color(49, 207, 240), 5);
        } 

        

    } 

    // public void healthShfit(int amount) {
    //     if(amount <= 100 && amount>=70){
    //         yellowRect.draw(null);
    //     }
    // }
    
}
