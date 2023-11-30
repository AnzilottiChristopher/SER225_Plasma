package Maps;
import java.util.ArrayList;

import EnhancedMapTiles.OutOfBoundsCollision;
import EnhancedMapTiles.PushableRock;
import Enums.CollisionState;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import NPCs.AlexBoss;
import NPCs.Door;
import Scripts.TestMap.DoorScript2;
import Scripts.TestMap.AlexScript;
import Scripts.TestMap.DoorScript;
import Tilesets.CombatTileset;
import Tilesets.TestTileset;
//import Tilesets.QuadTileset;
//import Tilesets.TestTileset;
import Utils.Point;


public class TempMap extends Map {

    public TempMap()
    {
        super("temp_map.txt", new TestTileset());
        this.playerStartPosition = new Point(70, 110);
        
    }


     @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        OutOfBoundsCollision wall = new OutOfBoundsCollision(getMapTile(16,0).getLocation());
       // OutOfBoundsCollision.bottom=CollisionState.BOTTOM;
        OutOfBoundsCollision bottomWall = new OutOfBoundsCollision(getMapTile(0, 11).getLocation());
       


        enhancedMapTiles.add(wall);
        enhancedMapTiles.add(bottomWall);
        

        return enhancedMapTiles;
    }



    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        
        
        Door door= new Door(5,getMapTile(1,2).getLocation());
        door.setInteractScript(new DoorScript2());
        npcs.add(door);


        AlexBoss alexBoss = new AlexBoss(10,getMapTile(14, 5).getLocation());
        alexBoss.setInteractScript(new AlexScript());
        npcs.add(alexBoss);
         



        return npcs;
    }

   /*  @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        CollisionState placement = CollisionState.LEFTSIDE;
        OutOfBoundsCollision wall = new OutOfBoundsCollision(getMapTile(13, 19).getLocation());
        OutOfBoundsCollision bottomWall = new OutOfBoundsCollision(getMapTile(13, 122).getLocation());
        OutOfBoundsCollision.side = CollisionState.LEFTSIDE;
        OutOfBoundsCollision leftSide = new OutOfBoundsCollision(getMapTile(13, 19).getLocation(), placement);
        placement = CollisionState.RIGHTSIDE;
        OutOfBoundsCollision.side = CollisionState.RIGHTSIDE;
        OutOfBoundsCollision rightSide = new OutOfBoundsCollision(getMapTile(114, 19).getLocation(), placement);
        enhancedMapTiles.add(wall);
        enhancedMapTiles.add(bottomWall);
        enhancedMapTiles.add(leftSide);
        enhancedMapTiles.add(rightSide);

        return enhancedMapTiles;
    }*/
    
}
