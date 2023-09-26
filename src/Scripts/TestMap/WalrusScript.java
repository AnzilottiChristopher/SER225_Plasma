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
            ogTrack.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
            ogTrack.playLoop();
            addTextToTextboxQueue( "Hi Cat!");
            addTextToTextboxQueue( "...oh, you lost your ball?");
            addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");   
        }
        else {
            addTextToTextboxQueue( "I sure love doing walrus things!"); 
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
