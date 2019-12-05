package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("id", "23");
        // setMaxAge 存活时间 整数是秒数  负数代表默认值关闭浏览器就消失  0 代表删除
        cookie.setMaxAge(10);

        // 设置cookie 获取范围  "/" 设置为根目录：服务器所有项目都可以共享
        cookie.setPath("/");

        // 不同服务器共享    love.czm127.com  faith.czm127.com  hope.czm127.com 都可共享
        cookie.setDomain(".czm127.com");

        // 发送 cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
