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
import android.widget.TextView;

import com.cookandroid.registration.R;

public class Frg_friend extends Fragment {
    Button friend01, friend02, friend03, friend04, friend05;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_friend, container, false);

        friend01 = v.findViewById(R.id.friend01);
        friend02 = v.findViewById(R.id.friend02);
        friend03 = v.findViewById(R.id.friend03);
        friend04 = v.findViewById(R.id.friend04);
        friend05 = v.findViewById(R.id.friend05);

        friend01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message frg_msg = new Message();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id., frg_msg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        friend02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message frg_msg = new Message();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id., frg_msg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        friend03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message frg_msg = new Message();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.friend_layout, frg_msg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        friend04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message frg_msg = new Message();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.friend_layout, frg_msg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        friend05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message frg_msg = new Message();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.friend_layout, frg_msg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }

}
