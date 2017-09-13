package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginPerson extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private Button registerButton;
    private Button repasswordButton;

    private EditText accountNumber;
    private EditText userName;
    private EditText userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_person);
        initViews();
        initEvents();
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,LoginPerson.class);
        context.startActivity(intent);
    }

    private void initViews(){
        loginButton=(Button)findViewById(R.id.confirm_login_button);
        registerButton=(Button)findViewById(R.id.register_button);
        repasswordButton=(Button)findViewById(R.id.repassword_button);

        accountNumber=(EditText)findViewById(R.id.account_number);
        userName=(EditText)findViewById(R.id.user_name);
        userPassword=(EditText)findViewById(R.id.user_password);
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
                if(isPasswordCorrect()) {
                    Toast.makeText(getApplicationContext(), "登录成功",
                            Toast.LENGTH_SHORT).show();
                    HomePage.actionStart(view.getContext());
                    finish();
                }
                else{
                    AlertDialog.Builder builder=
                            new AlertDialog.Builder(this);
                    builder.setMessage("用户名或密码错误");
                    userPassword.setText("");
                    builder.setCancelable(true);
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                break;
            case R.id.register_button:
                RegisterPerson.actionStart(view.getContext());
                break;
            case R.id.repassword_button:
                //找回密码的后续操作，我界面暂时还没写
                break;
            default:
                break;
        }
    }
    private boolean isPasswordCorrect(){
        //TODO:验证账号密码是否正确
        return true;
    }
}
