package mgc17b.runpingurun.rendering;

import android.content.Context;
import android.graphics.Canvas;

public class RenderLoop extends Thread {
    private GameView view;
    private final Renderer renderer;

    private boolean running = false;

    public RenderLoop(Context context, GameView view) {
        this.view = view;
        this.renderer = new Renderer(context);
    }

    public void init(int width, int height) {
        renderer.init(width, height);
    }

    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {
        while (running) {
            long renderStart = getTime();
            draw();

            long renderEnd = getTime();
            long sleepTime = timeBetweenFrames - (renderEnd - renderStart);
            if (sleepTime > 0) {
                sleepThread(sleepTime);
            } else {
                sleepThread(5);
            }
        }
    }


    private void draw() {
        renderer.step();
        Canvas c = null;
        try {
            c = view.getHolder().lockCanvas();
            synchronized (view.getHolder()) {
                renderer.draw(c);
            }
        } finally {
            if (c != null) {
                view.getHolder().unlockCanvasAndPost(c);
            }
        }
    }

    public void setElevation(float elevation) {
        renderer.setElevation(elevation);
    }

    public static final long FPS = 30;
    private static final long timeBetweenFrames = 1000 / FPS;

    private void sleepThread(long time) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private long getTime() {
        return System.currentTimeMillis();
    }


}