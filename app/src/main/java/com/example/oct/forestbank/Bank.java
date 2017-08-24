package com.example.oct.forestbank;
/**
 * 森林银行界面
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        TextView qutoes=(TextView)findViewById(R.id.qutoes);
        //TODO:获取行情，存储于qutoes
        qutoes.setText("这里应该是一些行情...");
    }
}
