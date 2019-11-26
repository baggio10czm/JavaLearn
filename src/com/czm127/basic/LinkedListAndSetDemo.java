package com.czm127.basic;

import java.util.*;

public class LinkedListAndSetDemo {
    public static void main(String[] args) {
        // LinkedList 查询慢，增删改快  ArrayList相反
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("b2");
        linkedList.add("cc");

        System.out.println(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println(linkedList);

        if (!linkedList.isEmpty()) {
            System.out.println(linkedList.get(0));
            linkedList.addFirst("=7=");
            System.out.println(linkedList.getFirst());
        }
        HashSet();
        hash();
        linkedHashSet();
        System.out.println(canChange("2个数总和:", 1, 3));
        System.out.println(canChange("3个数总和:", 3, 11,3));
    }

    private static void HashSet() {
        // HashSet 无序，不许重复
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(7);
        set.add(8);
        set.add(8); // 不能存储重复数据

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            System.out.println(n);
        }
        for (Integer n : set) {
            System.out.println(n);
        }
    }

    // 哈希值
    private static void hash() {
        String str = "111";
        System.out.println(str.hashCode());
    }

    private static void linkedHashSet() {
        // linkedHashSet 有序，不许重复
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("aas");
        linked.add("baas");
        linked.add("ddd");
        linked.add("ddd");
        linked.add("ew");
        System.out.println(linked);
    }

    // 方法-可变参数， 如果有多个参数，可变参数必须写在末尾，只能有一个可变参数
    private static int canChange(String str, int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(str);
        return sum;
    }
}
