package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import Enums.CollisionState;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import GameObject.Frame;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Maps.TestMap;
import Utils.Point;


public class SleepWall extends EnhancedMapTile
{
    public static CollisionState side;
    public SleepWall(Point location)
    {
        //PushableRock constructor
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("SleepWall.png"),
                1700, 30), TileType.NOT_PASSABLE);
    }


    @Override
    public void update(Player player)
    {
        super.update(player);

    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet)
    {

           Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                    .withScale(3)
                    .withBounds(0, 0, 1700, 30)
                    .build();


        return new GameObject(x, y, frame);
    }
}
