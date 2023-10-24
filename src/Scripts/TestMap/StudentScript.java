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
    }

    @Override
    protected void cleanup()
    {

    }

    @Override
    protected ScriptState execute()
    {
        return null;
    }
}
