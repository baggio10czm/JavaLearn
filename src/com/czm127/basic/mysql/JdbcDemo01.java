package com.czm127.basic.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 导入jar包
            // 注册驱动 mysql5以后可省略
            Class.forName("com.mysql.jdbc.Driver");

            // 获取数据库连接对象
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");

            // 定义SQL语句
            String sql = "update account set balance = 500 where id = 1";

            // 获取执行sql对对象 Statement
            // 不知道为什么报错先注释
            // stmt = conn.createStatement();

            // 执行更新sql
            int count = stmt.executeUpdate(sql);

            // 影响数据个数
            System.out.println(count);


        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }finally {
            // 释放资源
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 释放资源
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
