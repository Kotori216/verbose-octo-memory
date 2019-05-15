package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.text);
        Button btn = findViewById(R.id.btn);
        //Button btn2 = findViewById(R.id.toact2);
        final TextView edittext=findViewById(R.id.edittext);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                double c = Double.parseDouble(String.valueOf(edittext.getText()));
                double f = c*1.8+32;
                textView.setText("结果为："+f);
            }
        });


    }
    public void open2(View btn){
        Intent hello = new Intent(this,Main2Activity.class);
        startActivity(hello);
        finish();
    }
    public void openhuilv(View btn){
        Intent hello = new Intent(this,HuilvActivity.class);
        startActivity(hello);
        finish();
    }


}
