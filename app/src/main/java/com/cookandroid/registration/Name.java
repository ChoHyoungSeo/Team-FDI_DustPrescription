package com.cookandroid.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        EditText editText = (EditText) findViewById(R.id.Edittext_name);
        editText.setImeOptions(EditorInfo.IME_ACTION_GO);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch(actionId){
                    case EditorInfo.IME_ACTION_GO:
                        Intent intent = new Intent(getApplicationContext(), Age.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
    }

}
