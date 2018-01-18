package com.sardegnaisoladicavalli.escapethisquiz;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class RecyclerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);
        RecyclerView recList = (RecyclerView) findViewById(R.id.recycler_view);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recList.setLayoutManager(llm);

        RecyclerActivityAdapter ca = new RecyclerActivityAdapter(createList());
        recList.setAdapter(ca);
        ca.notifyDataSetChanged();
        int cardNumber = ca.getItemCount();
        if (cardNumber == 5) {

        }

    }

    private List<SubActivityData> createList() {

        ArrayList<SubActivityData> aList = new ArrayList<SubActivityData>(Arrays.<SubActivityData>asList(
                new SubActivityData(getString(R.string.question1), getString(R.string.text1), getString(R.string.answer11), getString(R.string.answer12), getString(R.string.answer13), getString(R.string.answer14), R.drawable.dragon, View.GONE),
                new SubActivityData(getString(R.string.question2), getString(R.string.text2), getString(R.string.answer21), getString(R.string.answer22), getString(R.string.answer23), getString(R.string.answer24), R.drawable.dragon, View.GONE),
                new SubActivityData(getString(R.string.question3), getString(R.string.text3), getString(R.string.answer31), getString(R.string.answer32), getString(R.string.answer33), getString(R.string.answer34), R.drawable.dragon, View.GONE),
                new SubActivityData(getString(R.string.question4), getString(R.string.text4), getString(R.string.answer41), getString(R.string.answer42), getString(R.string.answer43), getString(R.string.answer44), R.drawable.dragon, View.GONE),
                new SubActivityData(getString(R.string.question5), getString(R.string.text5), getString(R.string.answer51), getString(R.string.answer52), getString(R.string.answer53), getString(R.string.answer54), R.drawable.dragon, View.VISIBLE)

        ));


        return aList;
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
