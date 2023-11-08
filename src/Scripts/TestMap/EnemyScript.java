package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class EnemyScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        entity.facePlayer(player);
        lockPlayer();
        showTextbox();
        if (entity.getId() == 6)
        {
            addTextToTextboxQueue("01001000 01001000 01001000 01010000");
        } else if (entity.getId() == 7)
        {
            addTextToTextboxQueue("P...lease");
            addTextToTextboxQueue("Must finish....");
            addTextToTextboxQueue("Game...Almost");
            addTextToTextboxQueue(".....Exception?");
        }
    }

    @Override
    protected void cleanup()
    {
        unlockPlayer();
        hideTextbox();

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
