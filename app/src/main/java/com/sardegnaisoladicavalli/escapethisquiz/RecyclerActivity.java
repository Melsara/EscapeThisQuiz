package com.sardegnaisoladicavalli.escapethisquiz;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
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

        RecyclerActivityAdapter ca = new RecyclerActivityAdapter(createList(6));
        RecyclerActivityAdapter ql = new RecyclerActivityAdapter(setQuestions(5));
        recList.setAdapter(ql);
        recList.setAdapter(ca);
        ql.notifyDataSetChanged();
        ca.notifyDataSetChanged();

    }

    private List<SubActivityData> createList(int size) {

        ArrayList<SubActivityData> aList = new ArrayList<SubActivityData>();
        for (int i=1; i <= size; i++) {
            SubActivityData ci = new SubActivityData();
            ci.text = SubActivityData.CARD_TEXT + i;

            aList.add(ci);


        }

        return aList;
    }


    private List<SubActivityData> setQuestions(int size) {

            SubActivityData ql = new SubActivityData();
            ql.setQuestion();
            return (List<SubActivityData>) ql;

        }


    }