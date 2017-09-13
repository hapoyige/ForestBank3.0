package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
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

public class HomePage extends AppCompatActivity {
    /*
    private ViewPager mViewPager;// 用来放置界面切换  
    private PagerAdapter mPagerAdapter;// 初始化View适配器  
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04
    */
    PtrClassicFrameLayout mMainFrame;//下拉刷新控件

    //文本
    //地区名称
    private TextView cityName;
    //对应的环境质量指数
    private TextView environmentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //试启动登录页面
        LoginPerson.actionStart(getApplicationContext());
        setContentView(R.layout.activity_home_page);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        ImageButton mHome=(ImageButton)findViewById(R.id.imgHomePage);
        mHome.setImageResource(R.mipmap.home_press);
        initView();
        //initEvent();
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,HomePage.class);
        context.startActivity(intent);
    }
    /**
     * 初始化view
     */
    private void initView(){

        cityName=(TextView)findViewById(R.id.city_name);
        environmentIndex=(TextView)findViewById(R.id.environment_index);
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
        cityName.setText("Shanghai");
    }
    /**
     * 初始化viewPage
     */
    /*
    private void initViewPage(){
        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View homePage=mLayoutInflater.inflate(R.layout.activity_home_page,null);
        View bank=mLayoutInflater.inflate(R.layout.activity_bank,null);
        View investment=mLayoutInflater.inflate(R.layout.activity_investment,null);
        View me=mLayoutInflater.inflate(R.layout.activity_account,null);

        mViews.add(homePage);
        mViews.add(bank);
        mViews.add(investment);
        mViews.add(me);
        mPagerAdapter=new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }
    */

}
