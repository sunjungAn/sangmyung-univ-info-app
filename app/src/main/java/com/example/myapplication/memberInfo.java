package com.example.myapplication;

public class memberInfo {
    private String name;
    private String phoneNumber;
    private String studentID;
    private String major;
    private int followerNum;
    private int followingNum;

    public memberInfo() {}

    public memberInfo(boolean a){
        this.name = "NoData";
        this.phoneNumber = "NoData";
        this.studentID = "NoData";
        this.major = "NoData";
        this.followerNum = 0;
        this.followingNum = 0;
    }

    public memberInfo(String name, String phoneNumber, String studentID, String major){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.studentID = studentID;
        this.major = major;
        this.followerNum = 0;
        this.followingNum = 0;
    }

    public memberInfo(String name, String phoneNumber, String studentID, String major, int followerNum, int followingNum){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.studentID = studentID;
        this.major = major;
        this.followerNum = followerNum;
        this.followingNum = followingNum;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getMajor(){
        return this.major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setFollowerNum(int followerNum){
        this.followerNum = followerNum;
    }

    public int getFollowerNum(){ return this.followerNum;}

    public void setFollowingNum(int followingNum){
        this.followingNum = followingNum;
    }

    public int getFollowingNum(){ return this.followingNum;}



}
