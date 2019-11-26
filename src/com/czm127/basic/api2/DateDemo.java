package com.czm127.basic.api2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class DateDemo {
    public static void main(String[] args) throws ParseException {

        // 到现在的 总毫秒数
        System.out.println(System.currentTimeMillis());

        System.out.println(new Date());

        test();
        dateFormat();

        // 计算出生日期到现在有多少天
        countDay();
    }

    private static void countDay() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入出生日期：格式：yyyy-MM-dd");
        String birthdayDateString = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long birthday = dateFormat.parse(birthdayDateString).getTime();
        long currentDay = new Date().getTime();
        System.out.println(currentDay - birthday);
        System.out.println((currentDay - birthday) / 1000 / 60 / 60 / 24);

    }

    private static void dateFormat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.parse("2019年11月07日 17时17分39秒"));
        System.out.println(dateFormat.parse("2019年11月07日 17时17分39秒").getTime());
    }

    private static void test() {
        Date date = new Date(0L);
        System.out.println(date);
        Date date2 = new Date();
        System.out.println(date2.getTime());
    }


}
