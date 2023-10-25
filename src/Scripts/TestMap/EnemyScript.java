package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

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
