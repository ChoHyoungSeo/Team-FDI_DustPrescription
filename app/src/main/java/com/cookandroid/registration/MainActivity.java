package com.cookandroid.registration;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Frg_main frg1 = new Frg_main();
    private friend frg2 = new friend();
    private BottomNavigationView navi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi = findViewById(R.id.bottom_navi);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.context_view,frg1).commitAllowingStateLoss();

        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        transaction.replace(R.id.context_view, frg1).commitAllowingStateLoss();
                        break;
                    case R.id.friend:
                        transaction.replace(R.id.context_view,frg2).commitAllowingStateLoss();
                }
                return true;
            }
        });
    }
}
