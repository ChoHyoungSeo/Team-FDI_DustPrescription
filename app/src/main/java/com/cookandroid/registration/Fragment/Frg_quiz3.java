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

import com.cookandroid.registration.Frg_quiz4;
import com.cookandroid.registration.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Frg_quiz3 extends Fragment implements View.OnClickListener {
    long today;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("mm-dd");
    TextView date, quiz;
    LinearLayout quizAnsLayout;
    Button o, x, next;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_quiz3, container, false);

        date = v.findViewById(R.id.date);
        quiz = v.findViewById(R.id.quiz);
        quizAnsLayout = v.findViewById(R.id.quizAnsLayout);
        o = v.findViewById(R.id.o);
        x = v.findViewById(R.id.x);
        next = v.findViewById(R.id.next);

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

        next.setOnClickListener(this);
        return v;
    }
    //@Override
    public void onClick(View v) {
        Frg_quiz4 frg4 = new Frg_quiz4();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, frg4);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private String getTime() {
        today = System.currentTimeMillis();
        mDate = new Date(today);
        return mFormat.format(mDate);
    }
}
