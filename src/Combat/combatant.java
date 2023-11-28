package Combat;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage; 
import Engine.ImageLoader;
import java.security.SecureRandom; 
import GameObject.Sprite;

import Engine.ImageLoader;




public class combatant extends attack {

    SecureRandom random = new SecureRandom();

    private attack move1;
    private attack move2;
    private attack move3;

    private BufferedImage battleImage;  
    //private BufferedImage enemyImage;

    private boolean alive; 

    private String name;

    protected int health;  //health stat
    private int maxHealth;
    private int defence; //overall defence stat, CANNOT EXCEED 100! (probably limit to 50 max)
    private int athletic; //sports attk stat
    private int academic; //study attk stat
    private int engaged; //social attk stat


    public combatant () //blank constructor, assume player
    {
        //System.out.println("Player combatbant intirialized");
        this.alive = true;
        this.health = 100;

        this.move1 = new attack("Hockey Hurricane",atkType.SPORTS,3);
        this.move2 = new attack("SPB Bodyslam",atkType.SOCIAL,3);
        this.move3 = new attack("Study Session Slam",atkType.STUDY,3);

        this.maxHealth = 100;
        this.defence = 15;
        this.athletic = 15;
        this.academic = 15;
        this.engaged = 15;


        this.battleImage = ImageLoader.load("combatBoomer.png");
        this.name = "Boomer";

    }

