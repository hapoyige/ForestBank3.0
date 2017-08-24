package com.example.oct.forestbank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Oct on 2017/8/23.
 * 用户主界面的账号信息
 */

public class UserInfoLayout extends LinearLayout {
    public UserInfoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.user_info, this);
        ImageView avatar=(ImageView)findViewById(R.id.avatar);//头像
        TextView teleNumber=(TextView)findViewById(R.id.telephone);
        //TODO:添加用户信息
        avatar.setImageResource(R.mipmap.ic_launcher_round);
        teleNumber.setText("13900010002");
    }
}
