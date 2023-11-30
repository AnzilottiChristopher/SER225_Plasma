package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class NessInteraction extends Script<NPC>
{
    @Override
    protected void setup()
    {
        entity.facePlayer(player);
        lockPlayer();
        showTextbox();

        if (!isFlagSet("hasPassed") && !isFlagSet("Boss1Complete"))
        {
            addTextToTextboxQueue("Boomer please help us!");
        }
        if (!isFlagSet("hasPassed") && isFlagSet("Boss1Complete"))
        {
            addTextToTextboxQueue("Thank you boomer! You were awesome!");
        }
        if (isFlagSet("hasPassed"))
        {
            addTextToTextboxQueue("What is Herscovici doing over there?");
        }
    }

    @Override
    protected void cleanup()
    {
        hideTextbox();
        unlockPlayer();
    }

    @Override
    protected ScriptState execute()
    {
        if (!isFlagSet("hasInteractedWithStudent")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}
