package com.example.usejson;

/**
 * Created by yls on 2019/3/20.
 */

public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Student(String name, int age, String stuNo) {
        this.name = name;
        this.age = age;
        this.stuNo = stuNo;
    }

    private String name;
    private int age;
    private String stuNo;
}
