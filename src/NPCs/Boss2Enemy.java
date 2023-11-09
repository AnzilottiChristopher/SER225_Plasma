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
public class Boss2Enemy extends NPC
{
    public Boss2Enemy(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("HerscoviciEnemy.png"),
                26, 32), "DAZED_BOY_RIGHT");
    }
    public Boss2Enemy(int id, Point location, CollisionState girl)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("HerscoviciEnemy.png"),
                26, 32), "DAZED_GIRL_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet)
    {
        return new HashMap<String, Frame[]>(){{
            put("DAZED_BOY_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(8, 3, 10, 20)
                            .build()
            });

            put("DAZED_GIRL_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 1))
                            .withScale(3)
                            .withBounds(8, 3, 10, 20)
                            .build()
            });

            put("DAZED_BOY_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 3, 10, 20)
                            .build()
            });

            put("DAZED_GIRL_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 1))
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 3, 10, 20)
                            .build()
            });


        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
