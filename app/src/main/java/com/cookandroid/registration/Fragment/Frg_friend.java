package com.cookandroid.registration.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cookandroid.registration.R;

public class Frg_friend extends Fragment {
    Button friend01, friend02, friend03, friend04, friend05;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_friend, container, false);

        friend01 = v.findViewById(R.id.friend01);
        friend02 = v.findViewById(R.id.friend02);
        friend03 = v.findViewById(R.id.friend03);
        friend04 = v.findViewById(R.id.friend04);
        friend05 = v.findViewById(R.id.friend05);

        friend01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(container.getContext(),
                        R.layout.frg_message1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(container.getContext());
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        friend02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(container.getContext(),
                        R.layout.frg_message2,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(container.getContext());
                dlg.setView(dialogView);
                dlg.show();

            }
        });
        friend03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(container.getContext(),
                        R.layout.frg_message3,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(container.getContext());
                dlg.setView(dialogView);
                dlg.show();

            }
        });
        friend04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(container.getContext(),
                        R.layout.frg_message4,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(container.getContext());
                dlg.setView(dialogView);
                dlg.show();

            }
        });
        friend05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(container.getContext(),
                        R.layout.frg_message5,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(container.getContext());
                dlg.setView(dialogView);
                dlg.show();

            }
        });
        return v;
    }

}
