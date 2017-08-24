package com.example.oct.forestbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * Created by Oct on 2017/8/22.
 * 底部的用于页面转换的标签，暂时不用修改
 */

public class TitleLayout extends LinearLayout implements View.OnClickListener{

    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button homePageButton=(Button)findViewById(R.id.homePageButton);
        Button investmentButton=(Button)findViewById(R.id.investmentButton);
        Button bankButton=(Button)findViewById(R.id.bankButton);
        Button accountButton=(Button)findViewById(R.id.accountButton);
        homePageButton.setOnClickListener(this);
        investmentButton.setOnClickListener(this);
        bankButton.setOnClickListener(this);
        accountButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Activity currentActivity=(Activity)getContext();
        Class targetActivity;
        switch(v.getId()){
            case R.id.homePageButton:
                targetActivity=HomePage.class;
                break;
            case R.id.accountButton:
                targetActivity=Account.class;
                break;
            case R.id.bankButton:
                targetActivity=Bank.class;
                break;
            case R.id.investmentButton:
                targetActivity=Investment.class;
                break;
            default:
                targetActivity=currentActivity.getClass();
        }
        Intent intent=new Intent(currentActivity,targetActivity);
        getContext().startActivity(intent);
    }
}
