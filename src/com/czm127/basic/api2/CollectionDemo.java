package com.czm127.basic.api2;

import com.czm127.basic.Student;

import java.util.*;

// Collection 集合顶层，共有下面的方法
public class CollectionDemo {
    public static void main(String[] args) {
        //  使用多态，有序集合，可有重复
//        Collection<String> coll = new ArrayList<>();
        // HashSet不能有重复的，无序集合
        Collection<String> coll = new HashSet<>();
        System.out.println(coll);

        System.out.println(coll.add("张思"));  // 一般add都是添加成功 返回true
        coll.add("利物浦");
        coll.add("安菲尔德");

        // 删除成功 返回true，失败（没有这个元素）就返回false
        System.out.println(coll.remove("张思"));
        System.out.println(coll.remove("888"));

        System.out.println("=======contains 判断对象是否存在=====");
        // contains 判断对象是否存在
        System.out.println(coll.contains("安菲尔德"));
        System.out.println(coll.contains("888"));

        System.out.println(coll.size());
        System.out.println(coll.isEmpty());

        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        coll.clear();
        System.out.println(coll.isEmpty());


        // Iterator 迭代器 是一个接口 （对集合遍历）
        // hasNext()   next()
        System.out.println("===== Iterator 迭代器 =========");
        Collection<String> list = new ArrayList<>();

        list.add("巴乔");
        list.add("杰拉德");
        list.add("程忠明");
        list.add("马内");

        Iterator<String> it = list.iterator();

        boolean bl = it.hasNext();

        // if(bl) {
        //     System.out.println(it.next());
        // }
//
        // bl = it.hasNext();
        // if(bl) {
        //     System.out.println(it.next());
        // }
//
        // bl = it.hasNext();
        // if(bl) {
        //     System.out.println(it.next());
        // }
//
        // bl = it.hasNext();
        // if(bl) {
        //     System.out.println(it.next());
        // }
//
        // bl = it.hasNext();
        // if(bl) {
        //     System.out.println(it.next());
        // }else {
        //     System.out.println("没有了");
        // }

        // 重复代码 用 while 简化
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // 还可以用 for
        for(Iterator<String> it2 = list.iterator(); it2.hasNext();){
            System.out.println(it2.next());
        }

        // for增强  遍历 （不能增删）（只能是 Collection 或 数组）
        System.out.println("===== 增强for ======");
        for (String l:list) {
            System.out.println(l);
        }

        // addAll
        ArrayList<String> listAll = new ArrayList<>();
        Collections.addAll(listAll,"2s","52","as","wq","wr");
        System.out.println(listAll);

        // shuffle
        System.out.println("===== 打乱 重洗牌 ======");
        Collections.shuffle(listAll);
        System.out.println(listAll);

        // sort 排序
        ArrayList<Integer> listInt = new ArrayList<>();
        Collections.addAll(listInt,1,3,4,2,5,12,22,33);
        Collections.sort(listInt);
        System.out.println(listInt);

        // 自定义排序
        Person p1 = new Person("紫影锋",12);
        Person p2 = new Person("李大齐",31);
        Person p3 = new Person("麦积山",133);
        ArrayList<Person> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        System.out.println(pList);
        // 排序要实现 compareTo 接口 。。。重写
        Collections.sort(pList);
        System.out.println(pList);

        // comparator 排序  o1- o2 = 升序  o2 - o1 = 降序
        ArrayList<Integer> listInt2 = new ArrayList<>();
        Collections.addAll(listInt2,1,3,4,2,5,12,22,33);
        Collections.sort(listInt2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        });
        System.out.println(listInt2);


        Student stu33 = new Student("学生紫影锋",32);
        Student stu22 = new Student("学生李大齐",36);
        Student stu11 = new Student("b学生",28);
        Student stu44 = new Student("a学生",28);
        ArrayList<Student> pList2 = new ArrayList<>();
        pList2.add(stu33);
        pList2.add(stu22);
        pList2.add(stu11);
        pList2.add(stu44);
        System.out.println(pList2);

        Collections.sort(pList2, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 相比较年龄 升序
                int result = o1.getAge() - o2.getAge();
                // 如果年龄相同，再使用姓名都第一个字比较
                if(result == 0){
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(pList2);
    }
}
