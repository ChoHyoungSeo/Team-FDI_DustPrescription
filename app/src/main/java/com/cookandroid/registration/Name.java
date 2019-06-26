package com.cookandroid.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Name extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        editText = findViewById(R.id.Edittext_name);
        editText.setImeOptions(EditorInfo.IME_ACTION_GO);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String str1 = editText.getText().toString();
                switch(actionId){
                    case EditorInfo.IME_ACTION_GO:
                        try{
                            FileOutputStream fos = openFileOutput("data.txt", Context.MODE_APPEND);
                            PrintWriter writer = new PrintWriter(fos);
                            writer.println(str1);
                            writer.println("-----------------------------------------");
                            writer.close();
                        } catch(FileNotFoundException e){
                            e.printStackTrace();
                        }

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

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
