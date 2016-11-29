package mgc17b.runpingurun.rendering;

import android.content.Context;
import android.graphics.Canvas;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mgc17b.runpingurun.model.Background;
import mgc17b.runpingurun.buttons.BackgroundMusic;
import mgc17b.runpingurun.buttons.GameRunning;
import mgc17b.runpingurun.buttons.Jump;
import mgc17b.runpingurun.model.Gift;
import mgc17b.runpingurun.model.MovingGround;
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

    private MovingGround ground;
    private Background background;
    private Penguin penguin;
    private Jump jump;
    private ScoreDisplay scoreDisplay;
    private BackgroundMusic bgMusic;
    private GameRunning gameRunning;
    private int screenHeight;
    private int screenWidth;

    public Renderer(Context context) {
        this.context = context;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        screenWidth = display.getWidth();  // deprecated
        screenHeight = display.getHeight();  // deprecated


        init(screenWidth, screenHeight);
    }


    public void init(int width, int height) {
        speed = 14;
        this.width = width;
        this.height = height;
        entitiesToDraw = new ArrayList<>();

        background = new Background(context);
        entitiesToDraw.add(background);

        ground = new MovingGround(context);
        ground.size(width, height);
        entitiesToDraw.add(ground);


        penguin = new Penguin(context);
        penguin.size(width, height);


        scoreDisplay = new ScoreDisplay(context);

        PolarBear polarbear = new PolarBear(context);
        polarbear.size(width, height);

        gameRunning = new GameRunning(context);

        random = new Random();
        jump = new Jump(context);
        bgMusic = new BackgroundMusic(context);

        entitiesToDraw.add(bgMusic);
        entitiesToDraw.add(jump);
        entitiesToDraw.add(polarbear);
        entitiesToDraw.add(penguin);
        entitiesToDraw.add(gameRunning);
    }

    public void step() {
        if (random.nextFloat() > (0.995)) {
            PolarBear polarbear = new PolarBear(context);
            polarbear.size(width, height);
            entitiesToDraw.add(polarbear);
        }

        if (random.nextFloat() > (0.995)) {
            Gift gift = new Gift(context);
            gift.size(width, height);
            entitiesToDraw.add(gift);
        }



        for (Renderable object : entitiesToDraw) {
            object.step();
        }
    }

    public void draw(Canvas canvas) {

        ground.render(canvas);
        for (Renderable object : entitiesToDraw) {
            object.render(canvas);
        }
    }


    public void setElevation(float elevation) {
        penguin.setElevation(elevation);
    }


}
