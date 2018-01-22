package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class QuizCard07 extends AppCompatActivity {

    public int score = RightAnswers.score;
    public String name;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card_07);
        Intent card07 = getIntent();
        final Bundle bundle = card07.getExtras();
        name = bundle.getString("name");
        score = bundle.getInt("score");

    }

    @Override
    public void onBackPressed() {

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


    public void onCheckboxClicked(View view) {

        CheckBox answer1 = (CheckBox) findViewById(R.id.card_answer1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.card_answer2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.card_answer3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.card_answer4);

        if (answer1.isChecked() && answer3.isChecked() && answer4.isChecked()
                && !answer2.isChecked()) {
            score += 1;

        }
    }

    public void onSubmitButtonClicked(View view) {
        Intent result = new Intent(this, Result.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        bundle.putString("name", name);
        result.putExtras(bundle);
        startActivity(result);
    }

}