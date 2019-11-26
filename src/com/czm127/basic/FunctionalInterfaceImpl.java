package com.czm127.basic;

import com.czm127.basic.api2.FunctionalInterfaceDemo;

public class FunctionalInterfaceImpl implements FunctionalInterfaceDemo {
    @Override
    public void method() {
        System.out.println("FunctionalInterfaceImpl 实现接口");
    }
}
