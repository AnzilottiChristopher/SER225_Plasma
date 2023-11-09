package Scripts.TestMap;

import Engine.Music;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class EnemyScript extends Script<NPC>
{

    Music music = new Music();
    @Override
    protected void setup()
    {
        entity.facePlayer(player);
        lockPlayer();
        showTextbox();
        setFlag("hasTalked");
        if (entity.getId() == 6)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("01001000 01001000 01001000 01010000");
        } else if (entity.getId() == 7)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("P...lease");
            addTextToTextboxQueue("Must finish....");
            addTextToTextboxQueue("Game...Almost");
            addTextToTextboxQueue(".....Exception?");
        }
        else if (entity.getId() == 42)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("The dining hall is closed.");
            addTextToTextboxQueue("No one deserves any of the food we make.");
            addTextToTextboxQueue("Professor Blake deserves all of the snacks");
        }
        else if (entity.getId() == 41)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("Must make snacks for blake."); 
        }
        else if (entity.getId() == 43)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("*Smacks table*");
            addTextToTextboxQueue("We should make a unity game together!");
        }
        else if (entity.getId() == 44)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("Come to Hackathon!");
        }
    }

    @Override
    protected void cleanup()
    {
        unlockPlayer();
        hideTextbox();
        setFlag("startingMusic");
        music.stopLoop();

        if (entity.getId() == 6 && PlayLevelScreen.getVictoryCount() == 0)
        {
            setFlag("hasTalkedToDinosaur");
        }   

        if (entity.getId() == 7 && PlayLevelScreen.getVictoryCount() == 1)
        {
            setFlag("hasTalkedToDinosaur");
        }   

    }

    @Override
    protected ScriptState execute()
    {
        start();
        if (!isTextboxQueueEmpty())
        {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
