package com.czm127.basic.api2;

import java.util.List;
import java.util.Map;
import java.util.Set;

// 只能List Set  Map接口 只能对集合元素个数确定才能用of，所以不能add remove
public class JDK9ListOf {
    public static void main(String[] args) {
        // 不能添加，删除
        List<String> list = List.of("a","11","ss");
        System.out.println(list);

        // Set 不能有重复元素 不能添加，删除
        Set<Integer> set = Set.of(1,32,24,56,7);
        System.out.println(set);

        // Map 不能有重复元素 不能添加，删除
        Map<String, String> map = Map.of("球员1", "巴乔","球员2", "巴蒂斯塔");
        System.out.println(map);

    }
}
