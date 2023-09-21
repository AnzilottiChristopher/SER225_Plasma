package Maps;

import Level.Map;
import Tilesets.QuadTileset;

public class TheQuadMap extends Map 
{
    public TheQuadMap() {
        super("the_quad.txt", new QuadTileset());
        this.playerStartPosition = getMapTile(5, 5).getLocation();
    }
}