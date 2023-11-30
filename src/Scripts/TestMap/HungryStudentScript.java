package Scripts.TestMap;

//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import Level.*;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class HungryStudentScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("Do you have any spare meal points?");
        addTextToTextboxQueue("Can you buy me food?");
        addTextToTextboxQueue("I ran out already and dont have any food.");
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

