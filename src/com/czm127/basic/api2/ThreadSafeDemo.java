package com.czm127.basic.api2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDemo {
    public static void main(String[] args) {
        MyRunnableImpl run = new MyRunnableImpl();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}

class MyRunnableImpl implements Runnable {
    private int ticket = 100;
    private static int staticTicket = 100;

    private final Object obj = new Object();

    // 使用Lock 方式 来解决多线程安全问题（推荐）
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            // 同步代码块 解决多线程安全问题；obj 用 this也可以保证唯一就行
            // synchronized (obj){
            //     if (ticket> 0){
            //         try {
            //             Thread.sleep(10);
            //         } catch (InterruptedException e) {
            //             e.printStackTrace();
            //         }
            //         System.out.println(Thread.currentThread().getName()+"---->卖了第"+ticket+"张票");
            //         ticket--;
            //     }
            // }

            // 同步方法 解决多线程安全问题
            // payTicket();

            // 使用Lock 解决多线程安全问题
            lockFun();
        }
    }

    private void lockFun(){
        lock.lock();
        if (ticket> 0){
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName()+"---->卖了第"+ticket+"张票");
                ticket--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 这样保证程序不管什么结果 都会释放锁
                lock.unlock();
            }
        }
    }

    // 同步方法 解决多线程安全问题 + synchronized
    // 其实用第锁对象是 this 等于调用方
    private synchronized void payTicket(){
        if (ticket> 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->卖了第"+ticket+"张票");
            ticket--;
        }
    }

    // 静态锁方法 锁对象为 RunnableImpl.class
    private static synchronized void staticPayTicket(){
        if (staticTicket> 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->卖了第"+staticTicket+"张票");
            staticTicket--;
        }
    }

    // lock锁 解决多线程安全问题
}
