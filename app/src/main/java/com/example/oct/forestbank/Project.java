package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    private Button investButton;
    private Button backButton;

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

        investButton=(Button)findViewById(R.id.invest_this_button);
        backButton=(Button)findViewById(R.id.back_button);
    }
    private void initEvents(){
        investButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showInvestDialog();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        setContentView(R.layout.activity_project);
        initViews();
        loadData();
        //获取该项目的ID
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        Toast.makeText(this.getApplication(),"My id is"+id,Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示投资窗口
     */
    private void showInvestDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        View investDialog=View.inflate(Project.this,R.layout.invest_dialog,null);
        Button confirmButton=(Button)investDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)investDialog.findViewById(R.id.cancel_button);

        //TODO:读取该项目筹款情况
        builder.setView(investDialog);
        builder.setTitle("投资项目");
        final AlertDialog alertDialog = builder.create();

        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:确认投资后的操作
                alertDialog.dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
