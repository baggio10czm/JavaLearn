package com.czm127.basic;

import java.util.ArrayList;
import java.util.Random;

public class ArrayLIstDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("游戏");
        list.add("足球");
        // .add 返回添加结果
        System.out.println("添加结果："+(list.add("电影")?"成功":"失败"));
        System.out.println(list);
        System.out.println(list.get(1));
        // .remove 返回删除元素
        System.out.println("被删的是："+list.remove(1));
        System.out.println(list.get(1));
        System.out.println(list.size());

        // 一般 ArrayList 只能放引用类型, 可用包装类保存基本类型
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(7);
        System.out.println(list2);

        // 生成并打印6个 1-7之间的随机整数集合
        ArrayList<Integer> randomIntList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            randomIntList.add(random.nextInt(7)+1);
        }
        System.out.println(randomIntList);

        // 打印4个学生对象
        ArrayList<Student> students = new ArrayList<Student>();
        Student one = new Student("杰拉德", 33);
        Student two = new Student("巴乔", 52);
        Student three = new Student("小罗", 15);
        Student four = new Student("梅西", 23);

        students.add(one);
        students.add(two);
        students.add(three);
        students.add(four);
        for (Student student : students) {
            System.out.println("姓名="+ student.getName() + "年龄=" + student.getAge());
        }

        // 打印指定集合 格式 {xxx@xxx@xxx@}
        ArrayList<String> list66 = new ArrayList<>();
        list66.add("ssm");
        list66.add("yye3");
        list66.add("ewr");
        list66.add("qqe");
        printArrayList(list66);

        // 筛选20个1-100随机数字 偶数集合
        ArrayList<Integer> bigList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            bigList.add(random.nextInt(100)+1);
        }
        System.out.println(filterArray(bigList));
    }

    // 指定格式打印集合
    private static void printArrayList(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size()-1){
                System.out.print(list.get(i)+"@");
            }else {
                System.out.print(list.get(i)+"}");
            }
        }
    }

    // 筛选20个随机数字，只取偶数
    private static ArrayList<Integer> filterArray(ArrayList<Integer> list){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                smallList.add(integer);
            }
        }
        return smallList;
    }
}
