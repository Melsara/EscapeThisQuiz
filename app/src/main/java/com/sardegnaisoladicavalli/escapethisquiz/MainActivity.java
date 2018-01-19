package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.sardegnaisoladicavalli.escapethisquiz.RightAnswers.score;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz (View view) {
        Intent card01 = new Intent(this, QuizCard01.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card01.putExtras(bundle);
        startActivity(card01);
    }
}
