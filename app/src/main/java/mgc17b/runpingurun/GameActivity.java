package mgc17b.runpingurun;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import mgc17b.runpingurun.rendering.GameView;


public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        gameView = (GameView) findViewById(R.id.gameView);




        mPlayer = MediaPlayer.create(GameActivity.this, R.raw.bgt);
     //   mPlayer.start();
    }



    public void onDestroy() {

        mPlayer.stop();
        super.onDestroy();

    }

}
