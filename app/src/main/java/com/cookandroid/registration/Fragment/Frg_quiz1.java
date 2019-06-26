package com.cookandroid.registration.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cookandroid.registration.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Frg_quiz1 extends Fragment implements View.OnClickListener {
    long today;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM"+"월 "+"dd"+"일");
    TextView date, quiz;
    LinearLayout quizAnsLayout;
    Button o, x, next;
    private List<String[]> dataset;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_quiz1, container, false);

        date = v.findViewById(R.id.date);
        quiz = v.findViewById(R.id.quiz);
        quizAnsLayout = v.findViewById(R.id.quizAnsLayout);
        o = v.findViewById(R.id.o);
        x = v.findViewById(R.id.x);
        next = v.findViewById(R.id.next);
        dataset = new ArrayList<>();

        date.setText(getTime());

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizAnsLayout.setVisibility(View.VISIBLE);
                dataset.add(new String[]{"0", "3", "오늘의 미세퀴즈를 3문제를 풀어보세요"});
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizAnsLayout.setVisibility(View.VISIBLE);
                dataset.add(new String[]{"0", "3", "오늘의 미세퀴즈를 3문제를 풀어보세요"});
            }
        });

        next.setOnClickListener(this);
        return v;
    }


    private String getTime() {
        today = System.currentTimeMillis();
        mDate = new Date(today);
        return mFormat.format(mDate);
    }

    @Override
    public void onClick(View v) {
        Frg_quiz2 frg2 = new Frg_quiz2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.context_view, frg2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}



