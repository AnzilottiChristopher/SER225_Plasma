package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import Screens.PlayLevelScreen;
import GameObject.Frame;
import Level.*;
import Utils.Direction;
import Utils.Point;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class AlexScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        setFlag("hasTalked");

        if (!isFlagSet("hasTalkedToAlex"))
        {
//            music.stopLoop();
//            music.background("Resources/ObstacleInPath.wav");
//            music.playLoop();
            addTextToTextboxQueue("FASTER FASTER");
            addTextToTextboxQueue("CODE FASTER");
            addTextToTextboxQueue("YOU WORTHLESS FOOLS CAN'T \nCODE TO SAVE YOU");
            addTextToTextboxQueue("BECOME A ROBOT AND CODE \nFOR THE REST OF YOUR LIVES!!!!");
        }
        if (isFlagSet("Boss1Complete"))
        {
            addTextToTextboxQueue("Ughhhh");
            addTextToTextboxQueue("My head....");
            addTextToTextboxQueue("What Happened here are you ok?");
            addTextToTextboxQueue("I was supposed to play Ping Pong against Only Git");
        }
//        else
//        {
//            music.stopLoop();
//            setFlag("hasTalked");
//            if (map.getFlagManager().isFlagSet("hasTalked"))
//            {
//                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
//                music.playLoop();
//            }
//        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToAlex");
        //setFlag("startingMusic");
        //setFlag("Boss1Complete");
        setFlag("AlexBossStart");
        music.stopLoop();

        if (isFlagSet("Boss1Complete"))
        {
            setFlag("startingMusic");
        }
        if (PlayLevelScreen.getVictoryCount() == 2)
        {
            setFlag("hasTalkedToDinosaur");
        }

//        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
//        music.playLoop();
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty())
        {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}

