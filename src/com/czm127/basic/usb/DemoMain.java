package com.czm127.basic.usb;

public class DemoMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        // 开机
        computer.powerOn();

        // 准备一个鼠标，供电脑使用
//        Mouse mouse = new Mouse();
        USB usbMouse =  new Mouse();
        computer.useDevice(usbMouse);

        // 创建一个usb键盘
        Keyboard keyboard = new Keyboard();
        // computer.useDevice(new Keyboard()); // 向上转型
        computer.useDevice(keyboard); // 向上转型

        // 关机
        computer.powerOff();
    }
}
