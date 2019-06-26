package com.cookandroid.registration;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.cookandroid.registration.Fragment.Frg_friend;
import com.cookandroid.registration.Fragment.Frg_main;
import com.cookandroid.registration.Fragment.Frg_prevention;
import com.cookandroid.registration.Fragment.Frg_quiz1;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Frg_main frg1 = new Frg_main();
    private Frg_friend frg2 = new Frg_friend();
    private Frg_prevention frg3 = new Frg_prevention();
    private Frg_quiz1 frg4 = new Frg_quiz1();
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
                        break;
                    case R.id.move:
                        transaction.replace(R.id.context_view,frg3).commitAllowingStateLoss();
                        break;
                    case R.id.quiz:
                        transaction.replace(R.id.context_view,frg4).commitAllowingStateLoss();

                }
                return true;
            }
        });
    }
}
