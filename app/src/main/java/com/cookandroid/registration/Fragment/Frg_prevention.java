package com.cookandroid.registration.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.registration.Adapter.MissionAdapter;
import com.cookandroid.registration.Adapter.QuestAdapter;
import com.cookandroid.registration.ApiParsing;
import com.cookandroid.registration.Item;
import com.cookandroid.registration.R;

import java.util.ArrayList;
import java.util.List;

public class Frg_prevention extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> dataset;
    private List<Integer> icon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_prevention, container, false);

        recyclerView = v.findViewById(R.id.quest_recyclerView);
        dataset = new ArrayList<>();
        icon = new ArrayList<>();

        ApiParsing ap = new ApiParsing();
        Item item = ap.Apiupdate();

        switch (item.getPm10Grade()){
            case "1":
                dataset.add("물 한잔의 여유를 즐기세요");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("되도록 외출은 삼가세요");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "2":
                dataset.add("물 한잔의 여유를 즐기세요");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("되도록 외출은 삼가세요");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "3":
                dataset.add("물 한잔의 여유를 즐기세요");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("되도록 외출은 삼가세요");
                icon.add(R.drawable.water);
                icon.add(R.drawable.fruits);
                icon.add(R.drawable.window);
                icon.add(R.drawable.cleanner);
                icon.add(R.drawable.indoor);
                break;
            case "4":
                dataset.add("물 한잔의 여유를 즐기세요");
                dataset.add("과일을 섭취해주세요");
                dataset.add("창문은 꼭 닫기");
                dataset.add("먼지를 제거해주세요");
                dataset.add("되도록 외출은 삼가세요");
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
