package Maps;

import Level.Map;
//import Tilesets.QuadTileset;
import Tilesets.TestTileset;
import Utils.Point;

public class CombatMap extends Map 
{
    public CombatMap()
    {
        super("combat_screen.txt", new TestTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
