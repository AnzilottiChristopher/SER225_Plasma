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

    private int sequence = 0;
    private int amountMoved = 0;

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        setFlag("hasTalked");

        if (!isFlagSet("hasTalkedToAlex"))
        {
            music.stopLoop();
            music.background("Resources/ObstacleInPath.wav");
            music.playLoop();
            addTextToTextboxQueue("Hello");
        }
        else
        {
            music.stopLoop();
            setFlag("hasTalked");
            if (map.getFlagManager().isFlagSet("hasTalked"))
            {
                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                music.playLoop();
            }
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToAlex");
        music.stopLoop();
        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
        music.playLoop();
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

