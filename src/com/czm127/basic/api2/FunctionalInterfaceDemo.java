package com.czm127.basic.api2;

import com.czm127.basic.Array;
import com.czm127.basic.FunctionalInterfaceImpl;

import java.util.Arrays;
import java.util.Comparator;

// 函数式接口：有且只有一个抽象方法的接口
// @FunctionalInterface 注释可以检测是否为函数式接口
@FunctionalInterface
public interface FunctionalInterfaceDemo {
    public abstract void method();
    // void method2();
}

class Demo1 {
    private static void show(FunctionalInterfaceDemo myInter){
        myInter.method();
    }

    private static Comparator<String> getComparator(){
        // return new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o2.length() - o1.length();
        //     }
        // };

        // lambda 表达式
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
        // 方法参数是一个接口实现类对象
        show(new FunctionalInterfaceImpl());

        // 方法参数是匿名内部类
        show(new FunctionalInterfaceDemo() {
            @Override
            public void method() {
                System.out.println(7);
            }
        });

        // 方法参数是lambda 表达式
        show(() -> System.out.println(12));

        String[] arr = {"asz","qeADEyes1122","ws12z","12","C"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
