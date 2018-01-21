package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.sardegnaisoladicavalli.escapethisquiz.RightAnswers.score;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    @Override
    public void onBackPressed()
    {

        /*super.onBackPressed();*/
    }


    public void startQuiz (View view) {
        Intent card01 = new Intent(this, QuizCard01.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card01.putExtras(bundle);
        startActivity(card01);
    }
}
