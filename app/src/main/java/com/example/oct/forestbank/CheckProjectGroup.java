package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class CheckProjectGroup extends AppCompatActivity {

    PtrClassicFrameLayout mMainFrame;//下拉刷新控件
    private List<ProjectItemGroup> projectsList=new ArrayList<>();

    public static void actionStart(Context context){
        Intent intent=new Intent(context,CheckProjectGroup.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_project_group);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        initProjects();
        RecyclerView recyclerView=(RecyclerView)
                findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProjectAdapterGroup adapter=new ProjectAdapterGroup(projectsList);
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
            public boolean checkCanDoRefresh(PtrFrameLayout frame,
                                             View content, View header) {
                return PtrDefaultHandler.
                        checkContentCanBePulledDown(frame,content,header);
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
        ProjectItemGroup projectItem1 =
                new ProjectItemGroup("green",0);
        projectsList.add(projectItem1);

        ProjectItemGroup projectItem2 =
                new ProjectItemGroup("yellow",1);
        projectsList.add(projectItem2);
    }
}
