package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Engine.Music;

// script for talking to walrus npc
public class JukeboxScript extends Script<NPC> {
int count = 1; 

Music newTrack = new Music(); 
Music ogTrack = new Music(); 


    @Override
    protected void setup() { 
        lockPlayer();
        showTextbox(); 

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue( "Starting music!");
            ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");  
        }
        else {
            addTextToTextboxQueue( "Changing music!"); 
            if (count == 2)
            { 
                newTrack.stopLoop(); 
                ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");                
                count = 1;
            }
            else{
                ogTrack.stopLoop(); 
                newTrack.background("Resources/Pokemon FireRedLeafGreen- Pallet Town.wav");
                count = 2;
            }
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