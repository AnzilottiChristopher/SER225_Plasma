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
public class AlexBoss extends NPC
{
    public AlexBoss(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Alex.png"),
                26, 29), "STAND_LEFT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet)
    {
        return new HashMap<String, Frame[]>(){{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(2, 0))
                            .withScale(3)
                            .withBounds(8, 3, 10, 30)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0))
                            .withScale(3)
                            .withBounds(8, 3, 10, 30)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
