package com.example.oct.forestbank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Project extends AppCompatActivity {
    private String id;
    public static void actionStart(Context context,String id){
        Intent intent=new Intent(context,Project.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);
        //获取该项目的ID
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        Toast.makeText(this.getApplication(),"My id is"+id,Toast.LENGTH_SHORT).show();
    }
}
