package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.CombatScreen;
import Engine.Music;
import Screens.PlayLevelScreen;

// script for talking to walrus npc
public class JudyAndCarScript extends Script<NPC> {
int count = 1; 

Music music = new Music();

    @Override
    protected void setup() { 
        lockPlayer();
        showTextbox();
        //setFlag("hasTalked");
        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToJudyCar")) {
            //setFlag("hasTalked");
//            music.background("Resources/OMNIS LACRIMA.wav");
//            music.playLoop();
            setFlag("JudyBossStart");
            addTextToTextboxQueue( "Soo... you finally figured it out, huh?"); //students are robots, and the prof's are the opposite of how they act
            addTextToTextboxQueue( "Alex, David, Jonathan... even Chetan..."); 
            addTextToTextboxQueue( "I must say, that's quite a feat...."); 
            addTextToTextboxQueue( "But this is MY university Boomer ");


        }
        else {
            addTextToTextboxQueue( "Anyways, I've got another meeting"); 
            addTextToTextboxQueue( "Gooooo Bobcats!"); 
            music.stopLoop();
            setFlag("Victory");
            // setFlag("hasTalked");
//             if (map.getFlagManager().isFlagSet("hasTalked")){
//                 music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
//                 music.playLoop();
//             }
           entity.setIsHidden(true);
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToJudyCar");
        //setFlag("startingMusic");

        if (PlayLevelScreen.getVictoryCount() == 14)
        {
            setFlag("hasTalkedToDinosaur");
        }

//        music.stopLoop();
//        music.background("Resources/Pokemon RubySapphireEmerald- Littleroot Town.wav");
//        music.playLoop();
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