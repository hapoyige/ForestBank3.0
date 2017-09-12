package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegisterGroup extends AppCompatActivity {

    public static void actionStart(Context context){
        Intent intent=new Intent(context,RegisterGroup.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_group);
    }
}
