package com.czm127.basic.redMoneyDemo;

import java.util.ArrayList;

public class NormalModel implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        // 平均金额
        int avg = totalMoney / totalCount;
        // 多余金额
        int mod = totalMoney % totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        // 有多余金额就放在最后的红包里
        list.add(mod + avg);
        return list;
    }
}
