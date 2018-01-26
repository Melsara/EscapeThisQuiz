package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizCard04 extends AppCompatActivity {

    public int score = RightAnswers.score;
    public String name;
    Bundle bundle;
    final String SCORE_KEY = "score_key";
    final String NAME_KEY = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_04);
        Intent card04 = getIntent();
        final Bundle bundle = card04.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);

    }

    @Override
    public void onBackPressed() {
        displayToast(getString(R.string.toast_noBack));
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
        bundle.putInt(SCORE_KEY, score);
        bundle.putString(NAME_KEY, name);
        card05.putExtras(bundle);
        startActivity(card05);
    }

    public void displayToast(CharSequence toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

}