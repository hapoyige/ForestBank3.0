package com.example.oct.forestbank;
/**
 * 森林银行界面
 */

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Bank extends AppCompatActivity implements View.OnClickListener{
    PtrClassicFrameLayout mMainFrame;//下拉刷新控件
    AlertDialog.Builder builder;//构建弹窗
    //四个按钮
    private Button depositButton;
    private Button loanButton;
    private Button withdrawButton;
    private Button repayButton;

    //显示在银行页面的文本
    //存款利率/日
    private TextView depositInterest;
    //用户当前存款
    private TextView balance;
    //贷款利息
    private TextView loanInterest;
    //用户已贷款的数额
    private TextView loanAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        ImageButton mBank=(ImageButton)findViewById(R.id.imgForest);
        mBank.setImageResource(R.mipmap.forest_press);
        initView();
        initEvent();
    }

    private  void initEvent(){
        depositButton.setOnClickListener(this);
        loanButton.setOnClickListener(this);
        withdrawButton.setOnClickListener(this);
        repayButton.setOnClickListener(this);
    }
    /**
     * 初始化view
     */
    private void initView(){
        //按钮
        depositButton=(Button)findViewById(R.id.deposit_button);
        loanButton=(Button)findViewById(R.id.loan_button);
        withdrawButton=(Button)findViewById(R.id.withdraw_button);
        repayButton=(Button)findViewById(R.id.repay_button);
        //文本
        depositInterest=(TextView)findViewById(R.id.deposit_interest);
        balance=(TextView)findViewById(R.id.balance);
        loanInterest=(TextView)findViewById(R.id.loan_interest);
        loanAmount=(TextView)findViewById(R.id.loan_amount);
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
        //TODO:银行显示的数据(初始化过的那些文本),活动启动时也刷新一次
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.deposit_button:
                showDepositDialog(view);
                break;
            case R.id.loan_button:
                showLoanDialog(view);
                break;
            case R.id.withdraw_button:
                showWithdrawDialog(view);
                break;
            case R.id.repay_button:
                showRepayDialog(view);
                break;
            default:
                break;
        }
    }

    /**
     * 显示存款窗口
     * @param view
     */
    private void showDepositDialog(View view){
        builder = new AlertDialog.Builder(this);
        View depositDialog=View.inflate(Bank.this,R.layout.deposit_dialog,null);
        //获取布局中的控件
        Button confirmButton=(Button)depositDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)depositDialog.findViewById(R.id.cancel_button);
        TextView balance=(TextView)depositDialog.findViewById(R.id.balance);
        TextView interest=(TextView)depositDialog.findViewById(R.id.deposit_interest);
        EditText depositAmount=(EditText)depositDialog.findViewById(R.id.deposit_amount);
        EditText password=(EditText) depositDialog.findViewById(R.id.deal_password);
        //TODO:从数据库读入余额等值


        builder.setView(depositDialog);
        builder.setTitle("存款");
        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:确认信息后的操作
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

    /**
     * 显示贷款窗口
     * @param view
     */
    private void showLoanDialog(View view){
        builder = new AlertDialog.Builder(this);
        View loanDialog=View.inflate(Bank.this,R.layout.loan_dialog,null);
        //获取布局中的控件
        Button confirmButton=(Button)loanDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)loanDialog.findViewById(R.id.cancel_button);
        TextView loanMax=(TextView)loanDialog.findViewById(R.id.loan_max);
        TextView interest=(TextView)loanDialog.findViewById(R.id.loan_interest);
        EditText loanAmount=(EditText) loanDialog.findViewById(R.id.loan_amount);
        EditText password=(EditText) loanDialog.findViewById(R.id.deal_password);
        //TODO:从数据库读入余额等值


        builder.setView(loanDialog);
        builder.setTitle("贷款");
        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:确认信息后的操作
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

    /**
     * 显示取款窗口
     * @param view
     */
    private void showWithdrawDialog(View view){
        builder = new AlertDialog.Builder(this);
        View withdrawDialog=View.inflate(Bank.this,R.layout.withdraw_dialog,null);
        //获取布局中的控件
        Button confirmButton=(Button)withdrawDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)withdrawDialog.findViewById(R.id.cancel_button);
        TextView balance=(TextView)withdrawDialog.findViewById(R.id.balance);
        EditText withdrawAmount=(EditText) withdrawDialog.findViewById(R.id.withdraw_amount);
        EditText password=(EditText)withdrawDialog.findViewById(R.id.deal_password);

        //TODO:从数据库读入余额等值


        builder.setView(withdrawDialog);
        builder.setTitle("取款");
        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:确认信息后的操作
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

    /**
     * 显示还贷款窗口
     * @param view
     */
    private void showRepayDialog(View view){
        builder = new AlertDialog.Builder(this);
        View repayDialog=View.inflate(Bank.this,R.layout.repay_dialog,null);
        //获取布局中的控件
        Button confirmButton=(Button)repayDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)repayDialog.findViewById(R.id.cancel_button);
        TextView arrear=(TextView)repayDialog.findViewById(R.id.arrear);
        TextView interest=(TextView)repayDialog.findViewById(R.id.loan_interest);
        EditText repayAmount=(EditText) repayDialog.findViewById(R.id.repay_amount);
        EditText password=(EditText)repayDialog.findViewById(R.id.deal_password);

        //TODO:从数据库读入余额等值


        builder.setView(repayDialog);
        builder.setTitle("还贷");
        final AlertDialog alertDialog = builder.create();
        //监听两个按钮
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO:确认信息后的操作
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
