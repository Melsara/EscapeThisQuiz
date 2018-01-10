package com.sardegnaisoladicavalli.escapethisquiz;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);

        setContentView(R.layout.activity_quiz_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.recycler_view);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        RecyclerActivityAdapter ca = new RecyclerActivityAdapter(createList(30));
        recList.setAdapter(ca);
    }

    private List<SubActivityData> createList(int size) {

        List<SubActivityData> result = new ArrayList<SubActivityData>();
        for (int i=1; i <= size; i++) {
            SubActivityData ci = new SubActivityData();
            ci.text = SubActivityData.CARD_TEXT + i;

            result.add(ci);

        }

        return result;
    }
}