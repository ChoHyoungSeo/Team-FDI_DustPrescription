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

import com.cookandroid.registration.Frg_quiz3;
import com.cookandroid.registration.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Frg_quiz2 extends Fragment implements View.OnClickListener {
    long today;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM"+"월 "+"dd"+"일");
    TextView date, quiz;
    LinearLayout quizAnsLayout;
    Button o, x, next;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_quiz2, container, false);

        date = v.findViewById(R.id.date);
        quiz = v.findViewById(R.id.quiz);
        quizAnsLayout = v.findViewById(R.id.quizAnsLayout);
        o = v.findViewById(R.id.o);
        x = v.findViewById(R.id.x);
        next = v.findViewById(R.id.next);

        date.setText(getTime());

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
        Frg_quiz3 frg3 = new Frg_quiz3();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.context_view, frg3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
