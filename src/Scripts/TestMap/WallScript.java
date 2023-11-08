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
            if (!isFlagSet("Boss1Complete"))
            {
                addTextToTextboxQueue("YESSS");
                addTextToTextboxQueue("I DONT HAVE TO TAKE MY QUIZ NOW");
                addTextToTextboxQueue("LETS GOOOOOOOOOOOOO");
            } else
            {
                addTextToTextboxQueue("Damn....");
                addTextToTextboxQueue("I'm still gonna have to take that quiz");
                addTextToTextboxQueue("You couldn't have waited\n like a little longer to save him?");
            }

        } else if (entity.getId() >= 20 && entity.getId() < 30)
        {
            if (!isFlagSet("Boss1Complete"))
            {
                addTextToTextboxQueue("Are those students robots!?!?!??!");
                addTextToTextboxQueue("Those poor students");
            }
            else
            {
                addTextToTextboxQueue("So are they gonna turn back to humans?");
            }

        } else if (entity.getId() >= 30 && entity.getId() < 34)
        {
            if (!isFlagSet("Boss1Complete"))
            {
                addTextToTextboxQueue("Alex?");
                addTextToTextboxQueue("What are you doing Alex?");
                addTextToTextboxQueue("Oh geez somebody stop him!");
            } else if (isFlagSet("Boss1Complete"))
            {
                addTextToTextboxQueue("Thank you Boomer");
                addTextToTextboxQueue("Thank you for saving Alex");
            }

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