package com.sardegnaisoladicavalli.escapethisquiz;

/**
 * Created by Sara on 10/01/2018.
 */

public class SubActivityData {
    protected String text;
    protected String question;
       protected String radioText1;
    protected String radioText2;
    protected String radioText3;
    protected String radioText4;
    protected int image;
    protected static final String CARD_TEXT = "card text";

    public SubActivityData(String question, String text, String answer1, String answer2, String answer3, String answer4, int image) {
        this.text = text;
        this.question = question;
        this.radioText1 = answer1;
        this.radioText2 = answer2;
        this.radioText3 = answer3;
        this.radioText4 = answer4;
        this.image = image;
    }

}
