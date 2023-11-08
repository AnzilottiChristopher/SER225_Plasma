package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;

public class MoveNPC extends Script<NPC>
{
    @Override
    protected void setup()
    {
        npcFacePlayer(8);
        //npcWalk(8, Direction.RIGHT, 4);
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("Boomer please help us!");
        addTextToTextboxQueue("Something terrible is happening over by CCE!");
        addTextToTextboxQueue("I don't understand what's happening");
        addTextToTextboxQueue("It's almost as if the students were turned into robots!");
        addTextToTextboxQueue("Please go to CCE and save them!");
    }

    @Override
    protected void cleanup()
    {
        setFlag("hasStartedGame");
        hideTextbox();
        unlockPlayer();
    }

    @Override
    protected ScriptState execute()
    {
        if (!isFlagSet("hasStartedGame")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}
