package com.example.oct.forestbank;
/**
 * 用户主界面
 */

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

    private TextView balance;
    private TextView wallet;
    private TextView carbonData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ImageButton mMe=(ImageButton)findViewById(R.id.imgMe);
        mMe.setImageResource(R.mipmap.me_press);
        initView();
    }
    /**
     * 初始化view
     */
    private void initView(){
        balance=(TextView)findViewById(R.id.balance);
        wallet=(TextView)findViewById(R.id.wallet);
        carbonData=(TextView)findViewById(R.id.carbon_data);

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
        balance.setText("余额：0");
        wallet.setText("碳钱包：0");
        carbonData.setText("碳数据：0");
    }
}
