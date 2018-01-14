package com.sardegnaisoladicavalli.escapethisquiz;

import android.widget.Button;

/**
 * Created by Sara on 14/01/2018.
 */

public class SubActivityResult {
    protected String resultTitle;
    protected int scoredResult;
    protected String outOf;
    protected int maxResult;
    protected Button restart;

    public SubActivityResult(String resultTitle, int scoredResult, String outOf, int maxResult/*, Button restart */) {
        this.resultTitle = resultTitle;
        this.scoredResult = scoredResult;
        this.outOf = outOf;
        this.maxResult = maxResult;
/*        this.restart = restart;*/
    }
}
