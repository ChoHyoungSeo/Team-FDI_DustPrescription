package com.cookandroid.registration.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cookandroid.registration.R;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.MyViewHolder>{
    private List<String[]> mission;
    private  static Context con;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mission_body, perform_num, quest_num;

        public MyViewHolder(View v) {
            super(v);
            mission_body = v.findViewById(R.id.mission_body);
            perform_num = v.findViewById(R.id.quest_perform_num);
            quest_num = v.findViewById(R.id.quest_num);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MissionAdapter(List missions, Context cont) {
        mission = missions;
        con = cont;
    }

    @Override
    public MissionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mission, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mission_body.setText(mission.get(position)[2]);
        holder.quest_num.setText(mission.get(position)[1]);
        holder.perform_num.setText(mission.get(position)[0]);
        // 데이터셋 넘겨받아서 상황에 따라 바꿔주기

    }

    @Override
    public int getItemCount() {
        return mission.size();
    }
}
