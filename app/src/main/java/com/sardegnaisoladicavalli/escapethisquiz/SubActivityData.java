package com.sardegnaisoladicavalli.escapethisquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara on 10/01/2018.
 */

public class SubActivityData extends RecyclerActivity {
    public static String q1;
    public static String q2;
    public static String q3;
    public static String q4;
    public static String q5;
    protected String text;
    protected static final String CARD_TEXT = "card text";


    public List setQuestion() {

        ArrayList questionList = new ArrayList<SubActivityData>();
        SubActivityData ql = new SubActivityData();
        q1 = getString(R.string.question1);
        q2 = getString(R.string.question2);
        q3 = getString(R.string.question3);
        q4 = getString(R.string.question4);
        q5 = getString(R.string.question5);
        questionList.add(ql);
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);
        questionList.add(q5);


        return questionList;


    }

}
