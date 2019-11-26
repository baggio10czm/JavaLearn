package com.czm127.test;

import com.czm127.basic.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法
     * 所有方法执行之前执行
     */
    @Before
    public void init(){
        System.out.println("begin");
    }

    /**
     * 结束方法
     * 所有方法执行之后执行
     */
    @After
    public void close(){
        System.out.println("end");
    }

    /**
     * 测试加法
     */
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 3);
        Assert.assertEquals(4,result);
    }

    /**
     * 测试减法
     */
    @Test
    public void testSub(){
        Calculator calculator = new Calculator();
        int result = calculator.sub(56, 3);
        Assert.assertEquals(53,result);
    }
}
