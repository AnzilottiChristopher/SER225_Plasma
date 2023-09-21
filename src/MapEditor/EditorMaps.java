package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TheQuadMap;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("TheQuad");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {

            case "TheQuad":
                return new TheQuadMap();
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
