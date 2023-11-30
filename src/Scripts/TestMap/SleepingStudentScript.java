package Scripts.TestMap;

//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import Level.*;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class SleepingStudentScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("...");
        addTextToTextboxQueue("Zzz..Zzz...");
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

