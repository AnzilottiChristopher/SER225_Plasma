package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;


public class ThirdCutscene extends Script<NPC>
{

    @Override
    protected void setup()
    {
        //lockPlayer();
        setFlag("Boss3Pass");
        setFlag("Boss4Start");
        setFlag("startingMusic");
    }

    @Override
    protected void cleanup()
    {
        getNPC(40).setIsHidden(false);
        getNPC(43).setIsHidden(false);
        getNPC(44).setIsHidden(false);

    }

    @Override
    protected ScriptState execute()
    {
        start();
        end();
        return ScriptState.COMPLETED;
    }
}
