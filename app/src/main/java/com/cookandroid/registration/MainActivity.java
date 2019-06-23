package com.cookandroid.registration;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView apidisplay;
    TextView apiData, dust, recog;
    ProgressBar dustbar, recogbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> quest_string, questperform_num;
    private List<Integer> icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiParsing ap = new ApiParsing();
        Item item = ap.Apiupdate();

        apidisplay = findViewById(R.id.apipic);
        apiData = findViewById(R.id.apiData);
        dust = findViewById(R.id.dust);
        dustbar = findViewById(R.id.dustbar);
        recog = findViewById(R.id.recog);
        recogbar = findViewById(R.id.recogbar);
        recyclerView = findViewById(R.id.recyclerview);
        quest_string = new ArrayList<>();
        questperform_num= new ArrayList<>();
        icon = new ArrayList<>();

        apiData.setText(item.getDataTime() + "기준" + "\n"
        + "미세먼지 농도: " + item.getPm10Value() + "\n"
        + "초미세먼지 농도: " + item.getPm25Value() + "\n"
        + "미세먼지 등급: " + item.getPm10Grade() + "\n"
        + "초미세먼지 등급: " + item.getPm25Grade() + "\n");

        dustbar.setProgress(Integer.parseInt(item.getPm10Grade()));
        recogbar.setProgress(20);

        switch (item.getPm10Grade()){
            case "1":
                apidisplay.setImageResource(R.drawable.api_1);
                quest_string.add("공기가 좋으니, 산책은 어떠신가요?");
                questperform_num.add("-");
                icon.add(R.drawable.water);
                quest_string.add("공기가 좋으니, 산책은 어떠신가요?");
                questperform_num.add("-");
                icon.add(R.drawable.water);
                break;
            case "2":
                apidisplay.setImageResource(R.drawable.api_2);
                quest_string.add("물을 자주 섭취하세요!");
                questperform_num.add("100");
                icon.add(R.drawable.water);
                quest_string.add("물을 자주 섭취하세요!");
                questperform_num.add("100");
                icon.add(R.drawable.water);
                quest_string.add("물을 자주 섭취하세요!");
                questperform_num.add("100");
                icon.add(R.drawable.water);
                quest_string.add("물을 자주 섭취하세요!");
                questperform_num.add("100");
                icon.add(R.drawable.water);
                quest_string.add("물을 자주 섭취하세요!");
                questperform_num.add("100");
                icon.add(R.drawable.water);
                break;
            case "3":
                apidisplay.setImageResource(R.drawable.api_3);
                quest_string.add("야채 씻어먹기");
                questperform_num.add("2000");
                icon.add(R.drawable.water);
                break;
            case "4":
                apidisplay.setImageResource(R.drawable.api_4);
                quest_string.add("문을 꼭 닫고, 실외활동 자제하세요!");
                questperform_num.add("500");
                icon.add(R.drawable.water);
                break;

        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new QuestAdapter(quest_string,questperform_num,icon,MainActivity.this);
        recyclerView.setAdapter(mAdapter);

    }
}
