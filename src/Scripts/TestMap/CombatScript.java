package Scripts.TestMap;

import Engine.Key;
import Engine.Keyboard;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class CombatScript extends Script{
    


    //This runs first and the start
    @Override
    protected void setup() {
        lockPlayer(); 
        setFlag("hasUsedMove");
       // if(Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0 && moveSelected != 0)
        addTextToTextboxQueue("Boomer used Hockey Hurricane!");
        
        //playLevelScreenState=PlayLevelScreenState.COMBATMODE;
        //PlayLevelScreen.combatScreenPopup();
    }

    //This runs at the end
    @Override
    protected void cleanup() {
        unlockPlayer(); 
        hideTextbox(); 
        
    }

    //This constantly runs and needs to use ENUMS to determine if script is still running or not
    @Override
    protected ScriptState execute() {
       //need a conditional if a move has been sued, so that the textbox can appear, then disappear
        // if(map.)
            start(); 
            if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }  

        end();
        return ScriptState.COMPLETED;
    }
    
}
