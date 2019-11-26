package com.czm127.basic.redMoney;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> redMoneyList){
        int randomIndex = new Random().nextInt(redMoneyList.size());
        int delta = redMoneyList.remove(randomIndex);
        int money = super.getMoney();

        super.setMoney(delta + money);
    }

}
