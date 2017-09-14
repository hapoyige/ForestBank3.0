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
        LayoutInflater.from(context).inflate(R.layout.title_group,this);
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
        tabHome = (LinearLayout) findViewById(R.id.tab_home_page);
        tabBank = (LinearLayout) findViewById(R.id.tab_bank);
        tabPublish=(LinearLayout) findViewById(R.id.tab_publish);
        tabCheck=(LinearLayout) findViewById(R.id.tab_check);
        tabWe=(LinearLayout) findViewById(R.id.tab_company);
        tabConverge=(LinearLayout) findViewById(R.id.tab_converge);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.tab_home_page:
                break;
            case R.id.tab_bank:
                break;
            case R.id.tab_publish:
                ProjectAdd.actionStart(v.getContext());
                break;
            case R.id.tab_check:
                CheckProjectGroup.actionStart(v.getContext());
                break;
            case R.id.tab_company:
                break;
            case R.id.tab_converge:
                break;
            default:
                break;
        }
    }
}
