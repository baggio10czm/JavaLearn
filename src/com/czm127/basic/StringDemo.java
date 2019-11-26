package com.czm127.basic;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "CzM";
        String str2 = "CzM";
        char[] charArray = {'C','z','M'};
        String str3 = new String(charArray);

        // equals 比较字符串是否相等
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str3.equals(str1));
        System.out.println("CzM".equals(str1));
        System.out.println("Czm".equals(str2));

        // equalsIgnoreCase 忽略大小写
        System.out.println("czm".equalsIgnoreCase(str2));

        System.out.println(str1.length());
        System.out.println(str1.concat(" yyy"));
        System.out.println(str1.charAt(2));
        System.out.println(str1.indexOf('z'));
        System.out.println(str1.substring(0,1));
        System.out.println(str1.substring(1));

        System.out.println("==== toCharArray =====");
        char[] sss = str1.toCharArray();
        System.out.println(sss);
        System.out.println(Arrays.toString(str1.getBytes()));
        System.out.println(str1.replace("CzM","Yyy"));

        String str33 = "CCz,ssX,ssqW";
        // split 参数为正则 所以英文标号比如 "." 要写成 "\\."
        System.out.println(Arrays.toString(str33.split(",")));

        // 练习1  把数组{1,2,3} 变成 [word1#word2#word3]
        int[] intArray = {1,2,3};
        System.out.println(fromArrayToString(intArray));

        //练习2

        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串");

        String input = sc.next();

        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        char[] charInput = input.toCharArray();
        for (char ch : charInput) {
            if('A' <= ch && ch <= 'Z'){
                countUpper++;
            }else if('a' <= ch && ch <= 'z'){
                countLower++;
            }else if( '0' <= ch && ch <= '9'){
                countNumber++;
            }else {
                countOther++;
            }

        }
        System.out.println("大写:"+countUpper+"个，小写:"+countLower+"个，数字:"+countNumber+"个，其他:"+countOther+"个");

    }

    private static String fromArrayToString(int[] intArray){
        String strRes = "";
        strRes = strRes.concat("[");
        for (int i = 0; i < intArray.length; i++) {
         if(i < intArray.length-1){
             strRes = strRes.concat("word"+intArray[i]+"#");
         }else {
             strRes = strRes.concat("word"+intArray[i]+"]");
         }
        }
        return strRes;
    }

}
