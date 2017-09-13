package com.example.oct.forestbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Oct on 2017/9/12.
 */
public class TitleLayoutGroup extends LinearLayout implements View.OnClickListener{

    private LinearLayout tabHome;
    private LinearLayout tabBank;
    private LinearLayout tabPublish;
    private LinearLayout tabWe;
    private LinearLayout tabCheck;
    private LinearLayout tabConverge;

    public TitleLayoutGroup(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        initView();
        initEvent();
    }

    private void initEvent(){
        tabHome.setOnClickListener(this);
        tabBank.setOnClickListener(this);
        tabPublish.setOnClickListener(this);
        tabCheck.setOnClickListener(this);
        tabWe.setOnClickListener(this);
        tabConverge.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    private void initView() {
        tabHome = (LinearLayout) findViewById(R.id.tabHomePage);
        tabBank = (LinearLayout) findViewById(R.id.tabBank);
        tabPublish=(LinearLayout) findViewById(R.id.tabPublish);
        tabCheck=(LinearLayout) findViewById(R.id.tabCheck);
        tabWe=(LinearLayout) findViewById(R.id.tabCompany);
        tabConverge=(LinearLayout) findViewById(R.id.tabConverge);
    }

    @Override
    public void onClick(View v){
        Activity currentActivity=(Activity)getContext();
        Class targetActivity;
        switch(v.getId()){
            case R.id.tabHomePage:
                targetActivity=HomePageGroup.class;
                break;
            case R.id.tabBank:
                targetActivity=Bank.class;
                break;
            case R.id.tabInvestment:
                targetActivity=Investment.class;
                break;
            case R.id.tabMe:
                targetActivity=Account.class;
                break;
            default:
                targetActivity=getContext().getClass();
        }
        Intent intent=new Intent(currentActivity,targetActivity);
        getContext().startActivity(intent);
    }

}
