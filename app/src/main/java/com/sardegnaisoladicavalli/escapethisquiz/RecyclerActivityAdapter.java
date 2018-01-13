package com.sardegnaisoladicavalli.escapethisquiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RecyclerActivityAdapter  extends RecyclerView.Adapter<RecyclerActivityAdapter.CardViewHolder> {

    private List<SubActivityData> SubActivityData;

    public RecyclerActivityAdapter(List<SubActivityData> contactList) {
        this.SubActivityData = contactList;
    }


    @Override
    public int getItemCount() {
        return SubActivityData.size();
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        SubActivityData ci = SubActivityData.get(i);
        cardViewHolder.vTitle.setText(ci.text);
        cardViewHolder.questionField.setText((CharSequence) ci.setQuestion());
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.activity_quiz_card, viewGroup, false);

        return new CardViewHolder(itemView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView questionField;

        public CardViewHolder(View v) {
            super(v);

            vTitle = (TextView) v.findViewById(R.id.card_text);
            questionField = (TextView) v.findViewById(R.id.card_question);
        }
    }
}
