package Scripts.TestMap;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Engine.Music;

public class DoorScript2 extends Script<NPC>{

    @Override
    protected void setup() {
        // TODO Auto-generated method stub
        lockPlayer();
            showTextbox(); 
            setFlag("Teleported2");
    }

    @Override
    protected void cleanup() {
        // TODO Auto-generated method stub
        unlockPlayer();
        hideTextbox();
        setFlag("Teleported2");
       
    }

    @Override
    protected ScriptState execute() {
        // TODO Auto-generated method stub
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
