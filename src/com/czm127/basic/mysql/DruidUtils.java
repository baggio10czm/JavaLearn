package com.czm127.basic.mysql;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;

    static {
        Properties pro = new Properties();
        try {
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void  close(Statement stmt, Connection conn){
        // if(stmt != null){
        //     try {
        //         stmt.close();
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        // }

        // if(conn != null){
        //     try {
        //         conn.close();
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        // }
        close(null, stmt, conn);
    }

    public static void  close(ResultSet res,Statement stmt, Connection conn){
        if(res != null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 获取池
    public static DataSource getDataSource(){
        return ds;
    }
}
