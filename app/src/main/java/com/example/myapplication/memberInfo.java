package com.example.myapplication;

public class memberInfo {
    private String name;
    private String phoneNumber;
    private String studentID;
    private String major;

    public memberInfo() {}

    public memberInfo(String name, String phoneNumber, String studentID, String major){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.studentID = studentID;
        this.major = major;
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

}
