package mgc17b.runpingurun.rendering;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {

	private RenderLoop renderLoop;
	public GameView(Context context) {
		super(context);
		init(context);
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs,defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		SurfaceHolder holder = getHolder();
		renderLoop = new RenderLoop(context,this);
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
			public void surfaceChanged(SurfaceHolder holder, int format,int width, int height) {
				renderLoop.init(width,height);
			}
		});
	}
}
