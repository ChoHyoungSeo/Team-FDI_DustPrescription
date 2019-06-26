package com.cookandroid.registration.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.registration.R;

import java.util.List;


public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.MyViewHolder> implements  View.OnClickListener{
    private List<String> quest_body;
    private List<Integer> quest_icon;
    private  static Context con;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView quest_body;
        public ImageView quest_icon;
        public RelativeLayout btn;

        public MyViewHolder(View v) {
            super(v);
            quest_body = v.findViewById(R.id.quest_body);
            quest_icon = v.findViewById(R.id.quest_icon);
            btn = v.findViewById(R.id.btn_quest);
        }
    }

    public QuestAdapter(List item1, List item2, Context cont) {
        quest_body = item1;
        quest_icon = item2;
        con = cont;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quest, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.btn.setOnClickListener(QuestAdapter.this);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.quest_body.setText(quest_body.get(position));
        holder.quest_icon.setBackgroundResource(quest_icon.get(position));
        // 데이터셋 넘겨받아서 상황에 따라 바꿔주기
    }

    @Override
    public int getItemCount() {
        return quest_body.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_quest){
            RelativeLayout btn = v.findViewById(R.id.btn_quest);
            btn.setBackgroundResource(R.drawable.searchline1);
            btn.setEnabled(false);
            //퀘스트클릭시 객체 에드 해주기

            notifyDataSetChanged();

            Toast.makeText(con,"예방 완료!",Toast.LENGTH_SHORT).show();
        }
    }
}