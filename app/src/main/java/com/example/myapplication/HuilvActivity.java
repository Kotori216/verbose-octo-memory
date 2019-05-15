package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HuilvActivity extends AppCompatActivity {

    double dollarrate;
    double eurorate;
    double wonrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        dollarrate = getIntent().getDoubleExtra("dollar2_key",6.7);
        eurorate = getIntent().getDoubleExtra("euro2_key",7.6);
        wonrate = getIntent().getDoubleExtra("won2_key",0.006);

    }

    public void huilvjisuan(View view){
        TextView input = findViewById(R.id.edittext);
        double rmb = Double.parseDouble(String.valueOf(input.getText()));
        double huilv;
        if(view.getId()==R.id.dollar){
            huilv = dollarrate;
        }
        else if(view.getId()==R.id.euro){
            huilv = eurorate;
        }else{
            huilv=  wonrate;
        }
        double jieguo = huilv*rmb;
        TextView output = findViewById(R.id.text);
        output.setText("结果为："+jieguo);
    }
    public void configactivity(View view){
        openConfig();
    }

    public void openlist(View btn){
        Intent hello = new Intent(this,RateListActivity.class);
        startActivity(hello);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_set){
            openConfig();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void openConfig() {
        Intent hello = new Intent(this,ConfigActivity.class);
        hello.putExtra("dollar_key",dollarrate);
        hello.putExtra("euro_key",eurorate);
        hello.putExtra("won_key",wonrate);
        startActivityForResult(hello,1);
        finish();
    }


}
