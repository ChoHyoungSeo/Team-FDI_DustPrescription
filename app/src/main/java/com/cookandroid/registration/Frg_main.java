package com.cookandroid.registration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Frg_main extends Fragment {
    ImageView apidisplay;
    TextView dust, recog;
    ProgressBar dustbar, recogbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String[]> dataset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.frg_main, container, false);

        ApiParsing ap = new ApiParsing();
        Item item = ap.Apiupdate();

        apidisplay = view1.findViewById(R.id.apipic);
        dust = view1.findViewById(R.id.dust);
        dustbar = view1.findViewById(R.id.dustbar);
        recog = view1.findViewById(R.id.recog);
        recogbar = view1.findViewById(R.id.recogbar);
        recyclerView = view1.findViewById(R.id.recyclerview);
        dataset = new ArrayList<>();

        dustbar.setProgress(Integer.parseInt(item.getPm10Grade()));
        recogbar.setProgress(20);

        switch (item.getPm10Grade()){
            case "1":
                //apidisplay.setImageResource(R.drawable.api_1);
                dataset.add(new String[]{"0", "1", "신선한 공기를 마시며 산책하세요"});
                dataset.add(new String[]{"0", "1", "미세먼지 퀴즈를 풀어보세요"});
                dataset.add(new String[]{"0", "3", "사랑하는 사람에게 미세 문자를 보내주세요"});
                break;
            case "2":
                //apidisplay.setImageResource(R.drawable.api_2);
                dataset.add(new String[]{"0", "5", "5개의 예방책을 수행하세요"});
                dataset.add(new String[]{"0", "1", "미세먼지 퀴즈를 풀어보세요"});
                dataset.add(new String[]{"0", "3", "사랑하는 사람에게 미세 문자를 보내주세요"});
                break;
            case "3":
                //apidisplay.setImageResource(R.drawable.api_3);
                dataset.add(new String[]{"0", "5", "5개의 예방책을 수행하세요"});
                dataset.add(new String[]{"0", "1", "미세먼지 퀴즈를 풀어보세요"});
                dataset.add(new String[]{"0", "3", "사랑하는 사람에게 미세 문자를 보내주세요"});
                break;
            case "4":
                //apidisplay.setImageResource(R.drawable.api_4);
                dataset.add(new String[]{"0", "5", "5개의 예방책을 수행하세요"});
                dataset.add(new String[]{"0", "1", "미세먼지 퀴즈를 풀어보세요"});
                dataset.add(new String[]{"0", "3", "사랑하는 사람에게 미세 문자를 보내주세요"});
                break;

        }

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MissionAdapter( dataset, container.getContext());
        recyclerView.setAdapter(mAdapter);

        return view1;
    }
}
