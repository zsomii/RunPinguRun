package mgc17b.runpingurun;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowHighScore extends Activity {

    ArrayList<String> randomScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_high_score);


        //A megjelenítő ListView
        ListView topScores = (ListView) findViewById(R.id.scoreList);

        randomScores = new ArrayList<String>();
        setScores();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, randomScores);
        topScores.setAdapter(arrayAdapter);

    }

    public void returnToMainMenu(View view) {
        this.finish();
    }

    public void deleteTopList(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.clearTop5);
        alert.setMessage("Are you sure you want to clear the top 5?");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // continue with delete
                randomScores.clear();
                System.out.println("Delete >> Yes");

            }
        });
        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
                System.out.println("Delete >> No");
            }
        });
        alert.setIcon(android.R.drawable.ic_dialog_alert);
        alert.show();

        //  this.finish();

    }

    public void setScores() {
        randomScores.add("1. András ");
        randomScores.add("2. Béla");
        randomScores.add("3. Géza");
        randomScores.add("4. János");
        randomScores.add("5. Elemér");

    }

}
