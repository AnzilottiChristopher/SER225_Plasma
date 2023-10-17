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
    public static CollisionState side;
    public OutOfBoundsCollision(Point location)
    {
        //PushableRock constructor
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("CollisionWall.png"),
                1700, 10), TileType.NOT_PASSABLE);
    }

    public OutOfBoundsCollision(Point location, CollisionState side)
    {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("CollisionWallSides.png"),
                1, 1500), TileType.NOT_PASSABLE);
        this.side = side;

    }

    @Override
    public void update(Player player)
    {
        super.update(player);

    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet)
    {
        Frame frame;
        if (side == CollisionState.LEFTSIDE)
        {
            frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                    .withScale(3)
                    .withBounds(0, 0, 1, 10000)
                    .build();
            //System.out.println("The leftside is: " + side);
        } else if (side == CollisionState.RIGHTSIDE)
        {
            frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                    .withScale(3)
                    .withBounds(20, 0, 1, 10000)
                    .build();
           // System.out.println("The rightside is: " + side);
        }
        else
        {
            frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                    .withScale(3)
                    .build();
            //System.out.println("else side is: " + side);
        }

        return new GameObject(x, y, frame);
    }
}
