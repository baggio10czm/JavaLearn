package com.czm127.basic.api2;

public class ThreadDemo {
    public static void main(String[] args) {
        // Thread 第一种多线程实现方法
        // fun1();

        // Runnable 第二种多线程实现方法
        //fun2();

        // Thread匿名方式1
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 230; i++) {
                    System.out.println(Thread.currentThread().getName() + "Thread匿名" + i + "---->");
                }
            }
        }.start();

        // Runnable匿名方式
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 30; i++) {
                            System.out.println(Thread.currentThread().getName() + "Runnable匿名" + i + "---->");
                        }
                    }
                }
        ).start();

        // 主方法执行的代码
        for (int i = 0; i < 230; i++) {
            System.out.println("main ---> " + i);
        }
    }

    private static void fun2() {
        // 使用 Runnable 接口来实现多线程，比较灵活，不受单继承的局限，扩展性更好，降低程序耦合性
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();
    }

    private static void fun1() {
        // 创建多线程 程序
        MyThread mt = new MyThread();
        // 开启新线程，start 调用run方法
        // 用 start 会开辟新的栈空间运行run ，直接run 不会开辟新的栈空间就是单线程
        mt.start();
        // new MyThread().start();
        // new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // 获取线程名称
        String name = getName();
        System.out.println(name); // Thread-0

        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 30; i++) {
            System.out.println("run" + i);
            // try {
            // 暂停程序毫秒数，暂停结束继续执行
            //     sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}