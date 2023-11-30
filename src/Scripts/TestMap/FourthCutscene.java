package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;


public class FourthCutscene extends Script<NPC>
{

    @Override
    protected void setup()
    {
        //lockPlayer();
        setFlag("FinalBossStart");
        setFlag("startingMusic");
        setFlag("Boss4Pass");
    }

    @Override
    protected void cleanup()
    {
        getNPC(4).setIsHidden(false);
        getNPC(50).setIsHidden(false);
        getNPC(51).setIsHidden(false);
    }

    @Override
    protected ScriptState execute()
    {
        start();
        end();
        return ScriptState.COMPLETED;
    }
}
