package com.example.oct.forestbank;
/**
 * 用户主界面
 */

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Account extends AppCompatActivity implements View.OnClickListener{
    PtrClassicFrameLayout mMainFrame;//下拉刷新控件

    //按钮
    private Button bankCardButton;
    private Button rechargeButton;
    private Button takecashButton;
    private Button recordButton;

    private String bankCardNumber="";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //隐藏默认标签
        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        ImageButton mMe=(ImageButton)findViewById(R.id.imgMe);
        mMe.setImageResource(R.mipmap.me_press);
        initView();
        initEvents();
    }
    /**
     * 初始化view
     */
    private void initView(){

        bankCardButton=(Button)findViewById(R.id.bank_card_button);
        rechargeButton=(Button)findViewById(R.id.recharge_button);
        takecashButton=(Button)findViewById(R.id.take_cash_button);
        recordButton=(Button)findViewById(R.id.carbon_record);
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
        //TODO:首页的数据,活动启动时也刷新一次
    }
    private void initEvents(){
        bankCardButton.setOnClickListener(this);
        rechargeButton.setOnClickListener(this);
        takecashButton.setOnClickListener(this);
        recordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bank_card_button:
                showBankCardDialog();
                break;
            case R.id.recharge_button:
                showRechargeDialog();
                break;
            case R.id.take_cash_button:
                showTakeCashDialog();
                break;
            default:
                break;
        }
    }

    /**
     * 弹出银行卡窗口
     */
    private void showBankCardDialog(){
        builder = new AlertDialog.Builder(this);
        //TODO:获取银行卡号
        builder.setTitle("银行卡");
        if(!bankCardNumber.equals(""))
            builder.setMessage("卡号:\n"+bankCardNumber);
        else
            builder.setMessage("您尚未绑定银行卡!");
        builder.setCancelable(true);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * 弹出充值窗口
     */
    private void showRechargeDialog(){
        builder = new AlertDialog.Builder(this);
        View rechargeDialog=View.inflate(Account.this,
                R.layout.recharge_dialog,null);
        Button confirmButton=(Button)rechargeDialog.findViewById(R.id.confirm_button);
        Button cancelButton=(Button)rechargeDialog.findViewById(R.id.cancel_button);

        builder.setView(rechargeDialog);
        builder.setTitle("充值");
        //TODO:设置控件的值,初始化参考Bank类的相关操作
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
     * 弹出提现窗口
     */
    private void showTakeCashDialog(){
        builder = new AlertDialog.Builder(this);
        View takeCashDialog=View.inflate(Account.this,
                R.layout.take_cash_dialog,null);
        Button confirmButton=takeCashDialog.findViewById(R.id.confirm_button);
        Button cancelButton=takeCashDialog.findViewById(R.id.cancel_button);

        builder.setView(takeCashDialog);
        builder.setTitle("提现");
        //TODO:设置控件的值,初始化参考Bank类的相关操作
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
