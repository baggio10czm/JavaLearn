package com.czm127.basic.api2;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 路径分隔符
        System.out.println(File.pathSeparator);
        // 文件分隔符
        System.out.println(File.separator);

        // 创建文件
        System.out.println(new File("JAVA/Learn/basic-code/basic-code.iml"));
        // 父路径 + 子路径 组合
        System.out.println(new File("JAVA/Learn/basic-code", "src"));
        // 父路径（File对象） + 子路径 组合
        System.out.println(new File(new File("JAVA/Learn/basic-code"), "src"));

        File file = new File("/Users/ziyingfeng/JAVA/Learn/basic-code/basic-code.iml");
        File file2 = new File("/Users/ziyingfeng/JAVA/Learn/basic-code/src");
        File file3 = new File("/Users/ziyingfeng/JAVA/Learn/basic-code/=7=");

        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());

        // 获取文件大小   不存在就是0
        System.out.println(file.length());
        System.out.println(file2.length());
        System.out.println(file3.length());

        // 获取文件路径
        System.out.println(file.getPath());
        System.out.println(file2.getPath());

        // 文件名
        System.out.println(file.getName());
        System.out.println(file2.getName());

        // 判断是否存在
        System.out.println(file.exists());
        System.out.println(file2.exists());
        System.out.println(file3.exists());

        // 判断是否是文件 or 文件夹
        System.out.println(file.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file3.isFile());  // 不存在的就是false，可先判断是否存在

        // 文件操作
        System.out.println("创建文件结果：" + file.createNewFile()); // 如果创建的路径不存在就会报IOException错
        // 删除失败or里面有内容 就返回false
        // System.out.println("删除文件or文件夹结果："+file.delete());
        // mkdir、mkdirs创建文件夹失败or已经存在 返回false
        // System.out.println("创建单级文件夹结果："+file2.mkdir());
        // System.out.println("创建单级or多级文件夹结果："+file2.mkdirs());

        //文件夹遍历  遍历文件会返回null
        System.out.println(Arrays.toString(file2.list()));  // 返回 String[]
        System.out.println(Arrays.toString(file2.listFiles()));  // 返回 File[]

        // 使用 FileFilterImpl过滤器,得到 .DS_Store 结尾的文件
        System.out.println(Arrays.toString(file2.listFiles(new FileFilterImpl())));
    }
}

class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".DS_Store");
    }

}