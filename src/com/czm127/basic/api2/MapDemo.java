package com.czm127.basic.api2;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        show01();
        bianLi1();
        bianLi2();

        customize();
        linkedHashMap();
        hashtable();

        countString();
    }
    private static void show01(){
        Map<String,String> map = new HashMap<>();
        String m1 = map.put("球员1","巴乔");
        map.put("球员2","巴蒂斯图塔");
        map.put("球员3","梅西");
        map.put("球员4","哀伤");
        // 添加都key 不存在返回null
        System.out.println(m1);  // null
        // key存在 覆盖value 返回被覆盖都value
        System.out.println(map.put("球员3","杰拉德"));  // 梅西
        System.out.println(map);
        System.out.println(map.remove("球员4"));  // 哀伤
        System.out.println(map.get("球员1"));  // 巴乔
        System.out.println(map.containsKey("球员2"));  // true
        System.out.println(map.containsValue("梅西"));  // false
    }
    private static void bianLi1(){

        Map<String,String> map = new HashMap<>();
        map.put("球员1","巴乔");
        map.put("球员2","巴蒂斯图塔");
        map.put("球员3","梅西");
        map.put("球员4","哀伤");

        // 取所有key
        Set<String> set = map.keySet();

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            String value = map.get(key);
            System.out.println(key + "值是" + value);
        }

        System.out.println("===========");

        // 遍历所有key
        for (String s : set) {
            System.out.println(s + "值是" + map.get(s));
        }

    }

    private static void bianLi2(){

        System.out.println("===== Entry 对象遍历 ======");
        Map<String,String> map = new HashMap<>();
        map.put("球员1","巴乔");
        map.put("球员2","巴蒂斯图塔");
        map.put("球员3","梅西");
        map.put("球员4","哀伤");
        Set<Map.Entry<String, String>> set = map.entrySet();

        Iterator<Map.Entry<String, String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "值是" + value);
        }

        System.out.println("===========");

        for (Map.Entry<String, String> s : set) {
            System.out.println(s.getKey() + "值是" + map.get(s.getValue()));
        }
    }

    private static void customize(){

        Map<String,Person> map = new HashMap<>();
        map.put("桂林", new Person("立水桥",19));
        map.put("南宁", new Person("咯奇葩",27));
        map.put("柳州", new Person("维奇",26));
        map.put("杭州", new Person("霸王",18));
        map.put("杭州", new Person("老霸王",39));
        // 这样不需重写 Person里都 hashcode 和 equals
        System.out.println(map);

        System.out.println("======== 对象做为key ==========");
        // 对象做为key 需要重写 hashcode 和 equals
        Map<Person,String> map2 = new HashMap<>();
        map2.put(new Person("立水桥",19), "桂林");
        map2.put(new Person("万花筒",25), "火影");
        map2.put(new Person("离开我",37), "破位");
        map2.put(new Person("万花筒",25), "宇智波");

        Set<Map.Entry<Person, String>> entries = map2.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    private static void linkedHashMap(){
        // 有序都 和 不许重复key
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a",112);
        map.put("b",23);
        map.put("d",58);
        map.put("c",178);
        System.out.println(map);
    }

    private static void hashtable(){
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "142");
        map.put(null, null);
        map.put("swq", null);
        System.out.println(map);

        // 老的，Hashtable 不能存null的值和key
        Hashtable<String, String> hashtable = new Hashtable();
        // hashtable.put(null, "1");  // java.lang.NullPointerException
        // hashtable.put("012", null);  // java.lang.NullPointerException
        // hashtable.put(null, "1");    // java.lang.NullPointerException
        hashtable.put("12--", "1");    // java.lang.NullPointerException
        System.out.println(hashtable);
    }

    // 获取用户输入的字符串，计算每个字符出现的次数
    private static void countString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("------ 输入字符:");
        String str = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                Integer value = map.get(c);
                map.put(c,++value);
            }else {
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}
