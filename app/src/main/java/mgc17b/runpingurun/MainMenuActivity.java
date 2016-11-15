package mgc17b.runpingurun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
    }


    //Beállítva az XML fáljban, hogy ha az Exit game gombra
    //nyom a felhasználó, akkor lépjen ki a játékból.
    public void exitButtonOnClick(View v) {
        finish();
        System.exit(0);
    }

    public void showHighScore(View v) {
        Intent intent = new Intent(this, ShowHighScore.class);
        startActivity(intent);
    }


    public void startNewGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
