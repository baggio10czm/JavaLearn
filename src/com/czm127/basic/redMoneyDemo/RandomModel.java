package com.czm127.basic.redMoneyDemo;

import java.util.ArrayList;
import java.util.Random;

public class RandomModel implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int leftMoney = totalMoney;
        int avg = leftMoney / totalCount;
        int leftCount = totalCount;
        System.out.println(avg);
        for (int i = 0; i < totalCount-1; i++) {
            // 剩下的钱 / 剩下的次数  = 平均钱数  * 2 每次随机得到的数不能大于2倍平均钱数
            int randomMoney = new Random().nextInt(leftMoney/leftCount *2) + 1;
            list.add(randomMoney);
            leftCount--;
            leftMoney = leftMoney - randomMoney;
        }
        list.add(leftMoney);
        return list;
    }
}
