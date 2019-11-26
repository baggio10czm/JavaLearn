package com.czm127.basic;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-100));  // 100
        System.out.println(Math.ceil(56.1));   // 57.0
        System.out.println(Math.floor(56.9));    // 56.0
        System.out.println(Math.round(56.5));   // 57
        System.out.println(Math.PI);   // 57

        // 求 -10.8 到 5.9 之间绝对值大于6 或小于2.1到整数有多少个
        double max = 5.9;
        double min = -10.8;
        int count = 0;

        // (int) min 也可换成 Math.ceil 向上取整 -10.8 = -10
        for (int i = (int) min; i < max; i++) {
            int abs = Math.abs(i);
            if(abs > 6 || abs< 2.1){
                count++;
            }
        }
        System.out.println(count);
    }
}
