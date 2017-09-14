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

    final int DATE_DIALOG1=1;
    final int DATE_DIALOG2=2;
    final int DATE_DIALOG3=3;
    final int DATE_DIALOG4=4;

    int year1,month1,day1;
    int year2,month2,day2;
    int year3,month3,day3;
    int year4,month4,day4;

    //设置日期的按钮
    private Button setRaiseStartButton;
    private Button setRaiseEndButton;
    private Button setProjectStartButton;
    private Button setProjectEndButton;

    //展示的日期
    private TextView raiseStartTime;
    private TextView raiseEndTime;
    private TextView projectStartTime;
    private TextView projectEndTime;

    //确认取消按钮
    private Button handInButton;
    private Button cancelButton;

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
        setRaiseEndButton=(Button)
                findViewById(R.id.set_raise_end_button);
        setProjectStartButton=(Button)
                findViewById(R.id.set_project_start_button);
        setProjectEndButton=(Button)
                findViewById(R.id.set_project_end_button);

        raiseStartTime=(TextView)
                findViewById(R.id.raise_start_time);
        raiseEndTime=(TextView)
                findViewById(R.id.raise_end_time);
        projectStartTime=(TextView)
                findViewById(R.id.project_start_time);
        projectEndTime=(TextView)
                findViewById(R.id.project_end_time);

        handInButton=(Button)findViewById(R.id.hand_in_button);
        cancelButton=(Button)findViewById(R.id.cancel_button);
    }

    private void initEvents(){
        setRaiseStartButton.setOnClickListener(this);
        setRaiseEndButton.setOnClickListener(this);
        setProjectStartButton.setOnClickListener(this);
        setProjectEndButton.setOnClickListener(this);

        handInButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.set_raise_start_button:
                showDialog(DATE_DIALOG1);
                break;
            case R.id.set_raise_end_button:
                showDialog(DATE_DIALOG2);
                break;
            case R.id.set_project_start_button:
                showDialog(DATE_DIALOG3);
                break;
            case R.id.set_project_end_button:
                showDialog(DATE_DIALOG4);
                break;
            case R.id.hand_in_button:
                publishProject();
                finish();
                break;
            case R.id.cancel_button:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DATE_DIALOG1:
                return new DatePickerDialog(this, mdateListener1, year1,month1,day1);
            case DATE_DIALOG2:
                return new DatePickerDialog(this, mdateListener2, year2,month2,day2);
            case DATE_DIALOG3:
                return new DatePickerDialog(this, mdateListener3, year3,month3,day3);
            case DATE_DIALOG4:
                return new DatePickerDialog(this, mdateListener4, year4,month4,day4);
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
    public void display1() {
        raiseStartTime.setText(new StringBuffer().append(month1 + 1)
                .append("-").append(day1).append("-").append(year1).append(" "));
    }




    private DatePickerDialog.OnDateSetListener mdateListener2 =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    year2 = year;
                    month2 = monthOfYear;
                    day2 = dayOfMonth;
                    display2();
                }
            };
    public void display2() {
        raiseEndTime.setText(new StringBuffer().append(month2 + 1)
                .append("-").append(day2).append("-").append(year2).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener3 =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    year3 = year;
                    month3 = monthOfYear;
                    day3 = dayOfMonth;
                    display3();
                }
            };
    public void display3() {
        projectStartTime.setText(new StringBuffer().append(month3 + 1)
                .append("-").append(day3).append("-").append(year3).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener4 =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    year4 = year;
                    month4 = monthOfYear;
                    day4 = dayOfMonth;
                    display4();
                }
            };
    public void display4() {
        projectEndTime.setText(new StringBuffer().append(month4 + 1)
                .append("-").append(day4).append("-").append(year4).append(" "));
    }

    /**
     * 发布项目的相关操作
     */
    private void publishProject(){
        //TODO:为这个项目注册
    }
}
