package com.example.oct.forestbank;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oct on 2017/9/4.
 */

public class SlidePages extends LinearLayout {
    public ViewPager mViewPager;// 用来放置界面切换  
    public PagerAdapter mPagerAdapter;// 初始化View适配器  
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04

    public SlidePages(Context context, AttributeSet attrs){
        super(context,attrs);
        initViewPage();
        LayoutInflater.from(context).inflate(R.layout.slide_pages,this);
    }

    /**
     * 初始化viewPage
     */
    private void initViewPage(){
        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        LayoutInflater mLayoutInflater = LayoutInflater.from(this.getContext());
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
}
