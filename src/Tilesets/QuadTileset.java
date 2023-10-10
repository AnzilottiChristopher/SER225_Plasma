package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
// import GameObject.ImageEffect;
//import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;
//import java.util.Collection;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file

//QuadTileset are all path tilesets, not exclusive to Quad, but named after it cuz, you know, paths!
//and the tileset kinda looks like a funcky quad
public class QuadTileset extends Tileset {

        // public static Collection<? extends MapTileBuilder> QuadTileset() {
        //         return null;
        // }
        
        public ArrayList<MapTileBuilder> QuadTileset() {
                return this.defineTiles();
        }

    public QuadTileset() {
        super(ImageLoader.load("QuadTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // pathNS
        Frame pathNSframe = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathNStile = new MapTileBuilder(pathNSframe);

        mapTiles.add(pathNStile);

        // pathEW
        Frame pathEWframe = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathEWtile = new MapTileBuilder(pathEWframe);

        mapTiles.add(pathEWtile);

        // pathNEWS
        Frame pathNEWSframe = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathNEWStile = new MapTileBuilder(pathNEWSframe);

        mapTiles.add(pathNEWStile);
       
       // diagnal A

        Frame pathDiagframe1A = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1A = new MapTileBuilder(pathDiagframe1A);

        mapTiles.add(pathDiagTile1A);

        Frame pathDiagframe2A = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2A = new MapTileBuilder(pathDiagframe2A);

        mapTiles.add(pathDiagTile2A);

        Frame pathDiagframe3A = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3A = new MapTileBuilder(pathDiagframe3A);

        mapTiles.add(pathDiagTile3A);

        Frame pathDiagframe4A = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4A = new MapTileBuilder(pathDiagframe4A);

        mapTiles.add(pathDiagTile4A);

        //diagonal B
        Frame pathDiagframe1B = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1B = new MapTileBuilder(pathDiagframe1B);

        mapTiles.add(pathDiagTile1B);

        Frame pathDiagframe2B = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2B = new MapTileBuilder(pathDiagframe2B);

        mapTiles.add(pathDiagTile2B);

        Frame pathDiagframe3B = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3B = new MapTileBuilder(pathDiagframe3B);

        mapTiles.add(pathDiagTile3B);

        Frame pathDiagframe4B = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4B = new MapTileBuilder(pathDiagframe4B);

        mapTiles.add(pathDiagTile4B);

        //diagonal C

        Frame pathDiagframe1C = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1C = new MapTileBuilder(pathDiagframe1C);

        mapTiles.add(pathDiagTile1C);

        Frame pathDiagframe2C = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2C = new MapTileBuilder(pathDiagframe2C);

        mapTiles.add(pathDiagTile2C);

        Frame pathDiagframe3C = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3C = new MapTileBuilder(pathDiagframe3C);

        mapTiles.add(pathDiagTile3C);

        Frame pathDiagframe4C = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4C = new MapTileBuilder(pathDiagframe4C);

        mapTiles.add(pathDiagTile4C);

        Frame pathDiagframe5C = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile5C = new MapTileBuilder(pathDiagframe5C);

        mapTiles.add(pathDiagTile5C);

        Frame pathDiagframe6C = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile6C = new MapTileBuilder(pathDiagframe6C);

        mapTiles.add(pathDiagTile6C);

        //diag D

        Frame pathDiagframe1D = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1D  = new MapTileBuilder(pathDiagframe1D );

        mapTiles.add(pathDiagTile1D );

        Frame pathDiagframe2D  = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2D  = new MapTileBuilder(pathDiagframe2D );

        mapTiles.add(pathDiagTile2D );

        Frame pathDiagframe3D  = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3D  = new MapTileBuilder(pathDiagframe3D );

        mapTiles.add(pathDiagTile3D );

        Frame pathDiagframe4D  = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4D  = new MapTileBuilder(pathDiagframe4D );

        mapTiles.add(pathDiagTile4D );

        Frame pathDiagframe5D  = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile5D  = new MapTileBuilder(pathDiagframe5D );

        mapTiles.add(pathDiagTile5D );

        Frame pathDiagframe6D  = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile6D  = new MapTileBuilder(pathDiagframe6D );

        mapTiles.add(pathDiagTile6D );

        //diagonal F

        Frame pathDiagframe1F  = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1F  = new MapTileBuilder(pathDiagframe1F );

        mapTiles.add(pathDiagTile1F );

        Frame pathDiagframe2F  = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2F  = new MapTileBuilder(pathDiagframe2F );

        mapTiles.add(pathDiagTile2F );

        Frame pathDiagframe3F  = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3F  = new MapTileBuilder(pathDiagframe3F );

        mapTiles.add(pathDiagTile3F );

        Frame pathDiagframe4F  = new FrameBuilder(getSubImage(0, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4F  = new MapTileBuilder(pathDiagframe4F );

        mapTiles.add(pathDiagTile4F );

        Frame pathDiagframe5F  = new FrameBuilder(getSubImage(1, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile5F  = new MapTileBuilder(pathDiagframe5F );

        mapTiles.add(pathDiagTile5F );

        Frame pathDiagframe6F  = new FrameBuilder(getSubImage(2, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile6F  = new MapTileBuilder(pathDiagframe6F );

        mapTiles.add(pathDiagTile6F );

        //diagonal E

        Frame pathDiagframe1E  = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile1E  = new MapTileBuilder(pathDiagframe1E );

        mapTiles.add(pathDiagTile1E );

        Frame pathDiagframe2E  = new FrameBuilder(getSubImage(4, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile2E  = new MapTileBuilder(pathDiagframe2E );

        mapTiles.add(pathDiagTile2E );

        Frame pathDiagframe3E  = new FrameBuilder(getSubImage(5, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile3E  = new MapTileBuilder(pathDiagframe3E );

        mapTiles.add(pathDiagTile3E );

        Frame pathDiagframe4E = new FrameBuilder(getSubImage(3, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile4E  = new MapTileBuilder(pathDiagframe4E );

        mapTiles.add(pathDiagTile4E );

        Frame pathDiagframe5E  = new FrameBuilder(getSubImage(4, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile5E = new MapTileBuilder(pathDiagframe5E );

        mapTiles.add(pathDiagTile5E );

        Frame pathDiagframe6E  = new FrameBuilder(getSubImage(5, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathDiagTile6E  = new MapTileBuilder(pathDiagframe6E );

        mapTiles.add(pathDiagTile6E );
        
        //grass tiles, animating

        Frame[] grass1Frame = new Frame[] {
                new FrameBuilder(getSubImage(0, 7), 15)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 7), 15)
                        .withScale(tileScale)
                        .build(),
        };

        MapTileBuilder grass1Tile = new MapTileBuilder(grass1Frame);

        mapTiles.add(grass1Tile);

        Frame[] grass2Frame = new Frame[] {
                new FrameBuilder(getSubImage(2, 7), 15)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(3, 7), 15)
                        .withScale(tileScale)
                        .build(),
        };

        MapTileBuilder grass2Tile = new MapTileBuilder(grass2Frame);

        mapTiles.add(grass2Tile);

        Frame[] grass3Frame = new Frame[] {
                new FrameBuilder(getSubImage(4, 7), 15)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(5, 7), 15)
                        .withScale(tileScale)
                        .build(),
        };

        MapTileBuilder grass3Tile = new MapTileBuilder(grass3Frame);

        mapTiles.add(grass3Tile);
        

        //edge transitions
        Frame pathEdgeframe1  = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathEdgeTile1 = new MapTileBuilder(pathEdgeframe1 );

        mapTiles.add(pathEdgeTile1 );

        Frame pathEdgeframe2  = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathEdgeTile2 = new MapTileBuilder(pathEdgeframe2 );

        mapTiles.add(pathEdgeTile2 );

         Frame pathEdgeframe3  = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathEdgeTile3 = new MapTileBuilder(pathEdgeframe3 );

        mapTiles.add(pathEdgeTile3 );

        Frame pathEdgeframe4  = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathEdgeTile4 = new MapTileBuilder(pathEdgeframe4 );

        mapTiles.add(pathEdgeTile4 );

        //solid path, solid grass
        Frame pathFrame  = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder pathTile = new MapTileBuilder(pathFrame );

        mapTiles.add(pathTile);

        Frame grassFrame  = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame )
                .withTileType(TileType.NOT_PASSABLE);
        

        mapTiles.add(grassTile);


        return mapTiles;
    }




}
