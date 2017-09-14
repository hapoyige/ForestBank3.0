package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProjectGroup extends AppCompatActivity {

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

    private Button loanButton;
    private Button stopButton;
    private Button backButton;

    AlertDialog.Builder builder;
    public static void actionStart(Context context, String id){
        Intent intent=new Intent(context,ProjectGroup.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }
    private void initViews() {
        name = (TextView) findViewById(R.id.project_name);
        fundRaiseStartTime = (TextView) findViewById(R.id.fund_raise_start_time);
        fundRaiseEndTime = (TextView) findViewById(R.id.fund_raise_end_time);
        totalRaiseMoney = (TextView) findViewById(R.id.total_raise_money);
        currentRaiseMoney = (TextView) findViewById(R.id.current_raise_money);
        projectStartTime = (TextView) findViewById(R.id.project_start_time);
        projectEndTime = (TextView) findViewById(R.id.project_end_time);
        returnRate = (TextView) findViewById(R.id.return_rate);
        organizer = (TextView) findViewById(R.id.organizer);

        loanButton=(Button)findViewById(R.id.loan_button);
        stopButton=(Button)findViewById(R.id.stop_this_button);
        backButton=(Button)findViewById(R.id.back_button);
    }
    private void initEvents(){
        if(isProjectActive()){
            loanButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    showLoanDialog();
                }
            });
            stopButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    showStopDialog();
                }
            });
            backButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        else{
            loanButton.setClickable(false);
            loanButton.setBackgroundColor(0);
            stopButton.setClickable(false);
            stopButton.setBackgroundColor(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group);
        initViews();
        initEvents();
    }

    private void showLoanDialog(){
        builder=new AlertDialog.Builder(this);
        View loanDialog=View.inflate(ProjectGroup.
                this,R.layout.loan_dialog_group,null);
        //获取布局中的控件
        Button confirmButton=(Button)loanDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)loanDialog.findViewById(R.id.cancel_button);
        builder.setView(loanDialog);
        builder.setTitle("为项目贷款");

        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:项目贷款后的操作
                alertDialog.dismiss();
                finish();
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

    private void showStopDialog(){
        builder=new AlertDialog.Builder(this);
        View stopDialog=View.inflate(ProjectGroup.this,R.layout.stop_project,null);
        //获取布局中的控件
        Button confirmButton=(Button)stopDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)stopDialog.findViewById(R.id.cancel_button);
        builder.setView(stopDialog);
        builder.setTitle("提示");

        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:终止项目后的操作
                alertDialog.dismiss();
                finish();
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
    private boolean isProjectActive(){
        //TODO:返回项目是否active
        return true;
    }
}
