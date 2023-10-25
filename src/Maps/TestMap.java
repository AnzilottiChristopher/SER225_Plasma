package Maps;

import EnhancedMapTiles.OutOfBoundsCollision;
import EnhancedMapTiles.PushableRock;
import Enums.CollisionState;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.JudyAndCar;
import NPCs.Walrus;
import NPCs.Jukebox;
import NPCs.Door;
import Scripts.SimpleTextScript;
import Scripts.TestMap.CombatScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.JudyAndCarScript;
import Scripts.TestMap.DoorScript;

import Scripts.TestMap.JukeboxScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.JudyAndCarScript;
//import Tilesets.CommonTileset;
import Tilesets.TestTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new TestTileset());
        this.playerStartPosition = getMapTile(79, 110).getLocation();
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

        Door door= new Door(5,getMapTile(71,114).getLocation());
        door.setInteractScript(new DoorScript());
        npcs.add(door);
         

        JudyAndCar judycar = new JudyAndCar(4, getMapTile(40, 61).getLocation());
        //judycar.setExistenceFlag("hasTalkedToJudyCar");
        judycar.setInteractScript(new JudyAndCarScript());
        npcs.add(judycar);


        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
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

