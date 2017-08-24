package com.example.oct.forestbank;
/**
 * 投资平台页面
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Investment extends AppCompatActivity {

    private List<InvestProject> projectsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        initProjects();
        RecyclerView recyclerView=(RecyclerView)
                findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProjectAdapter adapter=new ProjectAdapter(projectsList);
        recyclerView.setAdapter(adapter);
    }

    private void initProjects(){
        //TODO:将所有Project信息添加到projectList
        for(int i=0;i<3;i++) {
            InvestProject investProject =
                    new InvestProject("Greener!", R.drawable.tree);
            projectsList.add(investProject);
        }
    }
}
