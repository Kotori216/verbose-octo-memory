package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        double dollarrate = getIntent().getDoubleExtra("dollar_key",6.7);
        double eurorate = getIntent().getDoubleExtra("euro_key",7.6);
        double wonrate = getIntent().getDoubleExtra("won_key",0.006);
        TextView dollar = findViewById(R.id.editdollar);
        TextView euro = findViewById(R.id.editeuro);
        TextView won = findViewById(R.id.editwon);
        dollar.setText(String.valueOf(dollarrate));
        euro.setText(String.valueOf(eurorate));
        won.setText(String.valueOf(wonrate));
    }
    public void configandgoback(View view){
        TextView dollar = findViewById(R.id.editdollar);
        TextView euro = findViewById(R.id.editeuro);
        TextView won = findViewById(R.id.editwon);
        double dollarrate = Double.parseDouble(String.valueOf(dollar.getText()));
        double eurorate = Double.parseDouble(String.valueOf(euro.getText()));
        double wonrate = Double.parseDouble(String.valueOf(won.getText()));
        Intent hello = new Intent(this,HuilvActivity.class);
        hello.putExtra("dollar2_key",dollarrate);
        hello.putExtra("euro2_key",eurorate);
        hello.putExtra("won2_key",wonrate);
        startActivity(hello);
        finish();
    }
}
