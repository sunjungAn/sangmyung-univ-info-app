package com.example.myapplication;

public class simpleUserInfo {
    private String name;
    private String uid;
    private String major;


    public simpleUserInfo() {}

    public simpleUserInfo(String name, String uid, String major){
        this.name = name;
        this.uid = uid;
        this.major = major;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUid(){
        return this.uid;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getMajor(){
        return this.major;
    }

    public void setMajor(String major){
        this.major = major;
    }

}
