package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.CombatScreen;
import Engine.Music;

// script for talking to walrus npc
public class JudyAndCarScript extends Script<NPC> {
int count = 1; 

Music music = new Music();
 



    @Override
    protected void setup() { 
        lockPlayer();
        showTextbox();
        setFlag("hasTalked"); 

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToJudyCar")) {
            //setFlag("hasTalked");
            music.background("Resources/OMNIS LACRIMA.wav");
            music.playLoop();
            addTextToTextboxQueue( "Whadduuuuuuuuuuup!");
        }
        else {
            addTextToTextboxQueue( "This track fireeeeeeeeeee!"); 
            addTextToTextboxQueue( "Bye quinnilosers!"); 
            music.stopLoop();
            setFlag("hasTalked");
            if (map.getFlagManager().isFlagSet("hasTalked")){
                music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
                music.playLoop();
            }
           entity.setIsHidden(true);
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToJudyCar");
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