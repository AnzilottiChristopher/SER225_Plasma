package Scripts.TestMap;

import Engine.GraphicsHandler;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;
import Utils.Point;

import java.security.SecureRandom;

public class SecondCutscene extends Script<NPC>
{

    @Override
    protected void setup()
    {
        //lockPlayer();
        setFlag("Boss3Start");
        setFlag("Boss2Pass");
        setFlag("startingMusic");

    }

    @Override
    protected void cleanup()
    {
        getNPC(39).setIsHidden(false);
        getNPC(41).setIsHidden(false);
        getNPC(42).setIsHidden(false);
    }

    @Override
    protected ScriptState execute()
    {
        start();
        end();
        return ScriptState.COMPLETED;
    }
}
