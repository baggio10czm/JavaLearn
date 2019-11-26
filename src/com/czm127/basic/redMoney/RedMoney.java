package com.czm127.basic.redMoney;

import java.util.ArrayList;

public class RedMoney {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 1000);

        Member one = new Member("成员a",0);
        Member two = new Member("成员b",0);
        Member three = new Member("成员c",0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("===========");
        System.out.println("开始发红包");
        System.out.println("===========");


        ArrayList<Integer> redMoneyList = manager.send(200, 3);
        one.receive(redMoneyList);
        two.receive(redMoneyList);
        three.receive(redMoneyList);
        manager.show();
        one.show();
        two.show();
        three.show();

    }
}
