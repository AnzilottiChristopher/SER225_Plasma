package Scripts.TestMap;

import Level.NPC;
import Level.Script;    
import Level.ScriptState;

public class JudyGruntScript extends Script<NPC>
{
    @Override
    protected void setup()
    {
        entity.facePlayer(player);
        lockPlayer();
        showTextbox();
        if (entity.getId() == 50)
        {
            addTextToTextboxQueue("You may be the icon of this school Boomer..."); 
            addTextToTextboxQueue("But QU truly belongs to President Judy!!!");

        } else if (entity.getId() == 51)
        {
            addTextToTextboxQueue("Well, well, well, look who's here...");
            addTextToTextboxQueue("Here to stop the inevitable?");
            addTextToTextboxQueue("Good luck with that Boomer, you'll never defeat Judy");
            addTextToTextboxQueue("All Hail President Judy!");
        }
    }

    @Override
    protected void cleanup()
    {
        unlockPlayer();
        hideTextbox();
    }

    @Override
    protected ScriptState execute()
    {
        start();
        if (!isTextboxQueueEmpty())
        {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
