package com.example.oct.forestbank;

/**
 * Created by Oct on 2017/9/14.
 */

public class ProjectItemGroup {


    public String id;
    private String projectName;
    private int status=0;
    //0 for active,1 for done,2 for failed

    public ProjectItemGroup(String projectName,int status){
        this.projectName=projectName;
        this.status=status;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
