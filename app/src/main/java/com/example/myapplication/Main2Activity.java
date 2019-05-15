package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //final TextView textView=findViewById(R.id.textsca);
        //int sca = Integer.parseInt(textView.getText().toString());
    }
    public void plus1(View v){
        TextView textView=findViewById(R.id.textsca);
        int sca = Integer.parseInt(textView.getText().toString());
        sca++;
        textView.setText(String.valueOf(sca));
    }
}
