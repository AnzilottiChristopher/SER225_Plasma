package Combat; 

/**
 * this is essentially a "main" class for runnign the combat between 2 objects of the combatant class
 */

import java.security.SecureRandom;


public class combatRounds {

    SecureRandom random = new SecureRandom();
    
    private combatant playerObj;
    private combatant opponentObj;
    private int round;
    private static int moveSelec;

    public combatRounds(combatant playerObj,combatant opponentObj)
    {
        this.playerObj = playerObj;
        this.opponentObj = opponentObj;
    }

    public boolean updateCombat() //returns boolean, true = player wins, false = player loses
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
        //either tie, player wins, opponent wins.

        return true;
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
