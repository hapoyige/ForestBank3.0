package com.example.oct.forestbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity
        implements View.OnClickListener{

    private Button individualButton;
    private Button groupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        initViews();
        initEvents();
    }

    private void initViews(){
        individualButton=(Button)findViewById
                (R.id.individual_enter_button);
        groupButton=(Button)findViewById
                (R.id.group_enter_button);
    }

    private void initEvents(){
        individualButton.setOnClickListener(this);
        groupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.individual_enter_button:
                LoginPerson.actionStart(view.getContext());
                finish();
                break;
            case R.id.group_enter_button:
                LoginGroup.actionStart(view.getContext());
                finish();
                break;
            default:
                break;
        }
    }
}
