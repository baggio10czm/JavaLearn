package com.czm127.basic.api2;

public class PackageDemo {
    public static void main(String[] args) {
        Integer ini01 = 1;
        Integer ini02 = Integer.valueOf("3");
        Integer ini03 = Integer.valueOf("7");
        System.out.println(ini01);
        System.out.println(ini02);
        System.out.println(ini03);

        // int 转换 string
        System.out.println(ini01 + "str");
        // int 转换 string
        String ini022 = ini02.toString()+"000";
        System.out.println("ak"+ini022);
        // int 转换 string
        String ini033 = String.valueOf(200);
        System.out.println(ini033+1012);
        System.out.println(ini02.toString().replace("3","=7="));

        // string 转 int
        int int001 = Integer.parseInt(ini033);
        System.out.println(int001-30);

    }
}
