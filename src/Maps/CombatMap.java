package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class CombatMap extends Map 
{
    public CombatMap()
    {
        super("combat_screen.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
