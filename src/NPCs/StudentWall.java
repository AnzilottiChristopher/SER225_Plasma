package NPCs;

import Enums.CollisionState;
import Level.NPC;
import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Utils.Point;

import java.util.HashMap;
public class StudentWall extends NPC
{
    public StudentWall(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("StudentWall.png"),
                26, 28), "STAND_RIGHT");
    }

    public StudentWall(int id, Point location, CollisionState state)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("StudentWall.png"),
                26, 28), "STAND_LEFT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet)
    {
        return new HashMap<String, Frame[]>(){{
            put("STAND_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(10, 3, 50, 30)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 1))
                            .withScale(3)
                            .withBounds(10, 3, 50, 30)
                            //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
