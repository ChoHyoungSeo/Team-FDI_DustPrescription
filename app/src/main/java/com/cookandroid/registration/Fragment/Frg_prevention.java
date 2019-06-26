package com.cookandroid.registration.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookandroid.registration.Adapter.QuestAdapter;
import com.cookandroid.registration.ApiParsing;
import com.cookandroid.registration.Item;
import com.cookandroid.registration.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Frg_prevention extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> dataset;
    private List<Integer> icon;
    TextView nameData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_prevention, container, false);

        recyclerView = v.findViewById(R.id.quest_recyclerView);
        dataset = new ArrayList<>();
        icon = new ArrayList<>();
        nameData = v.findViewById(R.id.nameData);

        ApiParsing ap = new ApiParsing();
        Item item = ap.Apiupdate();

        try{
            FileInputStream fis = getContext().openFileInput("name.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String readedtext = new String(buffer);
            nameData.setText(readedtext);
        } catch(IOException e){
            Log.e("파일 읽어오기 실패:", e.getMessage());
        }

        switch (item.getPm10Grade()){
            case "1":
                dataset.add("산책하기");
                dataset.add("창문열어 환기하기");
                dataset.add("적절한 유산소 운동하기");
                dataset.add("먼지를 털어주세요");
                dataset.add("맑은 공기를 즐기세요");
                icon.add(R.drawable.walk);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "2":
                dataset.add("물 한잔 마시기");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("장시간 외출은 삼가세요");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "3":
                dataset.add("물 한잔 마시기");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("가급적 외출은 삼가세요");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "4":
                dataset.add("물 2L 이상 마시기");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("절대 외출 금지");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
        }

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new QuestAdapter(dataset,icon,container.getContext());
        recyclerView.setAdapter(mAdapter);

        return v;
    }
}
