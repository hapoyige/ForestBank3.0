package com.example.oct.forestbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class HomePageGroup extends AppCompatActivity {

    //用于适配地区选择
    private Spinner spinner;
    private List<String> locationList;
    private ArrayAdapter<String> arrAdapter;

    PtrClassicFrameLayout mMainFrame;//下拉刷新控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_group);
        ImageButton mHome=(ImageButton)findViewById(R.id.imgHomePage);
        mHome.setImageResource(R.mipmap.home_press);
        initViews();
        initEvents();
    }

    private void initViews() {

        spinner = (Spinner) findViewById(R.id.location_spinner);
        locationList = new ArrayList<String>();

        //TODO:从数据库中导出所有地区,以下仅作测试
        locationList.add("北京");
        locationList.add("上海");
        locationList.add("广州");
        locationList.add("深圳");

        //适配器
        arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locationList);
        //设置样式
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arrAdapter);
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

    private void initEvents(){
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                refreshDatas();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void refreshDatas(){
        //TODO:刷新首页信息(地区选择变化时)
    }
}
