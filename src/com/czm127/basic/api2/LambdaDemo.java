package com.czm127.basic.api2;


import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        // 创建多线程 比较
        // new Thread(
        //         new Runnable() {
        //             @Override
        //             public void run() {
        //                     System.out.println(Thread.currentThread().getName() + " 匿名内部类方式");
        //             }
        //         }
        // ).start();

        // 使用 Lambda 表达式实现多线程，比匿名更简单
        // new Thread(() -> System.out.println(Thread.currentThread().getName() + " Lambda 表达式")).start();

        //匿名内部类实现
        invokeCook(new Cook() {
            @Override
            public void makeCook() {
                System.out.println("匿名内部类，实现一下Cook接口");
            }
        });

        // Lambda实现
        invokeCook(()-> System.out.println("Lambda 实现一下Cook接口"));


        // 小练习
        Person[] arr = {
                new Person("巴乔", 51),
                new Person("巴蒂", 47),
                new Person("巴雷西", 62),
        };

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, (Person o1, Person o2) -> {return o1.getAge() - o2.getAge();});
        // Arrays.sort(arr, Comparator.comparingInt(Person::getAge));
        System.out.println(Arrays.toString(arr));


        // 小练习

        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        invokeCalc(120, 130, (int a, int b) -> {return a + b;});
        //  简写
        invokeCalc(120, 130, (a, b) ->  a + b);
        invokeCalc(120, 130, Integer::sum);
    }
    private static void invokeCook(Cook cook){
        cook.makeCook();
    }
    private static void invokeCalc(int a, int b, Calculator c){
        System.out.println(c.calc(a,b));
    }
}

interface Cook {
    public abstract void makeCook();
}

interface Calculator {
    public abstract int calc(int a, int b);
}