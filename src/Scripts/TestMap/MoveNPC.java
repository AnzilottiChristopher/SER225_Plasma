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
    SecureRandom random = new SecureRandom();
    @Override
    protected void setup()
    {
        //npcWalk(8, Direction.RIGHT, 4);
        //lockPlayer();

    }

    @Override
    protected void cleanup()
    {
        int xVal;
        setFlag("hasPassed");

        for (int counter = 16; counter < 21; counter++)
        {
            int randomVal = random.nextInt(500);
            if (counter == 17)
            {
                xVal = 0;
            } else
            {
                xVal = randomVal + 500;
            }
            //int yVal = randomVal + 500;
            getNPC(counter).setLocation(2500 + xVal, 3650);
            if (counter % 2 == 0)
            {
                getNPC(counter).setCurrentAnimationName("LOOK_DOWN_BOY");
            } else
            {
                getNPC(counter).setCurrentAnimationName("LOOK_DOWN_GIRL");
            }
        }
        getNPC(4).setIsHidden(true);
        getNPC(8).setLocation(2350, 3500);
//        NPC npc = getNPC(20);
//        npc.setLocation(1000, 2500);

        //System.out.println("Hello");
    }

    @Override
    protected ScriptState execute()
    {
        end();
        return ScriptState.COMPLETED;
    }
}
