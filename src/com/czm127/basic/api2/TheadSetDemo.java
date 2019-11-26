package com.czm127.basic.api2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池
public class TheadSetDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new RunnableExecutorImpl());
        es.submit(new RunnableExecutorImpl());
        es.submit(new RunnableExecutorImpl());

        // 关闭线程池，一般不使用
        // es.shutdown();
    }
}

class RunnableExecutorImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}