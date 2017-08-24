package com.example.oct.forestbank;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Oct on 2017/8/23.
 * 首页的关于地点的信息
 */

public class LocalInfoLayout extends LinearLayout {
    public LocalInfoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.local_info, this);
        TextView cityName=(TextView)findViewById(R.id.city_name);
        ImageView cityInfo=(ImageView)findViewById(R.id.weather_info_image);
        //TODO:添加首页地点及其信息
        cityName.setText("Beijing");
        cityInfo.setImageResource(R.drawable.weather);
    }
}
