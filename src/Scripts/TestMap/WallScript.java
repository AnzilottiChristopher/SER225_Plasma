package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;

public class WallScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        lockPlayer();
        showTextbox();
        //System.out.println(entity.getId());
        if (entity.getId() >= 9 && entity.getId() < 14)
        {
            addTextToTextboxQueue("I hope this doesn't make me late for class!");
        } else if (entity.getId() >= 14 && entity.getId() < 20)
        {
            addTextToTextboxQueue("YESSS");
            addTextToTextboxQueue("I DONT HAVE TO TAKE MY QUIZ NOW");
            addTextToTextboxQueue("LETS GOOOOOOOOOOOOO");
        } else if (entity.getId() >= 20 && entity.getId() < 30)
        {
            addTextToTextboxQueue("Are those students robots!?!?!??!");
            addTextToTextboxQueue("Those poor students");
        } else if (entity.getId() >= 30 && entity.getId() < 34)
        {
            addTextToTextboxQueue("Alex?");
            addTextToTextboxQueue("What are you doing Alex?");
            addTextToTextboxQueue("Oh geez somebody stop him!");
        } else if (entity.getId() >= 34 && entity.getId() <= 38)
        {
            addTextToTextboxQueue("What's going on over there?");
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
