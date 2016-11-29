package mgc17b.runpingurun.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class GameObject implements Renderable {
    protected int spriteHeight;
    protected int spriteWidth;

    protected Bitmap image;
    protected int posX;
    protected int posY;

    public int state = 0;

    protected int screenWidth = 0;
    protected int screenHeight = 0;


    protected float elevation = 0;

    public GameObject(Context context) {
        posX = screenWidth;
        posY = screenHeight;
    }

    @Override
    public void step() {
        if (state < 9) {
            state++;
        } else {
            state = 0;
        }
    }

    @Override
    public void size(int x, int y) {
        this.screenWidth = x;
        this.screenHeight = y;
    }

    public void setPosition(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void render(Canvas canvas) {
        setSpriteSizes();

        int statePos = state / 5;
        //4 states, 64*29 each image

        int x = 0;
        int y = 0;

        Rect src = new Rect(x, y, x + spriteWidth, y + spriteHeight);
        Rect dst = new Rect(posX, posY, posX + spriteWidth, posY + spriteHeight);

        canvas.drawBitmap(image, src, dst, null);
    }

    protected abstract void setSpriteSizes();

    public void setElevation(float elevation) {
        this.elevation = elevation;
    }
}
