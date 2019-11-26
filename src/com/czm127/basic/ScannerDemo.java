package com.czm127.basic;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // System.in 从键盘输入
        Scanner sc = new Scanner(System.in);
        // 获取键盘输入的int数字 和字符串
        // System.out.println(sc.nextInt());
        // System.out.println(sc.next());

        // 获取键盘输入两个数字 并求和
        System.out.println("请输入两个数字");
        System.out.println(sc.nextInt()+sc.nextInt());

        // 输入三次数字 求最大值
        System.out.println("请输入三个数字，程序自动计算最大值");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int maxNum;
        maxNum = Math.max(num1, num2);
        maxNum = Math.max(maxNum, num3);
        System.out.println("三个数字最大值为："+maxNum);

        sc.nextInt();
    }
}
