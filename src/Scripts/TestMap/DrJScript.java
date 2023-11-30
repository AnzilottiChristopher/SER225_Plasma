package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
//import Game.ScreenCoordinator;
//import Game.ScreenCoordinator;
import Screens.PlayLevelScreen;
import GameObject.Frame;
import Level.*;
import Utils.Direction;
import Utils.Point;
import Engine.Music;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class DrJScript extends Script<NPC> {

    Music music = new Music();
    

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        if (!isFlagSet("hasTalkedToDrJ"))
        {
            setFlag("JBossStart");
            addTextToTextboxQueue("COME JOIN THE DARKSIDE!");
            addTextToTextboxQueue("YOU DO NOT UNDERSTAND THE POWER\n OF ECLIPSE");
            addTextToTextboxQueue("I WILL BUILD MY NEW EMPIRE WITH ECLIPSE");
            addTextToTextboxQueue("DONT MAKE ME DESTROY YOU!");
        }
       else
       {

            addTextToTextboxQueue("I still love Eclipse!");
            addTextToTextboxQueue("Best IDE of all time.");
            addTextToTextboxQueue("But you can use whatever IDE you want");
            addTextToTextboxQueue("*A Tesla just sped onto the middle of the quad!*");
            addTextToTextboxQueue("*Quickly go find it!*");
            addTextToTextboxQueue("*Maybe it'll be the answer to whats going on.*");
       }
        entity.facePlayer(player);
    }
    
    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        if (PlayLevelScreen.getVictoryCount() == 11)
        {
            setFlag("hasTalkedToDinosaur");
        }

        //getNPC(4).setIsHidden(false);
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty())
        {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
