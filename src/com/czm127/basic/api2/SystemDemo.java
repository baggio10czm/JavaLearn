package com.czm127.basic.api2;

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            if(i % 100 == 0) System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时毫秒："+(end-begin));

        // 拷贝数组 用a前三元素 覆盖b前三
        int[] a = {1,2,3,4,5};
        int[] b = {81,39,180,4,5};
        System.arraycopy(a,0,b,0,3);
//        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
