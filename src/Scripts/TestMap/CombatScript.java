package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class CombatScript extends Script<NPC>{


    //This runs first and the start
    @Override
    protected void setup() {
        lockPlayer();
        PlayLevelScreen.combatScreenPopup();
    }

    //This runs at the end
    @Override
    protected void cleanup() {
        unlockPlayer();
    }

    //This constantly runs and needs to use ENUMS to determine if script is still running or not
    @Override
    protected ScriptState execute() {
        start();

        return ScriptState.COMPLETED;
    }
    
}
