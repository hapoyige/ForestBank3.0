package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginGroup extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private Button registerButton;
    private Button repasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_group);
        initViews();
        initEvents();
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,LoginGroup.class);
        context.startActivity(intent);
    }

    private void initViews(){
        loginButton=(Button)findViewById(R.id.confirm_login_button);
        registerButton=(Button)findViewById(R.id.register_button);
        repasswordButton=(Button)findViewById(R.id.repassword_button);
        ImageButton mGroup=(ImageButton)findViewById(R.id.img_group);
        mGroup.setImageResource(R.mipmap.group_press);
    }

    private void initEvents(){
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        repasswordButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm_login_button:
                //TODO:企业登录的后续操作
                finish();
                break;
            case R.id.register_button:
                RegisterGroup.actionStart(view.getContext());
                break;
            case R.id.repassword_button:
                //找回密码的后续操作，我界面暂时还没写
                break;
            default:
                break;
        }
    }
}
