package mgc17b.runpingurun.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import mgc17b.runpingurun.R;


public class Penguin extends GameObject {

    protected static final int SPRITE_HORIZONTAL = 1;
    protected static final int SPRITE_VERTICAL = 4;
    private int maxLife = 3;
    private int life;
    private int distanceFromBottom;

    public Penguin(Context context) {
        super(context);
        image = BitmapFactory.decodeResource(context.getResources(), R.drawable.pingu);
        Bitmap ground = BitmapFactory.decodeResource(context.getResources(), R.drawable.moving_ground);
        distanceFromBottom = ground.getHeight();
        posX = 0;
        posY = screenHeight;
        life = maxLife;
    }

    @Override
    public void step() {
        super.step();
        posX = screenWidth / 10;
        posY = screenHeight - image.getHeight() - distanceFromBottom;//(int)((elevation /10.0f)*(float)screenHeight);
        if (posY > screenHeight) {
            posY = screenHeight;
        }
        if (posY < spriteHeight) {
            posY = spriteHeight;
        }

    }

    protected void setSpriteSizes() {
        spriteWidth = image.getWidth(); // SPRITE_HORIZONTAL;
        spriteHeight = image.getHeight(); // SPRITE_VERTICAL;
    }

}
