package com.czm127.basic.redMoneyDemo;


public class begin {
    public static void main(String[] args) {
        RedMoney redMoney = new RedMoney("JAVA发红包练习");
        redMoney.setOwnerName("紫影锋");
        // 普通红包
        OpenMode normalModel = new NormalModel();
        OpenMode randomModel = new RandomModel();
        redMoney.setOpenWay(randomModel);
    }
}
