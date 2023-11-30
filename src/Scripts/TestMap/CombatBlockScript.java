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

                //chef grunts
            case 6: 
                addTextToTextboxQueue("Those students are cooking");
                addTextToTextboxQueue("Can I have some?");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("The only thing I'll taste is defeat???");

                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
                break;

            case 7:
                addTextToTextboxQueue("Maybe this student will share!");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("Please???");

                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");

                break;

            case 9:
                addTextToTextboxQueue("Hi Julia!");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("Hello Kitty?");
                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
            break;

            case 10:
                addTextToTextboxQueue("Hi Peter!");
                addTextToTextboxQueue("...");
                addTextToTextboxQueue("Oh dear god, they got you too.");
                addTextToTextboxQueue("...");

                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
            break;

            case 12:
                addTextToTextboxQueue("They're always building something");
                addTextToTextboxQueue("...");

                addTextToTextboxQueue("OH MY GOD IM BEING ATTACKED");
            break;

            case 13:
                addTextToTextboxQueue("Maybe before building new first year housing");
                addTextToTextboxQueue("They should think about re-building ledges.");
                addTextToTextboxQueue("...");
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

        if (caseNum == 6)
        {
            setFlag("Enemy7");
            setFlag("chefEnemyStart");
        }

        if (caseNum == 7)
        {
            setFlag("Enemy8");
            setFlag("chefEnemyStart");
        }

        if (caseNum == 9)
        {
            setFlag("Enemy10");
            setFlag("sobEnemyStart");
        }

        if (caseNum == 10)
        {
            setFlag("Enemy11");
            setFlag("sobEnemyStart");
        }

        if (caseNum == 12)
        {
            setFlag("Enemy13");
            setFlag("constructionEnemyStart");
        }

        if (caseNum == 13)
        {
            setFlag("Enemy14");
            setFlag("constructionEnemyStart");
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
