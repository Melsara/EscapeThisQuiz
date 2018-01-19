package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    public int score = RightAnswers.score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent result = getIntent();
        final Bundle bundle = result.getExtras();
        score = bundle.getInt("score");

        TextView actualRes = (TextView) findViewById(R.id.result_actualRes);
        actualRes.setText(Integer.toString(score));
    }

    public void onRestartButtonClicked (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
