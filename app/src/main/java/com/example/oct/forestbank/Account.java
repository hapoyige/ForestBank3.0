package com.example.oct.forestbank;
/**
 * 用户主界面
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        TextView balance=(TextView)findViewById(R.id.balance);
        TextView wallet=(TextView)findViewById(R.id.wallet);
        TextView carbonData=(TextView)findViewById(R.id.carbon_data);
        //TODO:获取用户界面的各种余额信息
        balance.setText("余额：");
        wallet.setText("碳钱包：");
        carbonData.setText("碳数据：");
    }
}
