package com.example.oct.forestbank;
/**
 * 用于适配投资项目的滚动效果
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Oct on 2017/8/23.
 */

public class ProjectAdapter extends
        RecyclerView.Adapter<ProjectAdapter.ViewHolder>{
    private List<ProjectItem> mProjectList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View projectView;
        ImageView ProjectImage;
        TextView ProjectName;

        public ViewHolder(View view){
            super(view);
            projectView=view;
            ProjectImage=(ImageView)view.findViewById(R.id.project_image);
            ProjectName=(TextView)view.findViewById(R.id.project_name);
        }
    }

    public ProjectAdapter(List<ProjectItem> ProjectList){
        mProjectList=ProjectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.projectView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                ProjectItem project=mProjectList.get(position);
                Project.actionStart(view.getContext(),project.id);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        ProjectItem project=mProjectList.get(position);
        holder.ProjectImage.setImageResource(project.getImageId());
        holder.ProjectName.setText(project.getName());
    }
    @Override
    public int getItemCount(){
        return mProjectList.size();
    }
}
