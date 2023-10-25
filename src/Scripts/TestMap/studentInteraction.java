package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;

public class studentInteraction extends Script<NPC>
{
    @Override
    protected void setup()
    {
        npcFacePlayer(6);
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("Boomer please help us!");
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
