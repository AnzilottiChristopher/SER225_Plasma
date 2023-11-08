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
public class DrJScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        setFlag("hasTalked");

        if (!isFlagSet("hasTalkedToDrJ"))
        {
            music.stopLoop();
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            addTextToTextboxQueue("I HATE OBJECT ORIENTATED PROGRAMMING!");
            addTextToTextboxQueue("NEVER USE ECLIPSE!");
        }
       else
       {
            music.stopLoop();
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            addTextToTextboxQueue("I love Eclipse");
            addTextToTextboxQueue("Best IDE of all time.");
            addTextToTextboxQueue("*A car just sped onto the middle of the quad!*");
            addTextToTextboxQueue("*Quickly go find it!*");
            addTextToTextboxQueue("*Maybe it'll be the answer to whats going on.*");
       }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToDrJ");
        setFlag("startingMusic");
        music.stopLoop();
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
