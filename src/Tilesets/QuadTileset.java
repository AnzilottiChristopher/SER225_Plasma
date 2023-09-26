package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
// import GameObject.ImageEffect;
//import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file

//QuadTileset are all path tilesets, not exclusive to Quad, but named after it cuz, you know, paths!
//and the tileset kinda looks like a funcky quad
public class QuadTileset extends Tileset {

    public QuadTileset() {
        super(ImageLoader.load("QuadTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // Corner Tiles

        //NW corner (if you made a box of path, this would be the NW corner)
        Frame NWCornerFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder NWCornerTile = new MapTileBuilder(NWCornerFrame);

        mapTiles.add(NWCornerTile);

        //NE corner 
        Frame NECornerFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder NECornerTile = new MapTileBuilder(NECornerFrame);

        mapTiles.add(NECornerTile);

        //SW corner 
        Frame SWCornerFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder SWCornerTile = new MapTileBuilder(SWCornerFrame);

        mapTiles.add(SWCornerTile);

        //SE corner 
        Frame SECornerFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder SECornerTile = new MapTileBuilder(SECornerFrame);

        mapTiles.add(SECornerTile);
        
        //horizontal

        //left horizontal
         Frame LHorizontalFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder LHorizontalTile = new MapTileBuilder(LHorizontalFrame);

        mapTiles.add(LHorizontalTile);


        //center horizontal
         Frame CHorizontalFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder CHorizontalTile = new MapTileBuilder(CHorizontalFrame);

        mapTiles.add(CHorizontalTile);


        //right horizontal
        Frame RHorizontalFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder RHorizontalTile = new MapTileBuilder(RHorizontalFrame);

        mapTiles.add(RHorizontalTile);


        //vertical 

        //top vertical
         Frame TVerticalFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder TVerticalTile = new MapTileBuilder(TVerticalFrame);

        mapTiles.add(TVerticalTile);

        //middle vertical
         Frame MVerticalFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder MVerticalTile = new MapTileBuilder(MVerticalFrame);

        mapTiles.add(MVerticalTile);

        //bottom vertical
         Frame BVerticalFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder BVerticalTile = new MapTileBuilder(BVerticalFrame);

        mapTiles.add(BVerticalTile);

        //inside corners

        //INW corner (if you made a box of grass, this would be the NW corner)
        Frame INWCornerFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder INWCornerTile = new MapTileBuilder(INWCornerFrame);

        mapTiles.add(INWCornerTile);

        //INE corner 
        Frame INECornerFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder INECornerTile = new MapTileBuilder(INECornerFrame);

        mapTiles.add(INECornerTile);

        //ISW corner 
        Frame ISWCornerFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder ISWCornerTile = new MapTileBuilder(ISWCornerFrame);

        mapTiles.add(ISWCornerTile);

        //ISE corner 
        Frame ISECornerFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder ISECornerTile = new MapTileBuilder(ISECornerFrame);

        mapTiles.add(ISECornerTile);
       
        
        //Solid path
        Frame SolidPathFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder SolidPathTile = new MapTileBuilder(SolidPathFrame);

        mapTiles.add(SolidPathTile);

        //path from solid, in cardinal directions (NESW)

       //N
        Frame NSolidPathFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder NSolidPathTile = new MapTileBuilder(NSolidPathFrame);

        mapTiles.add(NSolidPathTile);

        //E
        Frame ESolidPathFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder ESolidPathTile = new MapTileBuilder(ESolidPathFrame);

        mapTiles.add(ESolidPathTile);

        //S
        Frame SSolidPathFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder SSolidPathTile = new MapTileBuilder(SSolidPathFrame);

        mapTiles.add(SSolidPathTile);

        //W
        Frame WSolidPathFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder WSolidPathTile = new MapTileBuilder(WSolidPathFrame);

        mapTiles.add(WSolidPathTile);


        //Corner cap tiles (for transitions from solid sections of path to mixed path & grass)
        //NE
        Frame NECornerCapFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder NECornerCapTile = new MapTileBuilder(NECornerCapFrame);

        mapTiles.add(NECornerCapTile);

        //SE
        Frame SECornerCapFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder SECornerCapTile = new MapTileBuilder(SECornerCapFrame);

        mapTiles.add(SECornerCapTile);
        
        //NW
        Frame NWCornerCapFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder NWCornerCapTile = new MapTileBuilder(NWCornerCapFrame);

        mapTiles.add(NWCornerCapTile);

        //SW
        Frame SWCornerCapFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder SWCornerCapTile = new MapTileBuilder(SWCornerCapFrame);

        mapTiles.add(SWCornerCapTile);

        //Turning Path tiles, labeled as if they were making a ring

        //NW
        Frame NWTurningPathFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder NWTurningPathTile = new MapTileBuilder(NWTurningPathFrame);

        mapTiles.add(NWTurningPathTile);

        //SW
        Frame SWTurningPathFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder SWTurningPathTile = new MapTileBuilder(SWTurningPathFrame);

        mapTiles.add(SWTurningPathTile);

        //NE
        Frame NETurningPathFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder NETurningPathTile = new MapTileBuilder(NETurningPathFrame);

        mapTiles.add(NETurningPathTile);

        //SE
        Frame SETurningPathFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder SETurningPathTile = new MapTileBuilder(SETurningPathFrame);

        mapTiles.add(SETurningPathTile);

        //4 way path (a tile with a path exiting all sides)

        //4 Way
        Frame FourWayPathFrame = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder FourWayPathTile = new MapTileBuilder(FourWayPathFrame);

        mapTiles.add(FourWayPathTile);

        //blank grass tiles!!! two options that will tile

        //plain grass tile
        Frame PlainGrassFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder PlainGrassTile = new MapTileBuilder(PlainGrassFrame);

        mapTiles.add(PlainGrassTile);

        //accent grass tile
        Frame AccentGrassFrame = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder AccentGrassTile = new MapTileBuilder(AccentGrassFrame);

        mapTiles.add(AccentGrassTile);

        //corners of solid path tiles, corner labeled is the corner in the grass!
        //NW
        Frame NWSolidCornerFrame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder NWSolidCornerTile = new MapTileBuilder(NWSolidCornerFrame);

        mapTiles.add(NWSolidCornerTile);
        
        //NE
        Frame NESolidCornerFrame = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder NESolidCornerTile = new MapTileBuilder(NESolidCornerFrame);

        mapTiles.add(NESolidCornerTile);

        //SW
        Frame SWSolidCornerFrame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder SWSolidCornerTile = new MapTileBuilder(SWSolidCornerFrame);

        mapTiles.add(SWSolidCornerTile);

        //SE
        Frame SESolidCornerFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder SESolidCornerTile = new MapTileBuilder(SESolidCornerFrame);

        mapTiles.add(SESolidCornerTile);
        
        
        



        return mapTiles;
    }
}
