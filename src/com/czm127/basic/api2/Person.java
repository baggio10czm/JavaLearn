package com.czm127.basic.api2;

import java.io.Serializable;
import java.util.Objects;

// 实现 Serializable 标记接口 才能使用序列化
public class Person implements Comparable<Person>, Serializable {
    //  设死序列号，修改类以后 避免序列号不一致报错
    private static final long serialVersionUID = 1L;
    public String name;
    private int age;
    // static 静态成员不能被序列化，用transient 也是不能序列化
    // private static int age;
    // private transient int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    //重写 Object 的toString
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // @Override
    // // 自己重写
    // public boolean equals(Object obj) {
    //     if( obj == this){
    //         System.out.println("===自己比较自己，有意思吗？===");
    //         return true;
    //     }
    //     // 增加一个参数判断
    //     if(!(obj instanceof Person || obj == null)){
    //         return false;
    //     }
    //     // 使用向下转型，把obj转换为Person类型
    //     Person p = (Person) obj;
    //     // 比较两个对象的属性，一个对象数this(p1),一个对象数p(p2)
    //     // name 为字符串类型的比较，age为int类型的比较
    //     return this.name.equals(p.name) && this.age == p.age;
    // }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // getClass() != o.getClass() 使用反射技术，判断 o 是否是Person类型 等效 obj instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // Objects.equals 解决 null 报错 null不能调方法
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 重写排序规则
    @Override
    public int compareTo(Person o) {
//        return 0; // 认为元素都是相同都
        // 自定义比较规则 比较两个人都年龄
//        return this.getAge() - o.getAge();  // 升序
        return o.getAge() - this.getAge() ;  // 降序
    }

}
