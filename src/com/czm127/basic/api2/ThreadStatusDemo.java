package com.czm127.basic.api2;

// 线程状态
public class ThreadStatusDemo {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();

        new BaoZiPu(bz).start();
        new ChiHuo(bz).start();

    }

    //简单demo
    private static void sDemo() {
        Object obj = new Object();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("顾客1：老板我要榴莲包三个");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客1：付款！拿走包子，走人～～");
                        System.out.println("--------完成一单---------");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("顾客2：老板我要榴莲包三个");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客2：付款！拿走包子，走人～～");
                        System.out.println("--------完成一单---------");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        try {
                            obj.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("老板：包子做好了，请付款");
                        // obj.notify(); 随机唤醒一个
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }

}

class BaoZi {
    String pi;
    String xian;
    Boolean hasOne = false;
}

class BaoZiPu extends Thread {
    private final BaoZi bz;
    private int count = 1;

    BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.hasOne) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count % 2 == 1) {
                    bz.pi = "蛤蟆皮";
                    bz.xian = "自然馅";
                } else {
                    bz.pi = "左轮皮";
                    bz.xian = "金枪馅";
                }
                count++;

                System.out.println("正在做" + bz.pi + bz.xian + "的包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.hasOne = true;
                bz.notify();
                System.out.println("包子做好了，付款拿走");
            }
        }
    }
}

class ChiHuo extends Thread {
    private final BaoZi bz;

    ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (!bz.hasOne) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("某吃货在吃" + bz.pi + bz.xian + "包子");
                bz.hasOne = false;
                bz.notify();
                System.out.println("=======吃完了,老板再来一个=======");
            }
        }
    }

}
