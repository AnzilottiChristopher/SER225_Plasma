package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.CombatScreen;

public class CombatScript extends Script<NPC>{

    protected CombatScreen combatScreen;

    //This runs first and the start
    @Override
    protected void setup() {
        lockPlayer();
        //combatScreen = new CombatScreen(this);

    }

    //This runs at the end
    @Override
    protected void cleanup() {
        
    }

    //This constantly runs and needs to use ENUMS to determine if script is still running or not
    @Override
    protected ScriptState execute() {
        return ScriptState.COMPLETED;
    }
    
}
