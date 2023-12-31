package MapEditor;

import Level.Map;
import Maps.CombatMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.TempMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TempMap");
            add("TitleScreen");
            add("CombatScreen");
            //add("StudentCenter");
            
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TempMap":
                return new TempMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "CombatScreen":
                return new CombatMap();
            //case "StudentCenter":
                //return new StudentCenterMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
