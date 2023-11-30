package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;


public class FourthCutscene extends Script<NPC>
{

    private int sequence = 0;
    private int amountMoved = 0;
    private boolean startCheck = true;
    @Override
    protected void setup()
    {
        lockPlayer();

        if (sequence == 0)
        {
            //System.out.println("Here in seq 0 in setup");
            getNPC(8).setLocation(player.getX() - 600, player.getY());
            setFlag("FinalBossStart");
            setFlag("startingMusic");
        }

        if (sequence == 1)
        {
            //System.out.println("Here in seq 1 in setup");
            getNPC(8).setCurrentAnimationName("STAND_RIGHT");
            player.setCurrentAnimationName("STAND_LEFT");
            showTextbox();
            addTextToTextboxQueue("You've done well Boomer");
            addTextToTextboxQueue("On behalf of all Quinnipiac students\nI thank you for your help");
            addTextToTextboxQueue("But it's not over yet");
            addTextToTextboxQueue("SHE has returned");
            addTextToTextboxQueue("Up ahead towards the middle of campus");
            addTextToTextboxQueue("You will find her waiting");
        }

        if (sequence == 3)
        {
            //System.out.println(amountMoved);
            amountMoved = 0;
        }


    }

    @Override
    protected void cleanup()
    {

        if (sequence == 4)
        {
            unlockPlayer();


            setFlag("Boss4Pass");

            getNPC(4).setIsHidden(false);
            getNPC(50).setIsHidden(false);
            getNPC(51).setIsHidden(false);

            getNPC(8).setLocation(1850, 3700);
            getNPC(8).setCurrentAnimationName("STAND_RIGHT");
        }

    }

    @Override
    protected ScriptState execute()
    {
        start();
        if (sequence == 0)
        {
            if (amountMoved < 650)
            {
                npcWalk(8, Direction.RIGHT, 4);
                //System.out.println(amountMoved);
                amountMoved += 5;
            }

            if (amountMoved >= 650)
            {
                sequence = 1;
                end();
                //start();
            }
            return ScriptState.RUNNING;
        }

        if (sequence == 1)
        {
            //System.out.println("here in seq 1 in execute");
            sequence = 2;
            start();
            //end();
            return ScriptState.RUNNING;
        }

        if (sequence == 2 && !isTextboxQueueEmpty())
        {
            return ScriptState.RUNNING;
        }

        if (sequence == 2 && isTextboxQueueEmpty())
        {
            hideTextbox();
            //end();
            sequence = 3;
            amountMoved = 0;
            return ScriptState.RUNNING;
        }

        if (sequence == 3)
        {
            //System.out.println("Here in seq 3 Ex");
            if (startCheck)
            {
                start();
                startCheck = false;
            }
            if (amountMoved < 650)
            {
                npcWalk(8, Direction.LEFT, 4);
                //System.out.println(amountMoved);
                amountMoved += 5;
                //System.out.println("here");
            }

            if (amountMoved >= 650)
            {
                sequence = 4;
                end();
                //start();
            }
            return ScriptState.RUNNING;
        }

        end();
        return ScriptState.COMPLETED;
    }
}
