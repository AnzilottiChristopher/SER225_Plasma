package Scripts.TestMap;

import Engine.Music;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

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
        else if (entity.getId() == 11)
        {
            music.stopLoop();
            music.background("Resources/Announce the truth.wav");
            music.playLoop();
            addTextToTextboxQueue("");
            
        }
    }

    @Override
    protected void cleanup()
    {
        unlockPlayer();
        hideTextbox();
        setFlag("startingMusic");
        music.stopLoop();
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
