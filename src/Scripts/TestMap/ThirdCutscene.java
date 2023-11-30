package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;


public class ThirdCutscene extends Script<NPC>
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
            getNPC(8).setLocation(player.getX() + 600, player.getY());
            setFlag("Boss4Start");
            setFlag("startingMusic");
        }
        if (sequence == 1)
        {
            //System.out.println("Here in seq 1 in setup");
            getNPC(8).setCurrentAnimationName("STAND_LEFT");
            player.setCurrentAnimationName("STAND_RIGHT");
            showTextbox();
            addTextToTextboxQueue("This is awful!");
            addTextToTextboxQueue("Doctor J is forcing everyone\n to use Eclipse!");
            addTextToTextboxQueue("Nobody likes eclipse");
            addTextToTextboxQueue("Go put a stop to him!");
            addTextToTextboxQueue("He should be down by the school of business");
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

            setFlag("Boss3Pass");

            getNPC(40).setIsHidden(false);
            getNPC(43).setIsHidden(false);
            getNPC(44).setIsHidden(false);

            getNPC(8).setLocation(3500, 5200);
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
                npcWalk(8, Direction.LEFT, 4);
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
                npcWalk(8, Direction.RIGHT, 4);
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
