package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizCard06 extends AppCompatActivity {

    public int score = RightAnswers.score;
    public String name;
    Bundle bundle;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_06);
        Intent card06 = getIntent();
        final Bundle bundle = card06.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);

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

    /*Defining correct answer in the card*/

    public void gotRightPadlockCombination () {
        EditText editText = (EditText) findViewById(R.id.padlock_comb);
        String userComb = editText.getText().toString().trim();


        if (userComb.equalsIgnoreCase("ADCB")) {

            score += 1;


        }

    }

    /*Launching next activity in the pipe*/

    public void onNextButtonClicked (View view) {
        gotRightPadlockCombination();
        Intent card07 = new Intent(this, QuizCard07.class);
        Bundle bundle = new Bundle();
        bundle.putInt(SCORE_KEY, score);
        bundle.putString(NAME_KEY, name);
        card07.putExtras(bundle);
        startActivity(card07);
    }

    /*Defining toast to display onBackPressed*/

    public void displayToast(CharSequence toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

}