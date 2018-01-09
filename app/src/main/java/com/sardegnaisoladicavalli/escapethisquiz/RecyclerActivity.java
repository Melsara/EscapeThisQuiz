package com.sardegnaisoladicavalli.escapethisquiz;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        mDataSet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDataSet.add("New Card " + i);

            //RecyclerView
            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            mRecyclerView.setHasFixedSize(true);

            mAdapter = new RecyclerActivityAdapter(mDataSet);
            mRecyclerView.setAdapter(mAdapter);

            //Layout manager for the Recycler View
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            mRecyclerView.setLayoutManager(mLayoutManager);


        }

/*        public static List<SubActivityData> getData () {
            List<SubActivityData> subActivityData = new ArrayList<>();
            String[] cardTitle = {
                    "Card 1",
                    "Card 2",
                    "Card 3",
                    "Card 4",
                    "Card 5",
                    "Card 6",
            };
            for (int i = 0; i < cardTitle.length; i++) {
                SubActivityData current = new SubActivityData();
                current.cardTitle = cardTitle[i];
                subActivityData.add(current);
            }

            return subActivityData;
        }*/
    }
}


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}*/