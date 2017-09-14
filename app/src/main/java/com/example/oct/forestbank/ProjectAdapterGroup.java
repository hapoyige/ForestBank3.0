package com.example.oct.forestbank;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Oct on 2017/9/14.
 */

public class ProjectAdapterGroup extends
        RecyclerView.Adapter<ProjectAdapterGroup.ViewHolder>{
    private List<ProjectItemGroup> mProjectList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View projectView;
        TextView projectName;
        TextView projectStatus;

        public ViewHolder(View view){
            super(view);
            projectView=view;
            projectName=(TextView) view.findViewById(R.id.project_name);
            projectStatus=(TextView)view.findViewById(R.id.project_status);
        }
    }

    public ProjectAdapterGroup(List<ProjectItemGroup> ProjectList){
        mProjectList=ProjectList;
    }

    @Override
    public ViewHolder onCreateViewHolder
            (ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_item_group,parent,false);
        final ViewHolder holder= new ViewHolder(view);
        holder.projectView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                ProjectItemGroup project=mProjectList.get(position);
                Project.actionStart(view.getContext(),project.id);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ProjectAdapterGroup.ViewHolder holder, int position){
        ProjectItemGroup project=mProjectList.get(position);
        holder.projectName.setText(project.getProjectName());
        int status =project.getStatus();
        switch (status){
            case 0:
                holder.projectStatus.setText("active");
                holder.projectStatus.setTextColor(Color.GREEN);
                break;
            case 1:
                holder.projectStatus.setText("done");
                holder.projectStatus.setTextColor(Color.YELLOW);
                break;
            case 2:
                holder.projectStatus.setText("failed");
                holder.projectStatus.setTextColor(Color.RED);
                break;
            default:
                break;
        }
    }
    @Override
    public int getItemCount(){
        return mProjectList.size();
    }
}
