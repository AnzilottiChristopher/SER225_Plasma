package Maps;

import EnhancedMapTiles.OutOfBoundsCollision;
import EnhancedMapTiles.PushableRock;
import Enums.CollisionState;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.*;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Scripts.TestMap.DoorScript;
import Scripts.TestMap.JudyAndCarScript;
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

        Walrus walrus = new Walrus(1, getMapTile(70, 110).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(65, 110).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        //dinosaur.setInteractScript(new CombatScript());
        npcs.add(dinosaur);

        // Jukebox jukebox = new Jukebox(3, getMapTile(70, 113).getLocation());
        // jukebox.setInteractScript(new JukeboxScript());
        // npcs.add(jukebox);

        Door door= new Door(3,getMapTile(71,114).getLocation());
        door.setInteractScript(new DoorScript());
        npcs.add(door);
         

        JudyAndCar judycar = new JudyAndCar(4, getMapTile(40, 61).getLocation());
        //judycar.setExistenceFlag("hasTalkedToJudyCar");
        judycar.setInteractScript(new JudyAndCarScript());
        npcs.add(judycar);


        //Adding The Alex Boss
        AlexBoss alexBoss = new AlexBoss(5,getMapTile(113, 22).getLocation());
        alexBoss.setInteractScript(new AlexScript());
        npcs.add(alexBoss);

        //Adding enemies
        EnemyRobot enemyRobot1 = new EnemyRobot(6, getMapTile(90, 21).getLocation());
        enemyRobot1.setInteractScript(new EnemyScript());
        npcs.add(enemyRobot1);

        EnemyRobot enemyRobot2 = new EnemyRobot(7, getMapTile(105, 21).getLocation());
        enemyRobot2.setInteractScript(new EnemyScript());
        npcs.add(enemyRobot2);

        //Adding a student
        Student student = new Student(8, getMapTile(80, 22).getLocation());
        student.setInteractScript(new studentInteraction());
        npcs.add(student);

        for (int counter = 0; counter < 26; counter++)
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
        } //ID counter at 34

        for (int counter = 0; counter < 5; counter++)
        {
            StudentWallLeft left;
            if (counter % 2 == 0)
            {
                CollisionState girl = CollisionState.GIRL;
                left = new StudentWallLeft(34 + counter, getMapTile(63, 19 + (counter * 2)).getLocation(), girl);
            } else
            {
                left = new StudentWallLeft(34 + counter, getMapTile(63, 19 + (counter * 2)).getLocation());
            }
            left.setExistenceFlag("Boss1Complete");
            left.setInteractScript(new WallScript());
            npcs.add(left);
        } //ID counter at 38



        Blake blake = new Blake(39, getMapTile(21, 47).getLocation());
        blake.setInteractScript(new BlakeScript());
        npcs.add(blake);

        DrJ j = new DrJ(40, getMapTile(74, 110).getLocation());
        j.setInteractScript(new DrJScript());
        npcs.add(j);

        Chef chef = new Chef(41, getMapTile(30, 37).getLocation());
        chef.setInteractScript(new EnemyScript());
        npcs.add(chef);

        Chef chef2 = new Chef(42, getMapTile(35, 32).getLocation());
        chef2.setInteractScript(new EnemyScript());
        npcs.add(chef2);

        Peter peter = new Peter(43, getMapTile(70, 105).getLocation());
        peter.setInteractScript(new EnemyScript());
        npcs.add(peter);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        //3000 to 79 ratio X value
        triggers.add(new Trigger(3850, 500, 50, 1000, new StudentScript(), "hasStartedGame"));
//        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

