package mgc17b.runpingurun.model;

import android.content.Context;

public class ScoreDisplay {
    private int score;
    private int sizeX;
    private int sizeY;

    public ScoreDisplay(Context context) {
        score = 0;
    }

    public void size(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
    }

    public void increaseScore(int value) {
        score += value;
    }

}
