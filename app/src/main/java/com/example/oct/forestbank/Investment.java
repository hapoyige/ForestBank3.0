package com.example.oct.forestbank;
/**
 * 投资平台页面
 */

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Investment extends AppCompatActivity {

    PtrClassicFrameLayout mMainFrame;//下拉刷新控件
    private List<ProjectItem> projectsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        ImageButton mInvest=(ImageButton)findViewById(R.id.imgInvestment);
        mInvest.setImageResource(R.mipmap.coin_press);
        initProjects();
        RecyclerView recyclerView=(RecyclerView)
                findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProjectAdapter adapter=new ProjectAdapter(projectsList);
        recyclerView.setAdapter(adapter);
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
    private void initProjects(){
        //TODO:将所有Project信息添加到projectList 下面的几行只是测试用
        for(int i=0;i<3;i++) {
            ProjectItem projectItem =
                    new ProjectItem("Greener!", R.drawable.tree, ""+i);
            projectsList.add(projectItem);
        }
    }
}
