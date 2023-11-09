package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class HerscoviciEnemyScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        lockPlayer();
        showTextbox();
        if (entity.getId() == 28)
        {
            if (entity.getX() > player.getX())
            {
                entity.setCurrentAnimationName("DAZED_GIRL_LEFT");
            }
            else
            {
                entity.setCurrentAnimationName("DAZED_GIRL_RIGHT");
            }
            addTextToTextboxQueue("Too.... much work");
            addTextToTextboxQueue("P... Q... R? ");
            addTextToTextboxQueue("I can't take this anymore");
            addTextToTextboxQueue("Please help me");
        } else if (entity.getId() == 27)
        {
            if (entity.getX() > player.getX())
            {
                entity.setCurrentAnimationName("DAZED_BOY_LEFT");
            }
            else
            {
                entity.setCurrentAnimationName("DAZED_BOY_RIGHT");
            }
            addTextToTextboxQueue("Let P(n) be a predicate whose value\n includes all integers n>= a for some integer a");
            addTextToTextboxQueue("Suppose we can Prove:");
            addTextToTextboxQueue("1. P(a) is true");
            addTextToTextboxQueue("2. For some k >= a, if P(j) is true for all \nj integers with a <= j <= k then P(k+1) is true");
            addTextToTextboxQueue("That is:");
            addTextToTextboxQueue("if P(a) and P(a + 1) and P(a+2) and ... and P(k)\n then P(K + 1) is true");
            addTextToTextboxQueue("Then we may conclude that P(n) is true for all n>= a");

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
