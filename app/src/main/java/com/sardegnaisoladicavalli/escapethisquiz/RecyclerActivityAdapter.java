package com.sardegnaisoladicavalli.escapethisquiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
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
        cardViewHolder.questionField.setText(ci.question);
        cardViewHolder.answer1.setText(ci.radioText1);
        cardViewHolder.answer2.setText(ci.radioText2);
        cardViewHolder.answer3.setText(ci.radioText3);
        cardViewHolder.answer4.setText(ci.radioText4);
        cardViewHolder.image.setImageResource(ci.image);
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
        protected RadioButton answer1;
        protected RadioButton answer2;
        protected RadioButton answer3;
        protected RadioButton answer4;

        protected ImageView image;

        public CardViewHolder(View v) {
            super(v);

            vTitle = (TextView) v.findViewById(R.id.card_text);
            questionField = (TextView) v.findViewById(R.id.card_question);
            answer1=v.findViewById(R.id.card_answer1);
            answer2=v.findViewById(R.id.card_answer2);
            answer3=v.findViewById(R.id.card_answer3);
            answer4=v.findViewById(R.id.card_answer4);
            image=v.findViewById(R.id.card_image);
        }
    }
}
