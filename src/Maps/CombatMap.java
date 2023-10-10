package Maps;

import Level.Map;
import Tilesets.CombatTileset;
//import Tilesets.QuadTileset;
//import Tilesets.TestTileset;
import Utils.Point;

public class CombatMap extends Map 
{
    public CombatMap()
    {
        super("combat_screen.txt", new CombatTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
