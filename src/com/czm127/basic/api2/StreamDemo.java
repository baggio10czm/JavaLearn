package com.czm127.basic.api2;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // 把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> s2 = set.stream();

        Map<String, String> map = new HashMap<>();
        // 获取键，储存到一个Set集合
        Set<String> ketSet =  map.keySet();
        Stream<String> s3 = ketSet.stream();

        // 获取值，储存到一个Collection集合
        Collection<String> values = map.values();
        Stream<String> s4 = values.stream();

        // 获取键值对（键与值到映射关系 entrySet）
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> s5 = entries.stream();

        // 数组
        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        Integer[] arr = {1,4,2,5,6,7};
        final Stream<Integer> arr1 = Stream.of(arr);
        String[] arr2 = {"a","ss"};
        final Stream<String> arr21 = Stream.of(arr2);

        // Stream 流只能使用一次，不能重复使用 ！！！
        // Stream forEach 遍历流中数据，终结方法
        Stream<String> stream1 = Stream.of("杰拉德", "梅西");
        stream1.forEach(System.out::println);

        // Stream filter 过滤返回一个新的流，可链式
        Stream<String> stream2 = Stream.of("巴乔", "巴蒂斯图塔", "杰拉德", "梅西");
        stream2.filter((String name)-> name.startsWith("巴")).forEach(System.out::println);

        // Stream map 遍历返回一个新的流，可链式
        Stream<String> stream3 = Stream.of("1", "2", "3", "4");
        stream3.map(Integer::parseInt).forEach(System.out::println);

        // count 统计个数 终极方法
        System.out.println("一共有："+Stream.of("1", "2", "3").count());

        // limit截取个数   ==   flutter纠结
        Stream.of("flutter", "纠结", "难搞").limit(2).forEach(System.out::print);
        // skip跳过个数  ==   难搞     ps:跳过了就返回空的流
        Stream.of("flutter", "纠结", "难搞").skip(2).forEach(System.out::println);

        Stream.concat(Stream.of("flutter", "纠结", "难搞").limit(2),Stream.of("flutter", "纠结", "难搞").skip(2)).forEach(System.out::print);
        System.out.println();

        // 小练习
        ArrayList<String> oneArr = new ArrayList<>();
        oneArr.add("巴乔");
        oneArr.add("巴蒂");
        oneArr.add("杰拉德");
        oneArr.add("梅西");
        oneArr.add("罗纳尔迪尼奥");
        oneArr.add("因扎吉");
        oneArr.add("大罗");
        oneArr.add("范迪克");
        oneArr.add("马内");


        ArrayList<String> twoArr = new ArrayList<>();
        twoArr.add("范巴斯");
        twoArr.add("范迪克");
        twoArr.add("范尼");
        twoArr.add("苏牙");
        twoArr.add("内马尔");
        twoArr.add("哈维");

        Stream<String> oneStream = oneArr.stream();
        Stream<String> twoStream = twoArr.stream();

        Stream<String> newOneStream = oneStream.filter((String name)-> name.length() == 2).limit(3);
        Stream<String> newTwoStream = twoStream.filter((String name)-> name.startsWith("范")).skip(1);
        Stream<String> newAllStream  = Stream.concat(newOneStream, newTwoStream);

        // ArrayList<Person> personList = new ArrayList<>();
        newAllStream.map(name -> new Person(name,12)).forEach(System.out::println);
    }
}
