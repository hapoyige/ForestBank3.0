package com.example.oct.forestbank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Oct on 2017/9/12.
 */

public class LoginTitle extends LinearLayout implements View.OnClickListener{

    private LinearLayout tabIndividual;
    private LinearLayout tabGroup;
    private ImageButton mIndividual;
    private ImageButton mGroup;

    public LoginTitle(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.login_title,this);
        initView();
        initEvent();
    }

    private void initView(){
        tabIndividual=(LinearLayout)findViewById(R.id.tab_individual);
        tabGroup=(LinearLayout)findViewById(R.id.tab_group);
        mIndividual=(ImageButton)findViewById(R.id.img_individual);
        mGroup=(ImageButton)findViewById(R.id.img_group);
    }

    private void initEvent(){
        tabIndividual.setOnClickListener(this);
        tabGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_individual:
                LoginPerson.actionStart(view.getContext());
                break;
            case R.id.tab_group:
                LoginGroup.actionStart(view.getContext());
                break;
            default:
                break;
        }
    }
}
