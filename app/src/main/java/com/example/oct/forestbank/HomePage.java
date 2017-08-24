package com.example.oct.forestbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView news=(TextView)findViewById(R.id.news);
        //TODO:添加首页的新闻资讯
        news.setText("Here should be some infomation...");
    }
}
