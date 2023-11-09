package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class HerscoviciScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        lockPlayer();
        showTextbox();
        if (entity.getX() > player.getX())
        {
            entity.setCurrentAnimationName("SIT_LEFT");
        }
        else
        {
            entity.setCurrentAnimationName("SIT_RIGHT");
        }
        addTextToTextboxQueue("*Yawn* I'm not gonna do anything");
        addTextToTextboxQueue("Teach? Absolutely not.");
        addTextToTextboxQueue("Too tired to be bothered");
        addTextToTextboxQueue("Those poor students can do all the work for me!");
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
        // if (!isFlagSet("hasTalkedToWall1")) {
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        //}
        return ScriptState.COMPLETED;
    }
}
