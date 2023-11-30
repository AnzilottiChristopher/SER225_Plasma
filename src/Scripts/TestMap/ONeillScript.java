package Scripts.TestMap;

//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import Level.*;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class ONeillScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("This is my first semester teaching here and \nI have no idea whats happening.");
        addTextToTextboxQueue("This school is insane.");
        addTextToTextboxQueue("I should have never taken this job.");
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
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

