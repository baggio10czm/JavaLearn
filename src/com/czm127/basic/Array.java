package com.czm127.basic;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // 动态初始化,可拆分
        int[] intArr = new int[10];
        double[] doubleArr = new double[10];
        String[] stringArr = new String[10];
        String[] stringArr2;
        stringArr2 = new String[10];

        // 静态初始化,可拆分
        int[] jtArr1 = new int[]{1, 3, 4, 5};

        String[] staticArr2 = new String[]{"Czm", "YYY", "CMX", "CJQ"};
        System.out.println(staticArr2.length);

        int[] jtArr3;
        jtArr3 = new int[]{1, 13, 4, 15,12};
        // Arrays.sort 升序排练
        Arrays.sort(jtArr3);
        System.out.println(Arrays.toString(jtArr3));

        // 省略初始化,不可拆分
        int[] omitArray = {2,4,67};
        System.out.println(omitArray); // 打印的是内存地址值 [I@5d3411d
        System.out.println(omitArray[2]); // 打印数组某个值
        System.out.println(Arrays.toString(omitArray)); // 打印整个数组

        // 打印 , 动态数组默认值：int为0 ，浮点为0.0 ,字符为'\u0000' ，布尔为false ，引用类型为null
        int[] array = new int[3];

        System.out.println(Arrays.toString(array));
        System.out.println(array[1]);
        System.out.println(array[2]=123);
        System.out.println(array[0]);


        // 遍历
        int[] intArray = {2,56,71,25,22,88};

        for (int value : intArray) {
            System.out.println(value);
        }

        // 求最大
        int[] maxArray = {2,1,3,11,22,55,23};
        int maxValue = maxArray[0];
        for (int i = 1; i < maxArray.length; i++) {
            if(maxArray[i] > maxValue){
                maxValue = maxArray[i];
            }
        }
        System.out.println(maxValue);

        // 反转数组
        String[] strArr = {"Cam","1wqs","las","lsm","mms","qoo","loq"};
        String tmp = "";
        for (int i = 0; i < strArr.length; i++) {
            if(i >= strArr.length-i-1){
                break;
            }
            tmp = strArr[i];
            strArr[i] = strArr[strArr.length-i-1];
            strArr[strArr.length-i-1] = tmp;
        }
        System.out.println(Arrays.toString(strArr));

        // 随机字符串升序排练，并倒序打印
        String randomStr = "ASFmsZxqWtEqiKi124925";

        char[] randomStrArr = randomStr.toCharArray();
        Arrays.sort(randomStrArr);
        for (int i = randomStrArr.length - 1; i >= 0; i--) {
            System.out.println(randomStrArr[i]);
        }

    }
}