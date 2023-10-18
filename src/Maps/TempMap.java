package Maps;
import Level.Map;
import Tilesets.CombatTileset;
//import Tilesets.QuadTileset;
//import Tilesets.TestTileset;
import Utils.Point;


public class TempMap extends Map {

    public TempMap()
    {
        super("temp_map.txt", new CombatTileset());
        this.playerStartPosition = new Point(1, 11);
        
    }
    
}
