package com.cookandroid.registration;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.MyViewHolder> {
    private List<String> quest_string, quest_num;
    private List<Integer> icon;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView quest_body, perform_num;
        public ImageView quest_icon;

        public MyViewHolder(View v) {
            super(v);
            quest_body = v.findViewById(R.id.quest_body);
            perform_num = v.findViewById(R.id.perform_number);
            quest_icon = v.findViewById(R.id.quest_img);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QuestAdapter(List questString, List performnum, List icon_d) {
        quest_string = questString;
        quest_num = performnum;
        icon = icon_d;
    }

    @Override
    public QuestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_quest, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.quest_body.setText(quest_string.get(position));
        holder.quest_icon.setImageResource(icon.get(position));
        holder.perform_num.setText(quest_num.get(position));
        // 데이터셋 넘겨받아서 상황에 따라 바꿔주기

    }

    @Override
    public int getItemCount() {
        return icon.size();
    }
}
