package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class StudentScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("We made it");
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
        if (!isFlagSet("hasStartedGame"))
        {
            start();
            if (!isTextboxQueueEmpty())
            {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}
