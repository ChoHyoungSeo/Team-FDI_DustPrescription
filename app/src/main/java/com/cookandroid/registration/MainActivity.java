package com.cookandroid.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView apidisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiParsing ap = new ApiParsing();
        Item item = ap.Apiupdate();

        apidisplay = findViewById(R.id.apidata);

        apidisplay.setText("시간: "+item.getDataTime()+"\n"
        +"미세먼지 농도: "+item.getPm10Value()+"\n"
        +"초미세먼지 농도: " + item.getPm25Value() + "\n"
        +"미세먼지 등급" + item.getPm10Grade() + "\n"
        +"초미세먼지 등급: "+item.getPm25Grade());
    }
}
