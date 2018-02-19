package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    public int score = RightAnswers.score;
    public String name;
    Bundle bundle;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent result = getIntent();
        final Bundle bundle = result.getExtras();
        score = bundle.getInt(SCORE_KEY);
        name = bundle.getString(NAME_KEY);

        TextView actualRes = (TextView) findViewById(R.id.result_actualRes);
        actualRes.setText(Integer.toString(score));

        /*Quit button functioning. Shut down the app if pressed*/

        Button quit = (Button) findViewById(R.id.button_quit);
        quit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });

        /*Displaying different messages on a toast, according to user result. Also displaying the score on the toast.*/

        if (score >= 4) {

            displayToast(name + ", " + getString(R.string.toast_win) + "\n" + getString(R.string.result_title) + " " + score + " " + getString(R.string.result_outOf) + " " + getString(R.string.result_totalQuestions));

        } else {

            displayToast(name + ", " + getString(R.string.toast_lose) + "\n" + getString(R.string.result_title) + " " + score + " " + getString(R.string.result_outOf) + " " + getString(R.string.result_totalQuestions));
        }
    }

    /*Disabling back button. Displaying a toast, when user tap the button instead.*/

    @Override
    public void onBackPressed() {
        displayToast(getString(R.string.toast_noBack));
        /*super.onBackPressed();*/

    }

    /*Saving and restoring states of the app*/

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBundle("bundle", bundle);
        savedInstanceState.putInt("score", score);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bundle = savedInstanceState.getBundle("bundle");
        score = savedInstanceState.getInt("score");
    }

    /*Restarting MainActivity after user finished*/

    public void onRestartButtonClicked (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /*Defining toast to display onBackPressed*/

    public void displayToast(CharSequence toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

    /*Launching implicit intent to share user result across other apps*/

    public void onShareButtonClicked (View view) {{
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Escape this Quiz\n" + name + "\'s result is " + score + " out of " + (getString(R.string.result_totalQuestions)));
            if (sharingIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(sharingIntent,"Share you result using"));
            }
        }
    }
}
