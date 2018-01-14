package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_card);
        Intent intent = getIntent();

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.card_answer1:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.card_answer2:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onSubmitButtonClicked(View view) {
        Intent intentSubmit = new Intent(this, ResultCard.class);
        startActivity(intentSubmit);
    }

}
