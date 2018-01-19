package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizCard04 extends AppCompatActivity {

    public int score = RightAnswers.score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_04);
        Intent card04 = getIntent();
        final Bundle bundle = card04.getExtras();
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

    public void onNextButtonClicked (View view) {
        Intent card05 = new Intent(this, QuizCard05.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        card05.putExtras(bundle);
        startActivity(card05);
    }

/*    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(this, QuizCard03.class);
        startActivity(intent);
    }*/

}