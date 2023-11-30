package NPCs;

import Level.NPC;
import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Utils.Point;

import java.util.HashMap;
public class SleepingStudent extends NPC
{
    public SleepingStudent(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("SleepingStudent.png"),
                36, 36), "STAND_LEFT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet)
    {
        return new HashMap<String, Frame[]>(){{
            put("STAND_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(0, 0, 36, 36)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(0, 0, 36, 36)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}