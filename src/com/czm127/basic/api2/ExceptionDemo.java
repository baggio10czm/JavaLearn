package com.czm127.basic.api2;

import java.io.IOException;
import java.util.Scanner;

class CustomizeException {

    private static String[] usernameList = {"紫影锋","巴乔","杰拉德","马内"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        checkUsername(username);
    }

    private static void checkUsername(String username){
        for (String name : usernameList) {
            if(name.equals(username)){
                throw new RegisterException("用户名已经存在");
            }
        }
        System.out.println("可注册！");
    }
}

class ExceptionDemo {
    public static void main(String[] args) {
        String fileName = "c://aaa.tx1";
        try {
            readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally = 无视错误，必定要执行的");
        }
    }

    private static void readFile(String fileName) throws IOException {
        if(!fileName.endsWith(".txt")){
            throw new IOException("文件后缀名不对！");
        }
        System.out.println("OK。。。");
    }

}

// 自定义异常类   一般是继承 Exception or RuntimeException
class RegisterException extends RuntimeException {
    // 添加一个空参数构造方法
    public RegisterException(){

    }
    // 添加一个带异常信息带构造方法
    RegisterException(String message){
        super(message);
    }
}

