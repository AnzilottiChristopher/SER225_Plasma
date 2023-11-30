package Maps;

import EnhancedMapTiles.OutOfBoundsCollision;
import EnhancedMapTiles.PushableRock;
import EnhancedMapTiles.SleepWall;
import Enums.CollisionState;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.*;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
//import Tilesets.CommonTileset;
import Tilesets.TestTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {


    public TestMap() {
        super("test_map.txt", new TestTileset());
        this.playerStartPosition = getMapTile(64, 25).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        CollisionState placement = CollisionState.LEFTSIDE;
        PushableRock pushableRock = new PushableRock(getMapTile(70, 115).getLocation());
        OutOfBoundsCollision wall = new OutOfBoundsCollision(getMapTile(13, 19).getLocation());
        OutOfBoundsCollision bottomWall = new OutOfBoundsCollision(getMapTile(13, 122).getLocation());
        OutOfBoundsCollision.side = CollisionState.LEFTSIDE;
        OutOfBoundsCollision leftSide = new OutOfBoundsCollision(getMapTile(13, 19).getLocation(), placement);
        placement = CollisionState.RIGHTSIDE;
        OutOfBoundsCollision.side = CollisionState.RIGHTSIDE;
        OutOfBoundsCollision rightSide = new OutOfBoundsCollision(getMapTile(114, 19).getLocation(), placement);


        SleepWall sleepWall = new SleepWall(getMapTile(40, 80).getLocation());

        sleepWall.setExistenceFlag("Boss3Complete");


        enhancedMapTiles.add(sleepWall);

        enhancedMapTiles.add(wall);
        enhancedMapTiles.add(bottomWall);
        enhancedMapTiles.add(pushableRock);
        enhancedMapTiles.add(leftSide);
        enhancedMapTiles.add(rightSide);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

//        Walrus walrus = new Walrus(1, getMapTile(70, 110).getLocation().subtractY(40));
//        walrus.setInteractScript(new WalrusScript());
//        npcs.add(walrus);
//
//        Dinosaur dinosaur = new Dinosaur(2, getMapTile(65, 110).getLocation());
//        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
//        dinosaur.setInteractScript(new DinoScript());
        //dinosaur.setInteractScript(new CombatScript());
        //npcs.add(dinosaur);

        // Jukebox jukebox = new Jukebox(3, getMapTile(70, 113).getLocation());
        // jukebox.setInteractScript(new JukeboxScript());
        // npcs.add(jukebox);

        Door door= new Door(3,getMapTile(113,23).getLocation());
        door.setInteractScript(new DoorScript());
        npcs.add(door);

        Door door2=new Door(104,getMapTile(20,99).getLocation());
        door2.setInteractScript(new DoorScript());
        npcs.add(door2);

        Door door3=new Door(109,getMapTile(86,103).getLocation());
        door3.setInteractScript(new DoorScript());
        npcs.add(door3);

        Door door4=new Door(101,getMapTile(86,117).getLocation());
        door4.setInteractScript(new DoorScript());
        npcs.add(door4);

        Door door5=new Door(110,getMapTile(21,48).getLocation());
        door4.setInteractScript(new DoorScript());
        npcs.add(door5);

         

        JudyAndCar judycar = new JudyAndCar(4, getMapTile(40, 61).getLocation());
        //judycar.setExistenceFlag("hasTalkedToJudyCar");
        judycar.setInteractScript(new JudyAndCarScript());
        judycar.setIsHidden(true);
        npcs.add(judycar);


        //Adding The Alex Boss
        AlexBoss alexBoss = new AlexBoss(5,getMapTile(112, 22).getLocation());
        alexBoss.setInteractScript(new AlexScript());
        npcs.add(alexBoss);

        //Adding enemies
        EnemyRobot enemyRobot1 = new EnemyRobot(6, getMapTile(97, 20).getLocation());
        enemyRobot1.setInteractScript(new EnemyScript());
        npcs.add(enemyRobot1);

        EnemyRobot enemyRobot2 = new EnemyRobot(7, getMapTile(102, 20).getLocation());
        enemyRobot2.setInteractScript(new EnemyScript());
        npcs.add(enemyRobot2);

        //Adding a student
        Student student = new Student(8, getMapTile(80, 22).getLocation());
        student.setInteractScript(new NessInteraction());
        npcs.add(student);

        JudyGrunt judyGruntOne = new JudyGrunt(50, getMapTile(44, 68).getLocation());
        judyGruntOne.setInteractScript(new JudyGruntScript());
        judyGruntOne.setIsHidden(true);
        npcs.add(judyGruntOne);

        JudyGrunt judyGruntTwo = new JudyGrunt(51, getMapTile(44, 73).getLocation());
        judyGruntTwo.setInteractScript(new JudyGruntScript());
        judyGruntTwo.setIsHidden(true);
        npcs.add(judyGruntTwo);



        for (int counter = 0; counter < 14; counter++)//9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22
        {
            StudentWall studentWall;
            if (counter % 2 == 0)
            {
                CollisionState girl = CollisionState.GIRL;
                studentWall = new StudentWall(9 + counter, getMapTile(64 + (counter * 2), 28).getLocation(), girl);
                if (counter < 8)
                {
                    studentWall.setExistenceFlag("Boss1Complete");
                }
            } else
            {
                studentWall = new StudentWall(9 + counter, getMapTile(64 + (counter * 2), 28).getLocation());
                if (counter < 8)
                {
                    studentWall.setExistenceFlag("Boss1Complete");
                }
            }
            studentWall.setInteractScript(new WallScript());
            npcs.add(studentWall);
        } //ID counter at 21

        for (int counter = 0; counter < 5; counter++) //22, 23, 24, 25, 26
        {
            StudentWallLeft left;
            if (counter % 2 == 0)
            {
                CollisionState girl = CollisionState.GIRL;
                left = new StudentWallLeft(22 + counter, getMapTile(63, 19 + (counter * 2)).getLocation(), girl);
            } else
            {
                left = new StudentWallLeft(22 + counter, getMapTile(63, 19 + (counter * 2)).getLocation());
            }
            left.setExistenceFlag("Boss1Complete");
            left.setInteractScript(new WallScript());
            npcs.add(left);
        } //ID counter at 25 or 26 not sure

        HerscoviciBoss herscovici = new HerscoviciBoss(200, getMapTile(14, 76).getLocation());
        herscovici.setInteractScript(new HerscoviciScript());

        CollisionState girl = CollisionState.GIRL;
        Boss2Enemy boss2Enemy1 = new Boss2Enemy(27, getMapTile(18, 74).getLocation());
        Boss2Enemy boss2Enemy2 = new Boss2Enemy(28, getMapTile(23, 74).getLocation(), girl);
        boss2Enemy2.setInteractScript(new HerscoviciEnemyScript());
        boss2Enemy1.setInteractScript(new HerscoviciEnemyScript());

        boss2Enemy1.setIsHidden(true);
        boss2Enemy2.setIsHidden(true);
        herscovici.setIsHidden(true);

        npcs.add(herscovici);
        npcs.add(boss2Enemy1);
        npcs.add(boss2Enemy2);



        Blake blake = new Blake(39, getMapTile(21, 47).getLocation());
        blake.setInteractScript(new BlakeScript());
        blake.setIsHidden(true);
        npcs.add(blake);

        DrJ j = new DrJ(40, getMapTile(85, 109).getLocation());
        j.setInteractScript(new DrJScript());
        j.setIsHidden(true);
        npcs.add(j);

        Chef chef = new Chef(41, getMapTile(30, 37).getLocation());
        chef.setInteractScript(new EnemyScript());
        chef.setIsHidden(true);
        npcs.add(chef);

        Chef chef2 = new Chef(42, getMapTile(35, 32).getLocation());
        chef2.setInteractScript(new EnemyScript());
        chef2.setIsHidden(true);
        npcs.add(chef2);

        Peter peter = new Peter(43, getMapTile(79, 105).getLocation());
        peter.setInteractScript(new EnemyScript());
        peter.setIsHidden(true);
        npcs.add(peter);

        HelloKitty kitty = new HelloKitty(44, getMapTile(79, 114).getLocation());
        kitty.setInteractScript(new EnemyScript());
        kitty.setIsHidden(true);
        npcs.add(kitty);

        ONeill oneill = new ONeill(44, getMapTile(67, 35).getLocation());
        oneill.setInteractScript(new ONeillScript());
        npcs.add(oneill);

        //Quad details
        //Lamps on walk up to echlin
        Lamp lamp1 = new Lamp(1001, getMapTile(40, 73).getLocation());
        npcs.add(lamp1);

        Lamp lamp17 = new Lamp(1001, getMapTile(40, 66).getLocation());
        npcs.add(lamp17);

        Lamp lamp18 = new Lamp(1001, getMapTile(40, 56).getLocation());
        npcs.add(lamp18);

        Lamp lamp19 = new Lamp(1001, getMapTile(40, 46).getLocation());
        npcs.add(lamp19);

        //Lamps at corner of student center
        Lamp lamp2 = new Lamp(1001, getMapTile(43, 94).getLocation());
        npcs.add(lamp2);

        Lamp lamp16 = new Lamp(1001, getMapTile(43, 86).getLocation());
        npcs.add(lamp16);

        //Lamps on walk up from business to CCE
        Lamp lamp3 = new Lamp(1001, getMapTile(65, 73).getLocation());
        npcs.add(lamp3);

        Lamp lamp4 = new Lamp(1001, getMapTile(65, 60).getLocation());
        npcs.add(lamp4);

        Lamp lamp5 = new Lamp(1001, getMapTile(65, 50).getLocation());
        npcs.add(lamp5);

        Lamp lamp6 = new Lamp(1001, getMapTile(65, 40).getLocation());
        npcs.add(lamp6);

        //Lamp at walkway to residence halls
        Lamp lamp7 = new Lamp(1001, getMapTile(21, 115).getLocation());
        npcs.add(lamp7);

        Lamp lamp12 = new Lamp(1001, getMapTile(31, 118).getLocation());
        npcs.add(lamp12);

        Lamp lamp14 = new Lamp(1001, getMapTile(21, 104).getLocation());
        npcs.add(lamp14);

        //Lamps from student center to business
        Lamp lamp8 = new Lamp(1001, getMapTile(48, 96).getLocation());
        npcs.add(lamp8);

        Lamp lamp9 = new Lamp(1001, getMapTile(53, 96).getLocation());
        npcs.add(lamp9);

        Lamp lamp10 = new Lamp(1001, getMapTile(60, 96).getLocation());
        npcs.add(lamp10);

        Lamp lamp11 = new Lamp(1001, getMapTile(65, 96).getLocation());
        npcs.add(lamp11);

        Lamp lamp15 = new Lamp(1001, getMapTile(32, 101).getLocation());
        npcs.add(lamp15);

        //Lamp in between business and pathway to rec center
        Lamp lamp13 = new Lamp(1001, getMapTile(65, 118).getLocation());
        npcs.add(lamp13);

        //Lamps from middle of quad to CCE
        Lamp lamp20 = new Lamp(1001, getMapTile(45, 56).getLocation());
        npcs.add(lamp20);

        Lamp lamp21 = new Lamp(1001, getMapTile(54, 50).getLocation());
        npcs.add(lamp21);

        Lamp lamp22 = new Lamp(1001, getMapTile(59, 40).getLocation());
        npcs.add(lamp22);

        Lamp lamp23 = new Lamp(1001, getMapTile(62, 36).getLocation());
        npcs.add(lamp23);

        Tree tree1 = new Tree(1001, getMapTile(37, 73).getLocation());
        npcs.add(tree1);

        Tree tree6 = new Tree(1001, getMapTile(37, 69).getLocation());
        npcs.add(tree6);

        Tree tree2 = new Tree(1001, getMapTile(36, 50).getLocation());
        npcs.add(tree2);

        Tree tree3 = new Tree(1001, getMapTile(36, 40).getLocation());
        npcs.add(tree3);

        Tree tree4 = new Tree(1001, getMapTile(36, 35).getLocation());
        npcs.add(tree4);

        Tree tree7 = new Tree(1001, getMapTile(45, 73).getLocation());
        npcs.add(tree7);

        Tree tree8 = new Tree(1001, getMapTile(45, 69).getLocation());
        npcs.add(tree8);

        Tree tree9 = new Tree(1001, getMapTile(45, 50).getLocation());
        npcs.add(tree9);

        Tree tree10 = new Tree(1001, getMapTile(45, 40).getLocation());
        npcs.add(tree10);

        Tree tree11 = new Tree(1001, getMapTile(45, 35).getLocation());
        npcs.add(tree11);

        Tree tree12 = new Tree(1001, getMapTile(53, 73).getLocation());
        npcs.add(tree12);

        Tree tree13 = new Tree(1001, getMapTile(75, 96).getLocation());
        npcs.add(tree13);

        Tree tree14 = new Tree(1001, getMapTile(79, 101).getLocation());
        npcs.add(tree14);

        Tree tree15 = new Tree(1001, getMapTile(81, 105).getLocation());
        npcs.add(tree15);

        Tree tree16 = new Tree(1001, getMapTile(81, 112).getLocation());
        npcs.add(tree16);

        Tree tree17 = new Tree(1001, getMapTile(80, 117).getLocation());
        npcs.add(tree17);

        SleepingStudent sleep = new SleepingStudent(45, getMapTile(19, 69).getLocation());
        sleep.setInteractScript(new SleepingStudentScript());
        npcs.add(sleep);

        EclipseStudent eclipse = new EclipseStudent(46, getMapTile(65, 109).getLocation());
        eclipse.setInteractScript(new EclipseStudentScript());
        npcs.add(eclipse);
        
        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        //3000 to 79 ratio X value
        triggers.add(new Trigger(3850, 500, 50, 1000, new StudentScript(), "hasStartedGame"));
        triggers.add(new Trigger(1000, 2500, 6000, 50, new MoveNPC(), "hasPassed"));

        triggers.add(new Trigger(400, 3500, 6000, 50, new SecondCutscene(), "Boss2Pass"));
        triggers.add(new Trigger(1210, 3500, 50, 1000, new SecondCutscene(), "Boss2Pass"));

        triggers.add(new Trigger(1800, 4000, 6000, 50, new ThirdCutscene(), "Boss3Pass"));
        triggers.add(new Trigger(1700, 4800, 8000, 50, new FourthCutscene(), "Boss4Pass"));
//        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));

        //enemy vicCount = 0 trigger , robot 1
        triggers.add(new Trigger(4670, 800, 100, 1000, new CombatBlockScript(0), "Enemy1"));
        triggers.add(new Trigger(4900, 800, 100, 1000, new CombatBlockScript(1), "Enemy2"));
        
        //2 is alex, no trigger

        //first herscovici enemy
        triggers.add(new Trigger(210, 3500, 1000, 400, new CombatBlockScript(3), "Enemy4"));
        triggers.add(new Trigger(210, 3550, 800, 400, new CombatBlockScript(4), "Enemy5"));

        //5 is hersovici, no trigger

        //chefs
        triggers.add(new Trigger(1300, 1400, 600, 300, new CombatBlockScript(6), "Enemy7"));
        triggers.add(new Trigger(1300, 1600, 380, 300, new CombatBlockScript(7), "Enemy8"));

        //8 is blake, no trigger

        //SOB grunts
        triggers.add(new Trigger(3600, 5300, 300, 300, new CombatBlockScript(9), "Enemy10"));
        triggers.add(new Trigger(3600, 5000, 300, 300, new CombatBlockScript(10), "Enemy11"));

        //11 is Dr J, no trigger

        //construction workers
        triggers.add(new Trigger(2000, 3200, 400, 300, new CombatBlockScript(12), "Enemy13"));
        triggers.add(new Trigger(2000, 3500, 380, 200, new CombatBlockScript(13), "Enemy14"));

        //JUDY! enemy index 14, no trigger
        

        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());

        getMapTile(101,25).setInteractScript(new SimpleTextScript("CCE"));

        getMapTile(88,108).setInteractScript(new SimpleTextScript("School of Business "));

        getMapTile(88,112).setInteractScript(new SimpleTextScript("School of Business"));

        getMapTile(23,98).setInteractScript(new SimpleTextScript("Student Center"));

        getMapTile(20,49).setInteractScript(new SimpleTextScript("Tator Hall"));

        getMapTile(29,22).setInteractScript(new SimpleTextScript("Buckman"));
    }
}

