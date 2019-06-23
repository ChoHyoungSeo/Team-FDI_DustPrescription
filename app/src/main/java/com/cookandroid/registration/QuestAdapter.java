package com.cookandroid.registration;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.MyViewHolder> implements  View.OnClickListener{
    private List<String> quest_string, quest_num;
    private List<Integer> icon;
    private  static Context con;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView quest_body, perform_num;
        public ImageView quest_icon;
        public RelativeLayout btn;

        public MyViewHolder(View v) {
            super(v);
            quest_body = v.findViewById(R.id.quest_body);
            perform_num = v.findViewById(R.id.perform_number);
            quest_icon = v.findViewById(R.id.quest_img);
            btn = v.findViewById(R.id.btn_quest);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QuestAdapter(List questString, List performnum, List icon_d,Context cont) {
        quest_string = questString;
        quest_num = performnum;
        icon = icon_d;
        con = cont;
    }

    @Override
    public QuestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_quest, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.btn.setOnClickListener(QuestAdapter.this);
        vh.btn.setTag(vh);

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

    @Override
    public void onClick(View v) {
        MyViewHolder holder = (MyViewHolder)v.getTag();
//        ProgressBar my_head = (ProgressBar)v.findViewById(R.id.my_head);
        if(v.getId() == R.id.btn_quest){
//            my_head.incrementProgressBy(25);
            quest_num.remove(holder.getAdapterPosition());
            quest_string.remove(holder.getAdapterPosition());
            icon.remove(holder.getAdapterPosition());

            notifyDataSetChanged();

            Toast.makeText(con,"퀘스트 완료!",Toast.LENGTH_SHORT).show();
        }
    }

    public void removeAt (int position){
        quest_num.remove(position);
        quest_string.remove(position);
        icon.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position,icon.size());
    }


}
