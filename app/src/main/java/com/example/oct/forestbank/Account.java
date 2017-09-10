package com.example.oct.forestbank;
/**
 * 用户主界面
 */

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Account extends AppCompatActivity {
    PtrClassicFrameLayout mMainFrame;//下拉刷新控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        ImageButton mMe=(ImageButton)findViewById(R.id.imgMe);
        mMe.setImageResource(R.mipmap.me_press);
        initView();
    }
    /**
     * 初始化view
     */
    private void initView(){

        //下拉刷新部分
        mMainFrame=(PtrClassicFrameLayout)findViewById(R.id.ptr_frame);
        mMainFrame.setPtrHandler(new PtrHandler(){
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mMainFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mMainFrame.refreshComplete();//刷新完毕
                        refreshDatas();
                    }
                },2000);
            }
        });
    }

    private void refreshDatas(){
        //TODO:首页的数据,活动启动时也刷新一次
    }
}
