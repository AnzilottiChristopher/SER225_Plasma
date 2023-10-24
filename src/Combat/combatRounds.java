package Combat;

import java.security.SecureRandom;
import Combat.combatStatus;


public class combatRounds {

    SecureRandom random = new SecureRandom();
    
    private combatant playerObj;
    private combatant opponentObj;
    private int round;
    private static int moveSelec;
    private combatStatus status;

    public combatRounds(combatant playerObj,combatant opponentObj)
    {
        this.playerObj = playerObj;
        this.opponentObj = opponentObj;
        this.status = combatStatus.PROGRESS;
    }

    public combatStatus updateCombat() //returns boolean, true = player wins, false = player loses
    {
        if(playerObj.isAlive() && opponentObj.isAlive())
       {    
            //System.out.println("COMBAT HAPPENING");
            //System.out.println("combat's move :" + moveSelec);

        
            //System.out.println("combatRounds move" + moveSelec);
            //FIGURE OUT INPUTS FROM COMBAT SCREEN
            if(moveSelec != 0)
            {

                //random enemy input
                int enemyMove = (random.nextInt(0,3)) + 1;

                //deal damages & let player see what happened
                playerObj.attacking(moveSelec, opponentObj);
                opponentObj.attacking(enemyMove, playerObj);

                System.out.println(playerObj.getHealth() +" : "+ opponentObj.getHealth());

                setMoveSelec(0);
            }
           
        

        }


        //player won!
        if (playerObj.isAlive() && !opponentObj.isAlive())
        {
            status = combatStatus.WIN;
        }

        if (!playerObj.isAlive() && opponentObj.isAlive())
        {
            status =  combatStatus.LOSS;
        }

        if (!playerObj.isAlive() && !opponentObj.isAlive())
        {
            status = combatStatus.TIE;
        }


        //either tie, player wins, opponent wins, or progress
        return  status;
    }


    public static void setMoveSelec(int setMove) {
        moveSelec = setMove;
    }

    public int getMoveSelec() {
        return moveSelec;
    }

    // public void takeInput(int moveSelec)
    // {
    //     this.moveSelec = moveSelec;
    // }
}
