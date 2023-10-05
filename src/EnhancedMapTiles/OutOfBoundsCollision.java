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


public class OutOfBoundsCollision extends EnhancedMapTile
{
    public OutOfBoundsCollision(Point location)
    {
        //PushableRock constructor
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("CollisionWall.png"),
                420, 10), TileType.NOT_PASSABLE);
    }

    public OutOfBoundsCollision(Point location, CollisionState side)
    {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("CollisionWallSides.png"),
                1, 480), TileType.NOT_PASSABLE);

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
                .build();
        return new GameObject(x, y, frame);
    }
}
