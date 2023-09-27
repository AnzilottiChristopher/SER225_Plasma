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
Music count2 = new Music();


public int getCount() {
    return count;
}

public void setCount(int count) {
    this.count = count;
}

    @Override
    protected void setup() { 
        //ogTrack.stopClass(); 
        lockPlayer();
        showTextbox(); 
        setFlag("hasTalkedToJukebox");
        //Changes music when interacting with jukebox
        if (isFlagSet("hasTalkedToJukebox")) {
            addTextToTextboxQueue( "Starting music!");
            ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");  
            ogTrack.playLoop();
        }
        else {
            addTextToTextboxQueue( "Changing music!"); 
            //ogTrack.stopClass();
            if (count == 2)
            { 

                ogTrack.getClip();
                ogTrack.stopLoop(); 
                ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                ogTrack.playLoop();                
                count = 1;
            }
            else{
                ogTrack.stopLoop();
                ogTrack.background("Resources/Pokemon FireRedLeafGreen- Pallet Town.wav");
                ogTrack.playLoop();
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
