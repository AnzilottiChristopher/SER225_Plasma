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
public class HerscoviciBoss extends NPC
{
    public HerscoviciBoss(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("HerscoviciBoss.png"),
                28, 28), "SIT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet)
    {
        return new HashMap<String, Frame[]>(){{
            put("SIT_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(3, 0))
                            .withScale(3)
                            .withBounds(8, 3, 10, 30)
                            .build()
            });

            put("SIT_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(2, 0))
                            .withScale(3)
                            .withBounds(8, 3, 10, 30)
                            .build()
            });

            put("SIT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
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
