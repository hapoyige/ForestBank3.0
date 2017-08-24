package com.example.oct.forestbank;

/**
 * Created by Oct on 2017/8/23.
 * 供用户投资的项目类
 * 目前一个项目仅包含一张图和一段文字说明
 */

public class InvestProject {
    private String name;
    private int imageId;
    public InvestProject(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
