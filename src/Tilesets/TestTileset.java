package Tilesets;

import Builders.MapTileBuilder;
import Engine.ImageLoader;
import Level.Tileset;



import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class TestTileset extends Tileset {

//MASTER TILESET for TestMap. For organization purposes, this tileset calls on other tilesets to get its tiles
//THIS TILESET SHOULD DEFINE NO TILES!

public TestTileset() {
        super(ImageLoader.load("TestTileset.png"), 16, 16, 3);
        
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        //add basic tiles
        // Call the QuadTileset method to get the list of quad tiles
        BasicTileset basicTileset = new BasicTileset();
        ArrayList<MapTileBuilder> basicTiles = basicTileset.BasicTileset();
        mapTiles.addAll(basicTiles);

        //add Quad Tileset
        // Call the QuadTileset method to get the list of quad tiles
        QuadTileset quadTileset = new QuadTileset();
        ArrayList<MapTileBuilder> quadTiles = quadTileset.QuadTileset();
        mapTiles.addAll(quadTiles);
        

        return mapTiles;
    }//end TestTileset();

    
}// end class
