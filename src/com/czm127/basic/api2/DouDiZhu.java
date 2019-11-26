package com.czm127.basic.api2;

import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        douDiZhu2();
    }
    // 无序版本
    private static void douDiZhu1(){

        ArrayList<String> pokerList = new ArrayList<>();

        String[] colors = {"♥️","♠️","♦️","♣️"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        // 制作扑克牌
        for (String number : numbers) {
            for (String color : colors) {
                pokerList.add(color + number);
            }
        }
        pokerList.add("小王");
        pokerList.add("大王");

        // 洗牌
        Collections.shuffle(pokerList);

        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            String p = pokerList.get(i);
            if( i >= 51){
                diPai.add(pokerList.get(i));
            }else if(i % 3 == 0){
                player01.add(p);
            }else if(i % 3 == 1){
                player02.add(p);
            }else {
                player03.add(p);
            }
        }

        System.out.println("玩家01："+ player01);
        System.out.println("玩家02："+ player02);
        System.out.println("玩家03："+ player03);
        System.out.println("底牌："+ diPai);
    }

    private static void douDiZhu2(){
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        List<String> colors = List.of("♠️", "♥️", "♣️", "♦️");
        List<String> numbers = List.of("2","A","K","Q","J","10","9","8","7","6","5","4","3");

        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color+number);
                pokerIndex.add(index);
                index++;
            }
        }

//        System.out.println(poker);
//        System.out.println(pokerIndex);

        // 打乱洗牌
        Collections.shuffle(pokerIndex);
        System.out.println(pokerIndex);

        ArrayList<Integer> playerOne = new ArrayList<>();
        ArrayList<Integer> playerTwo = new ArrayList<>();
        ArrayList<Integer> playerThree = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if(i >= 51){
                diPai.add(in);
            }else if(i % 3 == 0){
                playerOne.add(in);
            }else if(i % 3 == 1){
                playerTwo.add(in);
            }else {
                playerThree.add(in);
            }
        }

        // 升序排列
        Collections.sort(playerOne);
        Collections.sort(playerTwo);
        Collections.sort(playerThree);
        Collections.sort(diPai);

        // 看牌
        lookPoker("令狐冲",poker, playerOne);
        lookPoker("杨过",poker, playerTwo);
        lookPoker("洪七公",poker, playerThree);
        lookPoker("底牌",poker, diPai);

    }

    private static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> pokerIndex){
        System.out.print(name+"的：");
        for (Integer index : pokerIndex) {
            System.out.print(poker.get(index));
        }
        System.out.println();
    }
}
