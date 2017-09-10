package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Project extends AppCompatActivity {
    private String id;
    //文本控件
    //项目名称
    private TextView name;
    //众筹开始时间
    private TextView fundRaiseStartTime;
    //众筹结束时间
    private TextView fundRaiseEndTime;
    //目标筹款额
    private TextView totalRaiseMoney;
    //目前筹款额度
    private TextView currentRaiseMoney;
    //项目动工时间
    private TextView projectStartTime;
    //项目完工时间
    private TextView projectEndTime;
    //收益率
    private TextView returnRate;
    //发起人姓名
    private TextView organizer;

    /**
     * 初始化控件
     */
    private void initViews(){
        name=(TextView)findViewById(R.id.project_name);
        fundRaiseStartTime=(TextView)findViewById(R.id.fund_raise_start_time);
        fundRaiseEndTime=(TextView)findViewById(R.id.fund_raise_end_time);
        totalRaiseMoney=(TextView)findViewById(R.id.total_raise_money);
        currentRaiseMoney=(TextView)findViewById(R.id.current_raise_money);
        projectStartTime=(TextView)findViewById(R.id.project_start_time);
        projectEndTime=(TextView)findViewById(R.id.project_end_time);
        returnRate=(TextView)findViewById(R.id.return_rate);
        organizer=(TextView)findViewById(R.id.organizer);
    }
    /**
     * TODO:初始化项目数据
     */
    private void loadData(){

    }
    /**
     * 启动活动时调用
     */
    public static void actionStart(Context context,String id){
        Intent intent=new Intent(context,Project.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);
        initViews();
        loadData();
        //获取该项目的ID
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        Toast.makeText(this.getApplication(),"My id is"+id,Toast.LENGTH_SHORT).show();
    }
}
