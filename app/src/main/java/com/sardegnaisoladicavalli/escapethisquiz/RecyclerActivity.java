package com.sardegnaisoladicavalli.escapethisquiz;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    }

    private List<SubActivityData> createList() {

        ArrayList<SubActivityData> aList = new ArrayList<SubActivityData>(Arrays.asList(
                new SubActivityData(getString(R.string.question1), "card 1","answer 11", "answer12", "answer13", "answer14", R.drawable.ic_launcher_background),
                new SubActivityData(getString(R.string.question2), "card 2","answer 21", "answer22", "answer23", "answer24", R.drawable.ic_launcher_background),
                new SubActivityData(getString(R.string.question3), "card 3","answer 31", "answer32", "answer33", "answer34", R.drawable.ic_launcher_background),
                new SubActivityData(getString(R.string.question4), "card 4","answer 41", "answer42", "answer43", "answer44", R.drawable.ic_launcher_background),
                new SubActivityData(getString(R.string.question5), "card 5","answer 51", "answer52", "answer53", "answer54", R.drawable.ic_launcher_background)
        ));
        return aList;
    }
}