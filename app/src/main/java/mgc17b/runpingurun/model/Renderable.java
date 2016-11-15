package mgc17b.runpingurun.model;

import android.graphics.Canvas;

public interface Renderable {
    void step();
    void size(int x, int y);
    void render(Canvas canvas);
}
