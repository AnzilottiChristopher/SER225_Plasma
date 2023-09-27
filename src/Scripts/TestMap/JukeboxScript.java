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
        //setFlag("hasTalkedToJukebox");
        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (isFlagSet("hasTalkedToJukebox")) {
            addTextToTextboxQueue( "Starting music!");
            ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");  
            ogTrack.playLoop();
        }
        else {
            addTextToTextboxQueue( "Changing music!"); 
            if (count == 2)
            { 
                newTrack.stopLoop(); 
                ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                ogTrack.playLoop();                
                count = 1;
            }
            else{
                ogTrack.stopLoop(); 
                newTrack.background("Resources/Pokemon FireRedLeafGreen- Pallet Town.wav");
                newTrack.playLoop();
                count = 2;
            }
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToJukebox");
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
