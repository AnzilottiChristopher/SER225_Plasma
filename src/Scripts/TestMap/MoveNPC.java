package Scripts.TestMap;

import Engine.GraphicsHandler;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Direction;
import Utils.Point;

import java.security.SecureRandom;

public class MoveNPC extends Script<NPC>
{
    //SecureRandom random = new SecureRandom();
    private int amountMoved = 0;
    private int sequence = 0;
    private boolean check = false;
    private boolean startCheck = true;
    private boolean secondStartCheck = true;

    @Override
    protected void setup()
    {
        lockPlayer();
        System.out.println(sequence);
        if(sequence == 0)
        {
            getNPC(8).setLocation(player.getX() - 600, player.getY());
        }

        if(!isFlagSet("hasPassed") && sequence == 1)
        {
            getNPC(8).setCurrentAnimationName("STAND_RIGHT");
            player.setCurrentAnimationName("STAND_LEFT");
            showTextbox();
            addTextToTextboxQueue("Why... am I so... sleepy....");
            addTextToTextboxQueue("What is going on");
            addTextToTextboxQueue("Help... please... something is happening");
            addTextToTextboxQueue("It must be another teacher!");
        }

        if(sequence == 2)
        {
            amountMoved = 0;
        }
        //System.out.println(player.getX());








    }

    @Override
    protected void cleanup()
    {
        int xVal;

        if (sequence == 0)
        {
            check = true;
        }

        if(sequence == 3)
        {
            unlockPlayer();
            hideTextbox();
            setFlag("hasPassed");
            for (int counter = 16; counter < 21; counter++)
            {
                xVal = switch (counter)
                {
                    case 17 -> 0;
                    case 18 -> 100;
                    case 19 -> 200;
                    case 20 -> 300;
                    default -> 0;
                };
                getNPC(counter).setLocation(2500 + xVal, 3650);
                if (counter % 2 == 0)
                {
                    getNPC(counter).setCurrentAnimationName("LOOK_DOWN_BOY");
                } else
                {
                    getNPC(counter).setCurrentAnimationName("LOOK_DOWN_GIRL");
                }
            }
            //getNPC(4).setIsHidden(true);
            getNPC(8).setLocation(1850, 3400);
            getNPC(8).setCurrentAnimationName("STAND_LEFT");

            getNPC(200).setIsHidden(false);
            getNPC(27).setIsHidden(false);
            getNPC(28).setIsHidden(false);

            setFlag("Boss2Start");
            setFlag("startingMusic");
        }


//        NPC npc = getNPC(20);
//        npc.setLocation(1000, 2500);

        //System.out.println("Hello");
    }

    @Override
    protected ScriptState execute()
    {

        if(sequence == 0 && !check)
        {
            if (startCheck)
            {
                start();
                startCheck = !startCheck;
            }
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
        if (secondStartCheck)
        {
            sequence = 1;
            start();
            secondStartCheck = !secondStartCheck;
        }

        if (!isTextboxQueueEmpty() && sequence == 1)
        {
            return ScriptState.RUNNING;
        }

        if (sequence == 1 && isTextboxQueueEmpty())
        {
            hideTextbox();
            sequence = 2;
            //start();
            return ScriptState.RUNNING;
        }

        if(sequence == 2)
        {
            if (amountMoved < 650)
            {
                npcWalk(8, Direction.LEFT, 4);
                //System.out.println(amountMoved);
                amountMoved += 5;
            }

            if (amountMoved >= 650)
            {
                sequence = 3;
                end();
                //start();
            }
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
