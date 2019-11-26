package com.czm127.basic.api2;

import com.czm127.basic.Array;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class IODemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // ------------------------ 写入字节 ---------------------

        // 第二参数true 代表追加写，不覆盖
        FileOutputStream fos = new FileOutputStream("./IOFile/test.txt", false);
        // fos.write(97); // AscII表是 a

        // 联系写 100
        // fos.write(49);
        // fos.write(48);
        // fos.write(48);

        // 一次写多个字节  如果第一个是正数 会显示时查询ASCII表，如果是负数，那第一个字节和第二个字节组成一个中文显示，查询系统GBk
        byte[] bytes = {65,66,67,68,69}; // ABCDE
        // byte[] bytes = {-65,-66,-67,68,69};  //烤紻E
        // 后面两个参数 截取
        fos.write(bytes,1,2);
        byte[] bytes1 = "无意义".getBytes();
        System.out.println(Arrays.toString(bytes1));
        fos.write(bytes1);

        for (int i = 0; i < 7; i++) {
            fos.write("无意义".getBytes());
            // 换行
            fos.write("\r\n".getBytes());
        }

        fos.close();


        // ------------------------ 读取字节 ---------------------
        System.out.println("——————————读取文件");
        FileInputStream fis = new FileInputStream("./IOFile/test2.txt");

        // int by = fis.read();
        // System.out.println(by);
        // by = fis.read();
        // System.out.println(by);
        // by = fis.read();
        // System.out.println(by);
        // by = fis.read();
        // System.out.println(by);  // -1 代表没有数据了

        // 循环读数据
        // int len;
        // while ((len = fis.read()) != -1){
        //     System.out.print((char)len);
        // }

        // 一次读取多个，一般定义为1024 或 1024的倍数
        byte[] byArr = new byte[1024];
        // System.out.println(fis.read(byArr));  // 3
        // System.out.println(new String(byArr));  // cz

        int len2;
        while ((len2 = fis.read(byArr)) != -1) {
            System.out.println("读了字节个数："+len2);
            System.out.println(new String(byArr,0,len2));
        }
        fis.close();

        // 文件复制
        FileInputStream copyFis = new FileInputStream("./IOFile/copy.txt");
        FileOutputStream pasteFis = new FileOutputStream("./IOFile/paste.txt");
        int len3;

        // 一次读取一个字节
        // while ((len3 = copyFis.read()) != -1){
        //     pasteFis.write(len3);
        // }

        // 一次读取多个- 快的多
        byte[] bytes3 = new byte[1024];
        while ((len3 = copyFis.read(bytes3)) != -1){
            pasteFis.write(bytes3,0,len3);
        }

        // 先关闭写的，再关闭读的
        pasteFis.close();
        copyFis.close();

        // 注意读取中文 字节可能会乱码（读取不完整）


        // ------------------------ 读取字符 ---------------------
        System.out.println("——————读取字符————————");
        FileReader fr = new FileReader("./IOFile/reader.txt");
        // int len7;
        // while ((len7 = fr.read()) != -1){
        //     // (char) 把字节转换为字符
        //     System.out.print((char)len7);
        // }
        char[] chars = new char[1024];
        int len6;
        while ((len6 = fr.read(chars)) != -1){
            System.out.print(new String(chars,0,len6));
        }
        fr.close();


        // ------------------------ 写入字符 ---------------------
        System.out.println("——————读取字符————————");
        FileWriter fw = new FileWriter("./IOFile/writer.txt", false);

        // fw.write(97);
        //  刷新缓冲区 还可以继续写数据
        // fw.flush();

        //写入字符数组
        char[] cs = {'a','b','c','d','e','f'};
        fw.write(cs);
        fw.write(cs,0,3);
        fw.write("\r\n");
        fw.write("哈哈镜",0,2);
        // close 自带flush效果
        fw.close();

        // 处理IO异常 老的写法
        FileWriter fr2  = null;
        try {
            fr2 = new FileWriter("./IOFile/error.txt");
            for (int i = 0; i < 10; i++) {
                fr2.write("Czm"+i);
                fr2.write("\r\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fr2 != null){
                try {
                    fr2.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        // jdk7 新写法 可在()里写  也不用 finally     jdk9 可在()写变量就可传递进去……
        try(FileWriter fr3 =  new FileWriter("./IOFile/error.txt");
            FileInputStream fis33 =  new FileInputStream("./IOFile/error.txt");) {
            for (int i = 0; i < 10; i++) {
                fr3.write("Czm"+i);
                fr3.write("\r\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }

        // Properties 集合  Io集合
        Properties prop = new Properties();

        // 相当于map里面的 put
        prop.setProperty("巴乔","15");
        prop.setProperty("巴蒂","25");
        prop.setProperty("杰拉德","21");

        // 相当于map 的keySet 获取所有key
        Set<String> set = prop.stringPropertyNames();

        for (String key : set){
            System.out.println(key);
            // getProperty  通过key 拿值
            System.out.println(prop.getProperty(key));
        }
        // Properties  map集合数据永久储存----------
        // 字符流 可存中文
        FileWriter fw7 = new FileWriter("./IOFile/properties.txt");
        // 第一个参数是 用字符流还是字节流 ，第二参数 备注 只能写英文
        prop.store(fw7, "save test");
        fw.close();

        // 用字节流 不支持中文，会乱码
        // prop.store(new FileOutputStream("./IOFile/properties.txt"),"zi jie");

        // 读取永久储存的数据
        System.out.println("========= 读取永久储存的数据 =======");
        Properties prop2 = new Properties();
        // 同储存相同  字符流支持中文；字节流不支持中文
        prop2.load(new FileReader("./IOFile/properties.txt"));
        // prop2.load(new FileInputStream("./IOFile/properties.txt"));

        Set<String> set2 = prop2.stringPropertyNames();
        for (String key : set2){
            System.out.println(key);
            // getProperty  通过key 拿值
            System.out.println(prop.getProperty(key));
        }



        //    ------------- 字节缓冲流 BufferedOutputStream -----------------

        // 写入操作
        FileOutputStream fos7 = new FileOutputStream("./IOFile/BufferedOutputStream.txt");
        // 第二参数为 缓冲区大小，可不写
        BufferedOutputStream bos = new BufferedOutputStream(fos7);
        bos.write("abc".getBytes());
        // bos.flush();
        bos.close();

        // 读取操作
        FileInputStream fis7 = new FileInputStream("./IOFile/BufferedOutputStream.txt");
        BufferedInputStream bis = new BufferedInputStream(fis7);

        // int len78;
        // while ((len78 = bis.read()) != -1) {
        //     System.out.print((char) len78);
        // }

        byte[] bytes27 = new byte[1024];
        int len27;
        while ((len27 = bis.read(bytes27)) != -1){
            System.out.println(new String(bytes27,0,len27));
        }
        bis.close();



        //    ------------- 字符缓冲流 BufferedWriter  -----------------

        BufferedWriter bw = new BufferedWriter(new FileWriter("./IOFile/BufferedWriter.txt"));

        for (int i = 0; i < 10; i++) {
            bw.write("Czm程忠明"+i);
            // 换行
            bw.newLine();
        }
        // bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("./IOFile/BufferedWriter.txt"));

        // 读一行，没有返回null
        // String line;
        // while ((line = br.readLine()) != null){
        //     System.out.println(line);
        // }

         // 跟上面一样效果
         // int len78;
         // while ((len78 = br.read()) != -1) {
         //     System.out.print((char) len78);
         // }

        char[] bytes28 = new char[1024];
        int len28;
        while ((len28 = br.read(bytes28)) != -1){
            System.out.print(new String(bytes28,0,len28));
        }
         br.close();



        //  ---------  练习 排序文件内容
        HashMap<String, String> map = new HashMap<>();

        // 读取打乱的文件
        BufferedReader br2 = new BufferedReader(new FileReader("./IOFile/lianXi.txt"));
        // 排序后写入的文件
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("./IOFile/lianXiRes.txt"));

        String con;
        while ((con = br2.readLine()) != null){
            // 通过符号分割成数组方便分开使用
            String[] conArr = con.split("、");
            // 因为 HashMap 是有序集合，会自动排序

            map.put(conArr[0],conArr[1]);
        }
        System.out.println(map);

        for (String key : map.keySet()){
            bw2.write(key+"、"+ map.get(key));
            bw2.newLine();
        }

        br2.close();
        bw2.close();



        // =================  转换流 - 解决编码不一致乱码的问题 =======

        // 写操作
        // 第二参数是编码方式
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./IOFile/OutputStreamWriter.txt"), "GBK");
        osw.write("程慕溪");
        osw.close();

        // 读操作
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./IOFile/OutputStreamWriter.txt"),"GBK");

        // int len52;
        // while ((len52 = isr.read()) != -1){
        //     System.out.println((char) len52);
        // }
        // isr.close();

        // 小练习 把GBK文件转换成 UTF-8文件
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("./IOFile/OutputStreamWriterRes.txt"));
        int len53;
        while ((len53 = isr.read()) != -1){
            osw2.write(len53);
        }
        isr.close();
        osw2.close();




        //   ==========  序列化 与 反序列化 ========
        Person person = new Person("巴乔",192);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./IOFile/ObjectOutputStream.txt"));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./IOFile/ObjectOutputStream.txt"));
        Object p = ois.readObject();
        Person p2 = (Person) p;
        System.out.println(p2.getName());
        ois.close();

        // 小练习 集合序列化 和 反序列化
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("czm",28));
        list.add(new Person("cmx",12));
        list.add(new Person("cjq",27));
        list.add(new Person("yyy",7));

        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("./IOFile/ObjectList.txt"));
        oos2.writeObject(list);
        oos2.close();


        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("./IOFile/ObjectList.txt"));
        Object oo = ois2.readObject();
        ArrayList<Person> list2 = (ArrayList<Person>) oo;
        for (Person person1 : list2) {
            System.out.println(person1);
        }
        ois2.close();


        //  ------------  打印流 -------
        PrintStream ps = new PrintStream("./IOFile/print.txt");
        // 编码写入
        ps.write(97);   // a
        // 原样写入
        ps.println(97);   // 97

        // 改变打印的目的地
        System.setOut(ps);

        System.out.println("打印去了文件print.txt");

        ps.close();
    }
}