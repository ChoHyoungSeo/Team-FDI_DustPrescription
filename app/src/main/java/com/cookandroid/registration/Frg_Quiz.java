package com.cookandroid.registration;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Frg_Quiz extends Fragment {
    long today;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("mm-dd");
    TextView date, quiz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_main, container, false);

        date = v.findViewById(R.id.date);
        quiz = v.findViewById(R.id.quiz);

        //quiz.setText();
        return v;
    }

    private String getTime() {
        today = System.currentTimeMillis();
        mDate = new Date(today);
        return mFormat.format(mDate);
    }
}
