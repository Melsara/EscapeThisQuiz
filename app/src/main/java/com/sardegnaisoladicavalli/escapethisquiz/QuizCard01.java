package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizCard01 extends AppCompatActivity {

    public int quizResult1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_01);
        Intent intent = getIntent();

    }

    public int gotRightAnswer (){

        quizResult1 = quizResult1 +1;
        return quizResult1;

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.card_answer1:
                if (checked)

                    break;
            case R.id.card_answer2:
                if (checked)

                    gotRightAnswer();

                    break;

            case R.id.card_answer3:
                if (checked)

                    break;

            case R.id.card_answer4:
                if (checked)

                    break;
        }
    }

    public void onNextButtonClicked (View view) {
        Intent intent = new Intent(this, QuizCard02.class);
        startActivity(intent);
    }

}