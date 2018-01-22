package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizCard02 extends AppCompatActivity {

    public int score = RightAnswers.score;
    public String name;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_02);
        Intent card02 = getIntent();
        final Bundle bundle = card02.getExtras();
        name = bundle.getString("name");
        score = bundle.getInt("score");

    }

    @Override
    public void onBackPressed()
    {

        /*super.onBackPressed();*/
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.card_answer4:
                if (checked)

                    score += 1;

                break;
        }
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

    public void onNextButtonClicked (View view) {
        Intent card03 = new Intent(this, QuizCard03.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        bundle.putString("name", name);
        card03.putExtras(bundle);
        startActivity(card03);
    }

/*    public void onBackButtonClicked(View view) {
        Intent card01 = new Intent(this, QuizCard01.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card01.putExtras(bundle);
        startActivity(card01);
    }*/

}