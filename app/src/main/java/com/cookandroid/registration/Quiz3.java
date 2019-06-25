package com.cookandroid.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz3 extends AppCompatActivity {
    long today;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("mm-dd");
    TextView date, quiz;
    LinearLayout quizAnsLayout;
    Button o, x, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        date = findViewById(R.id.date);
        quiz = findViewById(R.id.quiz);
        quizAnsLayout = findViewById(R.id.quizAnsLayout);
        o = findViewById(R.id.o);
        x = findViewById(R.id.x);
        next = findViewById(R.id.next);

        //quiz.setText();

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizAnsLayout.setVisibility(View.VISIBLE);
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizAnsLayout.setVisibility(View.VISIBLE);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Frg_main.class);
                startActivity(intent);
            }
        });
    }

    private String getTime() {
        today = System.currentTimeMillis();
        mDate = new Date(today);
        return mFormat.format(mDate);
    }
}
