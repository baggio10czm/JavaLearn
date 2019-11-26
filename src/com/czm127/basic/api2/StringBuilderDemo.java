package com.czm127.basic.api2;

import java.util.Arrays;

public class StringBuilderDemo {
    public static void main(String[] args) {
        // string 变成  StringBuilder
        StringBuilder s = new StringBuilder("123A");
        System.out.println(s);
        StringBuilder s2 = s.append("=7="); // append 返回的是this 赋值的是地址值
        System.out.println(s==s2); // true
        System.out.println(s2.append("100"));
        System.out.println(s2.append(Arrays.toString(new int[]{10, 200})));

        s.append("=7=").append('P').append(false);
        System.out.println(s2);

        // StringBuilder 变成  string
        String s1 = s2.toString();
        System.out.println(s1);
    }
}
