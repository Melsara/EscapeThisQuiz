package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizCard05 extends AppCompatActivity {

    public int score = RightAnswers.score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_05);
        Intent card05 = getIntent();
        final Bundle bundle = card05.getExtras();
        score = bundle.getInt("score");

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.card_answer3:
                if (checked)

                    score += 1;

                    break;
        }
    }

    public void onSubmitButtonClicked (View view) {
        Intent result = new Intent(this, Result.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        result.putExtras(bundle);
        startActivity(result);
    }


/*    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(this, QuizCard04.class);
        startActivity(intent);
    }*/

}