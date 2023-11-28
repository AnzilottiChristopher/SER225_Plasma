package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import EnhancedMapTiles.SleepWall;
import Screens.PlayLevelScreen;
import GameObject.Frame;
import Level.*;
import Utils.Direction;
import Utils.Point;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class BlakeScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        setFlag("hasTalked");

        if (!isFlagSet("hasTalkedToBlake"))
        {
            music.stopLoop();
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            addTextToTextboxQueue("You want a snack?");
            addTextToTextboxQueue("NO WHY WOULD I GIVE YOU ONE! THEY'RE MINE!");
            addTextToTextboxQueue("GET BACK TO WORK!");
        }
       else
       {
            music.stopLoop();
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            addTextToTextboxQueue("What happened to me?");
            addTextToTextboxQueue("Whatever doesnt matter.");
            addTextToTextboxQueue("I can get you that snack now if you still want it.");
            addTextToTextboxQueue("*Theres some commotion at the School of Business*");
            addTextToTextboxQueue("*Maybe I should check it out*");
       }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        if (PlayLevelScreen.getVictoryCount() == 8)
        {
            setFlag("hasTalkedToDinosaur");
        }


        setFlag("hasTalkedToBlake");
        setFlag("startingMusic");
        setFlag("Boss3Complete");
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

