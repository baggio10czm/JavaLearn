package com.czm127.basic;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("你好，czm");
        System.out.println(89);
        System.out.println(-9.81);
        System.out.println(21L);
        System.out.println('6');
        System.out.println("null");

        int num = 1;
        num++;
        System.out.println(num);

        float num1 = 1F;
        num1++;
        System.out.println(num1);


        float num00 = 112422786896967L;
        System.out.println(num00);

        double num2;
        num2 = 6;
        num2++;
        System.out.println(num2);

        byte num3;
        num3 = 126;
        System.out.println(num3);

        short num4;
        num4 = 1822;
        System.out.println(num4);

        char char01 = 'C';
        System.out.println(char01);

        {
            System.out.println(num4);
        }

        int ffll = 30;
        System.out.println(ffll);

        float num7 = (int) 30;
        System.out.println(ffll);


        double num8 = (int) 3.7;
        System.out.println(num8);

        // 不写 (byte) 也可以 会自动补上 强行转 int
        byte by = (byte) 112;
        System.out.println(by);

        // 错误 变量不能编译器优化
        short a = 5;
        short b = 5;
        // short + short --> int + int = int 不是 short
//        short res2 = a + b;
        int res2 = a + b;

        // 正确 常量可以编译器优化，编译前就已经计算好了
        short res3 = 5 + 6;
        System.out.println(res3);
    }
}
