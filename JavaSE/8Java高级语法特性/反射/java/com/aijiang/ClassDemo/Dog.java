package com.aijiang.ClassDemo;

import java.io.Serializable;

public class Dog implements Serializable {

    private static final long serialVersionUID = -2849831858169198753L;

    private String name;
    private Integer age;
    private String gender;

    public Dog() {
    }

    /**
     * 一个普通的方法
     */
    public void run() {
        System.out.println("汪汪汪，跑跑跑");
    }

    @Override
    public String toString() {
        return "com.aijiang.ClassDemo.Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}

