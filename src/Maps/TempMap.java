package Maps;
import java.util.ArrayList;

import EnhancedMapTiles.OutOfBoundsCollision;
import EnhancedMapTiles.PushableRock;
import Enums.CollisionState;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import NPCs.Door;
import Scripts.TestMap.DoorScript2;
import Scripts.TestMap.DoorScript;
import Tilesets.CombatTileset;
//import Tilesets.QuadTileset;
//import Tilesets.TestTileset;
import Utils.Point;


public class TempMap extends Map {

    public TempMap()
    {
        super("temp_map.txt", new CombatTileset());
        this.playerStartPosition = new Point(70, 110);
        
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        
        
        Door door= new Door(5,getMapTile(5,10).getLocation());
        door.setInteractScript(new DoorScript2());
        npcs.add(door);
         



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
