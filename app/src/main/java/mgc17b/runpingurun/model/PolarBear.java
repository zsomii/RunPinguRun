package mgc17b.runpingurun.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

import mgc17b.runpingurun.R;
import mgc17b.runpingurun.rendering.GameView;


public class PolarBear extends GameObject {

    protected static final int SPRITE_HORIZONTAL = 1;
    protected static final int SPRITE_VERTICAL = 6;
    public static final int SPEED = 30;
    private final float randomFloat;
    private int distanceFromBottom;

    public PolarBear(Context context) {
        super(context);
        image = BitmapFactory.decodeResource(context.getResources(), R.drawable.polarbear);
        Bitmap ground = BitmapFactory.decodeResource(context.getResources(), R.drawable.moving_ground);
        distanceFromBottom = ground.getHeight();
        posX = 0;
        posY = GameView.screenHeight - image.getHeight() - distanceFromBottom + 20;
        Random random = new Random();
        randomFloat = random.nextFloat();
    }


    @Override
    public void step() {
        super.step();
        posX = posX - SPEED;
    }

    @Override
    public void size(int x, int y) {
        super.size(x, y);
        posX = x;
        posY = GameView.screenHeight - image.getHeight() - distanceFromBottom + 20;
    }

    protected void setSpriteSizes() {
        spriteWidth = image.getWidth();// SPRITE_HORIZONTAL;
        spriteHeight = image.getHeight(); // SPRITE_VERTICAL;
    }

}
