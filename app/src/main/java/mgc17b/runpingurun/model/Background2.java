package mgc17b.runpingurun.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

import mgc17b.runpingurun.R;

public class Background2 implements Renderable {

    private int width;
    private int height;
    private int posX1 = 0;
    private int posY1;
    private int posX2 = 0;
    private int posY2;
    private final BitmapDrawable bitmapDrawable;
    private final BitmapDrawable bitmapDrawable2;

    public int getX1() {
        return posX1;
    }

    public Background2(Context context) {

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_bg);
        bitmapDrawable = new BitmapDrawable(image);
        bitmapDrawable.setTileModeX(null);
        bitmapDrawable.setTileModeY(null);

        bitmapDrawable2 = new BitmapDrawable(image);
        bitmapDrawable2.setTileModeX(null);
        bitmapDrawable2.setTileModeY(null);
    }

    @Override
    public void step() {
        posX1 = posX1 + 14;
        posX2 = posX2 + 14;


        if (posX1 >= width) {
            setPositionX1(posX1 - width);
            posX1 = posX1 - width;

        }

        if ((posX2 >= width)) {
            setPositionX2(posX2 - width);
            posX2 = posX2 - width;
        }
        bitmapDrawable.setBounds(-posX1, 0, width - posX1, height);
        bitmapDrawable2.setBounds(-posX2, 0, width - posX2, height);

    }


    @Override
    public void size(int x, int y) {
        this.width = x;
        this.height = y;
        posX1 = 0;
        posX2 = width;
        bitmapDrawable.setBounds(0, 0, width, height);
        bitmapDrawable2.setBounds(width, 0, width + width, height);

    }

    @Override
    public void render(Canvas canvas) {
        if (bitmapDrawable != null && canvas != null && bitmapDrawable2 != null) {
            bitmapDrawable.draw(canvas);
            bitmapDrawable2.draw(canvas);
        }
    }


    public void setPositionX1(int x) {
        this.posX1 = x;
    }

    public void setPositionX2(int x) {
        this.posX2 = x;
    }

    public int getX2() {
        return posX2;
    }
}
