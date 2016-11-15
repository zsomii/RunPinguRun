package mgc17b.runpingurun.rendering;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mgc17b.runpingurun.model.Background2;
import mgc17b.runpingurun.model.Penguin;
import mgc17b.runpingurun.model.PolarBear;
import mgc17b.runpingurun.model.Renderable;
import mgc17b.runpingurun.model.ScoreDisplay;

public class Renderer {
    private Context context;

    private int width;
    private int height;
    private int speed;

    private Random random;

    private List<Renderable> entitiesToDraw;

    private Background2 bg;
    private Background2 bg1;
    private Background2 bg2;
    private Penguin penguin;
    private ScoreDisplay scoreDisplay;
    private int screenSizeX;
    private int screenSizeY;

    public Renderer(Context context) {
        this.context = context;
        init(0, 0);
    }


    public void init(int width, int height) {
        speed = 14;
        this.width = width;
        this.height = height;
        entitiesToDraw = new ArrayList<>();

        bg1 = new Background2(context);
        bg1.size(width, height);


        penguin = new Penguin(context);
        penguin.size(width, height);


        scoreDisplay = new ScoreDisplay(context);

        PolarBear polarbear = new PolarBear(context);
        polarbear.size(width, height);


        entitiesToDraw.add(polarbear);
        entitiesToDraw.add(penguin);

        random = new Random();
    }

    public void step() {
        if (random.nextFloat() > (0.995)) {
            PolarBear polarbear = new PolarBear(context);
            polarbear.size(width, height);
            entitiesToDraw.add(polarbear);
        }


        bg1.step();
       // bg2.step();

        for (Renderable object : entitiesToDraw) {
            object.step();
        }
    }

    public void draw(Canvas canvas) {

        bg1.render(canvas);
        //bg2.render(canvas);


        // bg2.render(canvas);
        for (Renderable object : entitiesToDraw) {
            object.render(canvas);
        }
    }


    public void setElevation(float elevation) {
        penguin.setElevation(elevation);
    }


}
