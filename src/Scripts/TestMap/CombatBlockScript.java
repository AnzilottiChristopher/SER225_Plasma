package Scripts.TestMap;

import Engine.Music;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Utils.Direction;


public class CombatBlockScript extends Script<NPC> {


    int caseNum;

    public CombatBlockScript(int caseNum)
    {
        this.caseNum = caseNum;
    }

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        System.out.println(PlayLevelScreen.getVictoryCount());
        switch(PlayLevelScreen.getVictoryCount())
        {
            case 0: //robot 1
                addTextToTextboxQueue("I feel like I'm forgetting something...");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("oh! That robot is waving to me!");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("I'm being attacked!");
                break;

            case 1: //robot 2
                addTextToTextboxQueue("Another student! robot? BOTH??!");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("I'm being attacked!");
                break;
            case 2: //alex
                break;

            case 3: //herscovici grunt 1 
                addTextToTextboxQueue("It's not a robot student");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("They keep saying...");
                addTextToTextboxQueue("truth tables?");
                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
                break;

            case 4: //herscovici grunt 2
                addTextToTextboxQueue("Maybe this student can tell me what's up");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue(" if p equals q OR m...");
                addTextToTextboxQueue("and what...");
                addTextToTextboxQueue("Boomer will be defeated?");
                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
                break;
        }
    }

    @Override
    protected void cleanup() {
        hideTextbox();

        //start combat!
        setFlag("hasTalkedToDinosaur");
        if (caseNum == 0)
        {
            setFlag("Enemy1");
            setFlag("RoboEnemyStart");
        }
        if (caseNum == 1)
        {
            setFlag("Enemy2");
            setFlag("RoboEnemyStart");
        }

        if (caseNum == 3)
        {
            setFlag("Enemy4");
            setFlag("PQEnemyStart");
        }

        if (caseNum == 4)
        {
            setFlag("Enemy5");
            setFlag("PQEnemyStart");
        }


        unlockPlayer();
    }

    @Override
    public ScriptState execute() {

        //System.out.println("CombatBlockScript.execute() running");
    
        if (PlayLevelScreen.getVictoryCount() == caseNum)
        {
            start();

            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }

            end();
        }

        return ScriptState.COMPLETED;
       
    }
    
}
