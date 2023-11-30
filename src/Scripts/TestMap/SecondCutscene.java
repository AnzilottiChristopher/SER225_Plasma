package Scripts.TestMap;

import Engine.GraphicsHandler;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;
import Utils.Point;

import java.security.SecureRandom;

public class SecondCutscene extends Script<NPC>
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
            setFlag("Boss3Start");
            setFlag("startingMusic");

        }
        if (sequence == 1)
        {
            //System.out.println("Here in seq 1 in setup");
            getNPC(8).setCurrentAnimationName("STAND_LEFT");
            player.setCurrentAnimationName("STAND_RIGHT");
            showTextbox();
            addTextToTextboxQueue("There's no time to rest Boomer!");
            addTextToTextboxQueue("Everyone's really hungry!");
            addTextToTextboxQueue("But for some reason there's no food");
            addTextToTextboxQueue("I heard some rumors that Blake\n up there might be causing this ruckus");
            addTextToTextboxQueue("Hurry!");
            addTextToTextboxQueue("Please help us Boomer");
        }

        if (sequence == 3)
        {
            System.out.println(amountMoved);
            amountMoved = 0;
        }

    }

    @Override
    protected void cleanup()
    {
        if (sequence == 4)
        {
            //System.out.println("Here in seq 4");
            unlockPlayer();
            setFlag("Boss2Pass");

            getNPC(39).setIsHidden(false);
            getNPC(41).setIsHidden(false);
            getNPC(42).setIsHidden(false);

            getNPC(8).setLocation(1450, 2400);
            getNPC(8).setCurrentAnimationName("STAND_LEFT");
        }

    }

    @Override
    protected ScriptState execute()
    {
        start();
        if (sequence == 0)
        {
            if (amountMoved < 250)
            {
                npcWalk(8, Direction.LEFT, 8);
                //System.out.println(amountMoved);
                amountMoved += 5;
            }

            if (amountMoved >= 250)
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
            if (amountMoved < 250)
            {
                npcWalk(8, Direction.RIGHT, 8);
                //System.out.println(amountMoved);
                amountMoved += 5;
                //System.out.println("here");
            }

            if (amountMoved >= 250)
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
