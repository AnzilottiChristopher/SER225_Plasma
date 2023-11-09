package Scripts.TestMap;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Engine.Music;

public class DoorScript extends Script<NPC> {

        //This runs first and the start
        @Override
        protected void setup() {
            lockPlayer();
            showTextbox(); 
            setFlag("TeleportCompleted");
            unsetFlag("PlayerHasTeleportedBack");
            //setFlag("Teleported2");
            
            
        }
    
        //This runs at the end
        @Override
        protected void cleanup() {
            unlockPlayer();
            hideTextbox();
            setFlag("TeleportCompleted");
            unsetFlag("PlayerHasTeleportedBack");
            //setFlag("Teleported2");
           
        }
    
        //This constantly runs and needs to use ENUMS to determine if script is still running or not
        @Override
        protected ScriptState execute() {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
            return ScriptState.COMPLETED;
        }
           
 }
    

