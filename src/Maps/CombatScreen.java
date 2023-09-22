package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class CombatScreen extends Map 
{
    public CombatScreen()
    {
        super("combat_screen.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
