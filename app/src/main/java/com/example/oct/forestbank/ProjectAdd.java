package com.example.oct.forestbank;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ProjectAdd extends AppCompatActivity
        implements View.OnClickListener{

    final int DATE_DIALOG=1;
    int year1,month1,day1;
    private Button setRaiseStartButton;

    private TextView raiseStartTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_add);
        initViews();
        initEvents();
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,ProjectAdd.class);
        context.startActivity(intent);
    }

    private void initViews(){
        setRaiseStartButton=(Button)
                findViewById(R.id.set_raise_start_button);
        raiseStartTime=(TextView)
                findViewById(R.id.raise_start_time);
    }

    private void initEvents(){
        setRaiseStartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.set_raise_start_button:
                showDialog(DATE_DIALOG);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener1, year1,month1,day1);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mdateListener1 =
            new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            year1 = year;
            month1 = monthOfYear;
            day1 = dayOfMonth;
            display1();
        }
    };
    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display1() {
        raiseStartTime.setText(new StringBuffer().append(month1 + 1)
                .append("-").append(day1).append("-").append(year1).append(" "));
    }
}
