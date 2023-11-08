package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;
import Tilesets.QuadTileset;

import java.util.ArrayList;

public class SignTileset extends Tileset {

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defineTiles'");
    }
    
    public SignTileset()
    {
        super(ImageLoader.load("SignTileset"), 16, 16, 3);
    }
}
