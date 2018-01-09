package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sardegnaisoladicavalli.escapethisquiz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerActivityAdapter extends RecyclerView.Adapter<RecyclerActivityAdapter.SubActivityViewHolder> {

    private ArrayList<String> mDataset;
    public RecyclerActivityAdapter(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
        inflater = null;
    }

    private final LayoutInflater inflater;
    /*private List<SubActivityData> subActivityData;

    public SubActivityAdapter(Context context, List<SubActivityData> subActivityData) {
        inflater = LayoutInflater.from(context);
        this.subActivityData = Collections.EMPTY_LIST;
        this.subActivityData = subActivityData;
    }*/


    @Override
    public SubActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_quiz_card, parent, false);
        view.setMinimumWidth(parent.getMeasuredWidth());
        SubActivityViewHolder subActivityViewHolder = new SubActivityViewHolder(view);
        return subActivityViewHolder;
    }

    @Override
    public void onBindViewHolder(SubActivityViewHolder holder, int position) {
        holder.mTitle.setText(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class SubActivityViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;

        public SubActivityViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.card_text);
        }
    }
}
