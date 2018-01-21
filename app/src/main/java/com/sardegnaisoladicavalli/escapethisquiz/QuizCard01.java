package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizCard01 extends AppCompatActivity {

    public int score = RightAnswers.score;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent card01 = getIntent();
        final Bundle bundle = card01.getExtras();
        setContentView(R.layout.activity_quiz_card_01);
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

            case R.id.card_answer2:
                if (checked)

                    score += 1;

                    break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBundle("bundle", bundle);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int bundle = savedInstanceState.getInt("bundle");
    }

    public void onNextButtonClicked (View view) {
        Intent card02 = new Intent(this, QuizCard02.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card02.putExtras(bundle);
        startActivity(card02);
    }

}
