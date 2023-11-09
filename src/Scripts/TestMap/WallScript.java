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
       System.out.println(entity.getId());
        if (entity.getId() >= 9 && entity.getId() < 14 && !isFlagSet("hasPassed"))
        {
            addTextToTextboxQueue("I hope this doesn't make me late for class!");
        } else if (entity.getId() >= 14 && entity.getId() < 17 && !isFlagSet("hasPassed"))
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

        } else if (entity.getId() >= 17 && entity.getId() < 19 && !isFlagSet("hasPassed"))
        {
            if (!isFlagSet("Boss1Complete"))
            {
                addTextToTextboxQueue("Look inside.");
                addTextToTextboxQueue("Are those students robots!?!?!??!");
                addTextToTextboxQueue("What the...");
                addTextToTextboxQueue("Those poor students");
            }
            else
            {
                addTextToTextboxQueue("So are they gonna turn back to humans?");
            }

        } else if (entity.getId() >= 19 && entity.getId() <= 21 && !isFlagSet("hasPassed"))
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

        } else if (entity.getId() > 21 && entity.getId() <= 27 && !isFlagSet("hasPassed"))
        {
            addTextToTextboxQueue("What's going on over there?");
        }


        if (isFlagSet("hasPassed"))
        {
            String text = switch (entity.getId())
            {
                case 17 -> "Is this the Sleeping Giant?";
                case 18 -> "The heck is going on?\n why can't we get past?";
                case 19 -> "This time I won't have to take my quiz.";
                case 20 -> "School has been strange recently";
                default -> "So odd";
            };
            addTextToTextboxQueue(text);
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
