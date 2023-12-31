package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class HerscoviciScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        //Maybe make NPCs sleepy do to his effects (Part of plot)
        lockPlayer();
        showTextbox();
        setFlag("HerscBossStart");
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

        if (PlayLevelScreen.getVictoryCount() == 5)
        {
            setFlag("hasTalkedToDinosaur");
        }
        unsetFlag("Boss2Pass");
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
