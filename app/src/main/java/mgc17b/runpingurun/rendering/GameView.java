package mgc17b.runpingurun.rendering;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import mgc17b.runpingurun.R;

public class GameView extends SurfaceView implements MediaPlayer.OnPreparedListener {


    public static int screenHeight;
    public static int screenWidth;

    private RenderLoop renderLoop;

    public GameView(Context context) {
        super(context);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        screenWidth = display.getWidth();  // deprecated
        screenHeight = display.getHeight();  // deprecated


        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        screenWidth = display.getWidth();  // deprecated
        screenHeight = display.getHeight();  // deprecated

        init(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        screenWidth = display.getWidth();  // deprecated
        screenHeight = display.getHeight();  // deprecated

        init(context);
    }

    private void init(Context context) {
        SurfaceHolder holder = getHolder();
        renderLoop = new RenderLoop(context, this);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                renderLoop.setRunning(true);
                renderLoop.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                renderLoop.setRunning(false);
                while (retry) {
                    try {
                        renderLoop.join();
                        retry = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                renderLoop.init(width, height);
            }
        });
    }




    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
