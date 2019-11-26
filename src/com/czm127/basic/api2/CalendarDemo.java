package com.czm127.basic.api2;

import java.time.Month;
import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        // System.out.println(c);

        // 设置日历
        c.set(Calendar.YEAR,2017);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.DATE,26);
        // 一次性设置
        c.set(2017, Calendar.OCTOBER,26);

        // 获取日历
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DATE));

        // 增加/减少
        c.add(Calendar.YEAR, 2);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -18);

        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DATE));

        // 把日历转换成日期
        System.out.println(c.getTime());

    }
}
