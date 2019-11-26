package com.czm127.basic.redMoney;


import java.util.ArrayList;

//
public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count){
        ArrayList<Integer> redMoneyList = new ArrayList<>();

        int leftMoney = super.getMoney();
        if(leftMoney < totalMoney){
            System.out.println("余额不足！");
            return redMoneyList;
        }
        super.setMoney(leftMoney-totalMoney);

        int oneMoney = totalMoney / count;
        int moreMoney = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            redMoneyList.add(oneMoney);
        }

        redMoneyList.add(oneMoney + moreMoney);

        return redMoneyList;
    }
}
