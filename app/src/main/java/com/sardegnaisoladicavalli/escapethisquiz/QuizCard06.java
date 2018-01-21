package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuizCard06 extends AppCompatActivity {

    public int score = RightAnswers.score;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_06);
        Intent card06 = getIntent();
        final Bundle bundle = card06.getExtras();
        score = bundle.getInt("score");

    }

    @Override
    public void onBackPressed()
    {

        /*super.onBackPressed();*/
    }

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


    public void gotRightPadlockCombination () {
        EditText editText = (EditText) findViewById(R.id.padlock_comb);
        String userComb = editText.getText().toString();


        if (userComb.equalsIgnoreCase("ADBC")) {

            score += 1;


        } else {


        }

    }

    public void onNextButtonClicked (View view) {
        gotRightPadlockCombination();
        Intent card07 = new Intent(this, QuizCard07.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card07.putExtras(bundle);
        startActivity(card07);
    }


/*    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(this, QuizCard04.class);
        startActivity(intent);
    }*/

}