    public combatant (String enemyName) //rank of generic oponent, determines stats
    {
        int rank = 1;

        switch(enemyName)
        {
            case "random":
                rank = 1;
                this.name = "Enemy";
                this.move1 = new attack("generic sport attk",atkType.SPORTS,3);
                this.move2 = new attack("generic social attk",atkType.SOCIAL,3);
                this.move3 = new attack("generic study attk",atkType.STUDY,3);


                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "robot":

                rank = 1;
                this.name = "CyberBobcat";
                this.move1 = new attack("Esport Execution",atkType.SPORTS,5);
                this.move2 = new attack("Discord Double-kick",atkType.SOCIAL,3);
                this.move3 = new attack("StackOverflow skimming",atkType.STUDY,3);


                this.battleImage = ImageLoader.load("robotCombat.png");

                this.maxHealth = 50 * rank;
                this.defence = 5 * rank;
                this.athletic = 5 * rank;
                this.academic = 5 * rank;
                this.engaged = 5 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "alex":

                rank = 2;
                this.name = "Professor Alex";
                this.move1 = new attack("Git Guillotine",atkType.SPORTS,5);
                this.move2 = new attack("Comedy Tickets",atkType.SOCIAL,1);
                this.move3 = new attack("StackOverflow skimming",atkType.STUDY,1);


                this.battleImage = ImageLoader.load("battleAlex.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "student":
                rank = 2;
                this.name = "Student p^q";
                this.move1 = new attack("Iteration Impact",atkType.SPORTS,2);
                this.move2 = new attack("Truth Table Teamwork",atkType.SOCIAL,2);
                this.move3 = new attack("Study for all E in Q",atkType.STUDY,2);


                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.battleImage = ImageLoader.load("battleStudent.png");

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "herscovici":

                rank = 2;
                this.name = "Professor Herscovici";
                this.move1 = new attack("Iteration Impact",atkType.SPORTS,3);
                this.move2 = new attack("Recursion Retaliation",atkType.SOCIAL,1);
                this.move3 = new attack(" (p^q) = true... ",atkType.STUDY,6);

                this.battleImage = ImageLoader.load("battleHerscovivi.png");


                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "chef":

                rank = 2;
                this.name = "Coding Cuisiner";
                this.move1 = new attack("Fruit by the Foot",atkType.SPORTS,2);
                this.move2 = new attack("Chocolate Almond Chop",atkType.SOCIAL,4);
                this.move3 = new attack("Chip Bag Kick ",atkType.STUDY,1);

                this.battleImage = ImageLoader.load("battleChef.png");


                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "blake":

                rank = 3;
                this.name = "Professor Blake";
                this.move1 = new attack("Office-Hours Annihalation",atkType.SPORTS,6);
                this.move2 = new attack("Snacktime Smack",atkType.SOCIAL,2);
                this.move3 = new attack("*too busy walking all the way to his office*",atkType.STUDY,0);


                this.battleImage = ImageLoader.load("battleBlake.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "julia":

                rank = 3;
                this.name = "Hello Kitty";
                this.move1 = new attack("Research Shakedown",atkType.SPORTS,3);
                this.move2 = new attack("Procreate Punch",atkType.SOCIAL,2);
                this.move3 = new attack("Neko-Neko Nuclear!",atkType.STUDY,8);


                this.battleImage = ImageLoader.load("battleJulia.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "peter":

                rank = 3;
                this.name = "Peter";
                this.move1 = new attack("Research Shakedown",atkType.SPORTS,3);
                this.move2 = new attack("Procreate Punch",atkType.SOCIAL,2);
                this.move3 = new attack("Neko-Neko Nuclear!",atkType.STUDY,8);

                this.battleImage = ImageLoader.load("battlePeter.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "drj":

                rank = 3;
                this.name = "Doctor J";
                this.move1 = new attack("Object-Oriented Punch",atkType.SPORTS,3);
                this.move2 = new attack("Eclipse Explosion",atkType.SOCIAL,7);
                this.move3 = new attack("Paper notes ONLY!!!",atkType.STUDY,3);

                this.battleImage = ImageLoader.load("battleDrJ.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "construction":

                rank = 3;
                this.name = "Quad Construction";
                this.move1 = new attack("5 AM Demolition",atkType.SPORTS,7);
                this.move2 = new attack("Tennis-Court Teardown",atkType.SOCIAL,2);
                this.move3 = new attack("OSHA Obliteration",atkType.STUDY,4);

                this.battleImage = ImageLoader.load("battleConstruction.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;

            case "judy":

                rank = 3;
                this.name = "Overlord Olian";
                this.move1 = new attack("charging her tesla...",atkType.SPORTS,0);
                this.move2 = new attack("VEHICULAR MANSLAUGHTER",atkType.SOCIAL,10);
                this.move3 = new attack("PRESIDENTIAL PUNISHMENT",atkType.STUDY,5);

                this.battleImage = ImageLoader.load("battleJudy.png");

                this.maxHealth = 25 * rank;
                this.defence = 3 * rank;
                this.athletic = 3 * rank;
                this.academic = 3 * rank;
                this.engaged = 3 * rank;

                this.alive = true;
                this.health = this.maxHealth;

                break;
        }
    }


    public void attacking(int moveNum, combatant target)
    {

        //generates random value from 1 to 3
        int atkSeed = random.nextInt(2) + 1;

        //target takes damage basec on (stat + movePower) * atkSeed* ((100 - target.defence/100))

        switch (moveNum)
        {
            case 1: //move 1 selected, sport
            target.takeDamage((this.athletic + move1.getAtkPower()) * atkSeed);
            break;

            case 2: //move 2 selected, social
            target.takeDamage((this.engaged + move2.getAtkPower()) * atkSeed) ;
            break;

            case 3: //move 3 selected, study
            target.takeDamage((this.academic + move3.getAtkPower()) * atkSeed) ;
            break;
        }
    }

    public boolean isAlive()
    {
        return this.alive;
    }

    public void takeDamage (int damage)
    {
        
        //buffer from defence

        int buffer = (int) (((100 - this.defence) / 100.0) * 100);

        //System.out.println("taking buffer!" + buffer);

        //damage *= (100 - this.defence / 100.0);

        damage = (int) (damage * (buffer / 100.0));

        //System.out.println("taking damage!" + damage);

        this.health = this.health - damage;

        //System.out.println("Health remainging:" + health);
        if (this.health <= 0)
        {
            this.alive = false;
            this.health = 0;
        }
    }


    public int getDefence()
    {
        return this.defence;
    } 
 
    public BufferedImage getBattleImage(){
        return battleImage;
    } 


    public void maxHeal()
    {
        this.health = this.maxHealth;
    }


    // public String getEntityName(){
    //     return this.name;
    // }


    //calls upgrade to the combatant's move
    public void upgradeMove(int moveNum)
    {
        switch (moveNum)
        {
            case 1:
                this.move1.upgradeAtkPower();
                break;

            case 2:
                this.move2.upgradeAtkPower();
                break;

            case 3:
                this.move3.upgradeAtkPower();
                break;
        }
    } 

   

    public int getHealth() {
        return this.health;
    } 


    public String moveName1(){
        return move1.getAtkName();
    } 

    public String moveName2(){
        return move2.getAtkName();
    }  

    public String moveName3(){
        return move3.getAtkName();
    } 

    public String getName() {
        return name;
    }

    

    // public String getMoveName(int moveSelec){
    //     switch(moveSelec){
    //         case 1: {
    //             return move1.getAtkName(); 
    //             break;
    //         }   
    //         case 2:{
    //             move2.getAtkName(); 
    //             break;
    //         } 
    //         default: {
    //             move3.getAtkName(); 
    //         }

            
    //     }
    // }


}
