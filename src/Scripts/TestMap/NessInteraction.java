package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class NessInteraction extends Script<NPC>
{
    @Override
    protected void setup()
    {
        entity.facePlayer(player);
        lockPlayer();
        showTextbox();

        if (!isFlagSet("hasPassed") && !isFlagSet("Boss1Complete"))
        {
            addTextToTextboxQueue("Boomer please help us!");
        }
        if (!isFlagSet("hasPassed") && isFlagSet("Boss1Complete"))
        {
            addTextToTextboxQueue("Thank you boomer! You were awesome!");
        }
        if (isFlagSet("hasPassed") && !isFlagSet("Boss2Complete"))
        {
            addTextToTextboxQueue("What is Herscovici doing over there?");
        }
        if (isFlagSet("Boss3Start") && !isFlagSet("Boss3Complete"))
        {
            addTextToTextboxQueue("Blake! Give us back the food!");
            addTextToTextboxQueue("Try defeating the chefs first");
        }
        if (isFlagSet("Boss4Start") && !isFlagSet("Boss4Complete"))
        {
            addTextToTextboxQueue("Doctor J PLEASE");
            addTextToTextboxQueue("No more eclipse");
        }
        if (isFlagSet("FinalBossStart") && !isFlagSet("FinalBossComplete"))
        {
            addTextToTextboxQueue("It's almost over");
            addTextToTextboxQueue("School is almost back to normal");
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
        if (!isFlagSet("hasInteractedWithStudent")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}
