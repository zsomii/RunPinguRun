package mgc17b.runpingurun.model;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.Random;

import mgc17b.runpingurun.R;


public class PolarBear extends GameObject {

    protected static final int SPRITE_HORIZONTAL = 1;
    protected static final int SPRITE_VERTICAL = 6;
    public static final int SPEED = 14;
    private final float randomFloat;

    public PolarBear(Context context) {
        super(context);
        image = BitmapFactory.decodeResource(context.getResources(), R.drawable.polarbear);
        posX = 0;
        posY = screenHeight;
        Random random = new Random();
        randomFloat = random.nextFloat();
    }


    @Override
    public void step() {
        super.step();

        posX = posX - SPEED;
        posY = screenHeight - image.getHeight();
    }

    @Override
    public void size(int x, int y) {
        super.size(x, y);
        posX = x;
        posY = screenHeight - image.getHeight();
    }

    protected void setSpriteSizes() {
        spriteWidth = image.getWidth() / SPRITE_HORIZONTAL;
        spriteHeight = image.getHeight() / SPRITE_VERTICAL;
    }

}
