package com.czm127.basic.api2;


public class EqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("罗伯特巴乔",43);
        Person p2 = new Person("范巴斯滕",52);
        Person p3 = new Person("罗伯特巴乔",43);

        System.out.println(p1);
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p1));
        System.out.println(p1 == null);
    }
}
