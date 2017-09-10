package com.example.oct.forestbank;

/**
 * Created by Oct on 2017/8/23.
 * 供用户投资的项目类
 * 目前一个项目仅包含一张图和一段文字说明
 */

public class ProjectItem {
    private String name;
    private int imageId;
    public String id;
    public ProjectItem(String name, int imageId,String ID){
        this.name=name;
        this.imageId=imageId;
        this.id=ID;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
