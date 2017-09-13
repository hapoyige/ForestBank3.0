package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterGroup extends AppCompatActivity
        implements View.OnClickListener{
    //按钮
    private Button confirmRegister;
    private Button cancelRegister;

    public static void actionStart(Context context){
        Intent intent=new Intent(context,RegisterGroup.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_group);
        initViews();
        initEvents();
    }
    private void initViews() {
        confirmRegister = (Button) findViewById(R.id.confirm_button);
        cancelRegister = (Button) findViewById(R.id.cancel_button);
    }
    private void initEvents(){
        confirmRegister.setOnClickListener(this);
        cancelRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm_button:
                if(isRegisterSuccessful()){
                    Toast.makeText(getApplicationContext(), "注册成功",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "注册信息有误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel_button:
                finish();
                break;
            default:
                break;
        }
    }

    private boolean isRegisterSuccessful(){
        //TODO：完成注册操作,返回注册是否成功
        return true;
    }
}
