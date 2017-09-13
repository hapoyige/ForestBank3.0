package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterPerson extends AppCompatActivity implements View.OnClickListener{
    //用于适配地区选择
    private Spinner spinner;
    private List<String> locationList;
    private ArrayAdapter<String> arrAdapter;

    //按钮
    private Button confirmRegister;
    private Button cancelRegister;

    public static void actionStart(Context context){
        Intent intent=new Intent(context,RegisterPerson.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_person);
        initViews();
        initEvents();
    }

    private void initViews() {
        confirmRegister = (Button) findViewById(R.id.confirm_button);
        cancelRegister = (Button) findViewById(R.id.cancel_button);

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
