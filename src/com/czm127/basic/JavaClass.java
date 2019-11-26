package com.czm127.basic;

public class JavaClass {
    private String name;
    private int age;
    private static String room = "10020教室";

    // 无参数构造
    public JavaClass() {
    }

    // 全参数构造
    public JavaClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
