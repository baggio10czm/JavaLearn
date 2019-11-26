package com.czm127.basic.api2;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

// 递归
public class RecursiveDemo {
    public static void main(String[] args) {
        // 求和
        System.out.println(sum(3));
        // 阶乘
        System.out.println(factorial(5));

        // 遍历所有文件夹 和 文件
        // traversing(new File("/Users/ziyingfeng/JAVA/Learn/basic-code/src"));

        // 搜索所有.java 文件
        // search(new File("/Users/ziyingfeng/JAVA/Learn/basic-code/src"));

        // 用过滤器搜索所有 .java文件
        // searchByFilter(new File("/Users/ziyingfeng/JAVA/Learn/basic-code/src/com/czm127/basic"));

        searchByFilter5(new File("/Users/ziyingfeng/JAVA/Learn/basic-code/src/com/czm127/basic"));
    }
    // 求和
    private static int sum(int n) {
        if(n == 1) return 1;
        return n + sum(n-1);
    }
    // 阶乘
    private static int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
    // 遍历所有文件夹和文件
    private static void traversing(File dir){
        System.out.println(dir);
        File[] files = dir.listFiles(); // 返回 File 才能用后面 .isDirectory 判断是否是文件夹
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                traversing(file);
            }else {
                System.out.println(file);
            }
        }
    }
    // 搜索遍历只要.java 文件
    private static void search(File dir){
        File[] files = dir.listFiles(); // 返回 File 才能用后面 .isDirectory 判断是否是文件夹
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                search(file);
            }else {
                // 得到文件名 并转换为小写
                String name = file.getName().toLowerCase();
                // 判断后缀名是.java 就打印
                if(name.endsWith(".java")) System.out.println("search："+name);
            }
        }
    }

    // 用过滤器实现搜索.java功能
    private static void searchByFilter(File dir) {
        File[] files = dir.listFiles(new FileFilterImpl2()); // 返回 File 才能用后面 .isDirectory 判断是否是文件夹
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                searchByFilter(file);
            }else {
                System.out.println("search::"+file);
            }
        }
    }

    // 匿名内部类 -
    // 用过滤器实现搜索.java功能
    private static void searchByFilter2(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
            }
        }); // 返回 File 才能用后面 .isDirectory 判断是否是文件夹
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                searchByFilter(file);
            }else {
                System.out.println("search::"+file);
            }
        }
    }

    // Lambda 更简化
    private static void searchByFilter3(File dir) {
        File[] files = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java"));
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                searchByFilter(file);
            }else {
                System.out.println("search::"+file);
            }
        }
    }
    // FilenameFilter
    private static void searchByFilter4(File dir) {
        File[] files = dir.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        }); // 返回 File 才能用后面 .isDirectory 判断是否是文件夹
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                searchByFilter(file);
            }else {
                System.out.println("search::"+file);
            }
        }
    }

    // FilenameFilter Lambda 简化
    private static void searchByFilter5(File dir) {
        File[] files = dir.listFiles((dir1, name) -> new File(dir1,name).isDirectory() || name.toLowerCase().endsWith(".java"));
        assert files != null;
        for (File file : files) {
            // 如果是文件夹递归调用遍历文件夹
            if(file.isDirectory()){
                searchByFilter(file);
            }else {
                System.out.println("search::"+file);
            }
        }
    }

}


class FileFilterImpl2 implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()) {
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".java");
    }
}