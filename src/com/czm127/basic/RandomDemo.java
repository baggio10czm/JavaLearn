package com.czm127.basic;


import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
    public static void main(String[] args) {

        Random r = new Random();
        int num = r.nextInt();
        System.out.println(num);
        // 7参数控制范围  0-6
        int num2 = r.nextInt(7);
        System.out.println(num2);

        // 获取输入数字n的随机数 范围为[1,n]
        // System.out.println("输入一个数字n得到 1-n的随机数");
         Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // System.out.println(r.nextInt(n)+1);

        // 猜数字游戏
        int winNum = r.nextInt(100) + 1; //数字范围1-100
        int maxTimes = 7; // 最多可猜7次

        while (true){
            maxTimes --;
            System.out.println("输入猜的数字");
            int guessNum = sc.nextInt();

            if(maxTimes == 0){
                System.out.println("loser"+winNum);
                break;
            }
            if(guessNum > winNum){
                System.out.println("猜大了");
            }else if(guessNum < winNum) {
                System.out.println("猜小了");
            }else {
                System.out.println("bingo");
                break;
            }
        }
    }
}
