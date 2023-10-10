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

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file

//QuadTileset are all path tilesets, not exclusive to Quad, but named after it cuz, you know, paths!
//and the tileset kinda looks like a funcky quad
public class CombatTileset extends Tileset {

    public CombatTileset() {
        super(ImageLoader.load("CombatTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        

        //UI box elements

        Frame NWBoxFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder NWBoxTile = new MapTileBuilder(NWBoxFrame);

        mapTiles.add(NWBoxTile);

        Frame NEBoxFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder NEBoxTile = new MapTileBuilder(NEBoxFrame);

        mapTiles.add(NEBoxTile);

        Frame SWBoxFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder SWBoxTile = new MapTileBuilder(SWBoxFrame);

        mapTiles.add(SWBoxTile);

        Frame SEBoxFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder SEBoxTile = new MapTileBuilder(SEBoxFrame);

        mapTiles.add(SEBoxTile);

        Frame NEdgeBoxFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder NEdgeBoxTile = new MapTileBuilder(NEdgeBoxFrame);

        mapTiles.add(NEdgeBoxTile);

        Frame SEdgeBoxFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder SEdgeBoxTile = new MapTileBuilder(SEdgeBoxFrame);

        mapTiles.add(SEdgeBoxTile);


        //spotlight

        Frame LspotlightFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder LspotlightTile = new MapTileBuilder(LspotlightFrame);

        mapTiles.add(LspotlightTile);

        Frame CspotlightFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder CspotlightTile = new MapTileBuilder(CspotlightFrame);

        mapTiles.add(CspotlightTile);

        Frame RspotlightFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder RspotlightTile = new MapTileBuilder(RspotlightFrame);

        mapTiles.add(RspotlightTile);


        //blue Banner
        Frame[] blueBannerFrame = new Frame[] {
            new FrameBuilder(getSubImage(3, 0), 7)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(3, 1), 7)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(3, 2), 7)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(3, 3), 7)
                    .withScale(tileScale)
                    .build()
            };

        MapTileBuilder blueBannerTile = new MapTileBuilder(blueBannerFrame);

        mapTiles.add(blueBannerTile);

        //yellow Banner
        Frame[] yellowBannerFrame = new Frame[] {
            new FrameBuilder(getSubImage(4, 3), 7)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(4, 2), 7)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4, 1), 7)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4, 0), 7)
                    .withScale(tileScale)
                    .build()
            };

        MapTileBuilder yellowBannerTile = new MapTileBuilder(yellowBannerFrame);

        mapTiles.add(yellowBannerTile);

        //bg tile
        Frame BGFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder BGFTile = new MapTileBuilder(BGFrame);

        mapTiles.add(BGFTile);
    

        return mapTiles;
    }
}
