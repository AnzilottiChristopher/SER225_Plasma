package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Engine.Music;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {
int count = 1; 

Music newTrack = new Music(); 
Music ogTrack = new Music(); 


    @Override
    protected void setup() { 
        lockPlayer();
        showTextbox(); 

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue( "Hi Cat!");
            addTextToTextboxQueue( "...oh, you lost your ball?");
            addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");   
        }
        else {
            addTextToTextboxQueue( "I sure love doing walrus things!"); 
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToWalrus");
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
