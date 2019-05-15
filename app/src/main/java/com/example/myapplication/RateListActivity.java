package com.example.myapplication;

import android.app.ListActivity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends ListActivity implements Runnable{
    Handler handler;
    public final String TAG ="RateListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread t=new Thread(this);
        t.start();

        handler =new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==7){
                    List<String> list= (List<String>) msg.obj;
                    ListAdapter listAdapter=new ArrayAdapter<String>(RateListActivity.this,android.R.layout.simple_list_item_1,list);
                    setListAdapter(listAdapter);
                }
                super.handleMessage(msg);
            }
        };
    }

    @Override
    public void run() {
        //实现对网页数据的解析，提取为列表所需数据
        List<String> retList =new ArrayList<String>();

        Bundle bundle =new Bundle();
        Document doc = null;
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doc = Jsoup.connect("http://www.usd-cny.com/bankofchina.htm").get();
            Elements tables =doc.getElementsByTag("table");
            Element table1=tables.get(0);

            Elements tds=table1.getElementsByTag("td");
            for(int i=0;i<tds.size();i+=6){
                Element td1 = tds.get(i);
                Element td2 =tds.get(i+5);

                String str =td1.text();
                String val =td2.text();


                retList.add(str+"==>"+val);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Message msg =handler.obtainMessage(7);
        msg.obj=retList;
        handler.sendMessage(msg);

    }
}
