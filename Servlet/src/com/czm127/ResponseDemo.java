package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo")
public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo1-----");
        // 设置状态码 302
        // response.setStatus(302);
        // 重定向
        // response.setHeader("location", "/Servlet_war_exploded/responseDemo2");

        // 重定向简写形式 特点：地址栏变化、可访问其他服务器资源、两次请求（不能通过request共享数据）
        // 相对路径
        // response.sendRedirect("responseDemo2");

        // 绝对路径 (用动态虚拟路径)
        // String contextPath = request.getContextPath();
        // response.sendRedirect(contextPath +"/responseDemo2");

        // ---------------- response 输出 -------------

        // 先设置默认编码
        // response.setCharacterEncoding("utf-8");

        // 一定要告诉浏览器用同样编码
        // response.setHeader("content-type", "text/html;charset=utf-8");

        // 简写形式
        response.setContentType("text/html;charset=utf-8");


        // ----------------字符输出流--------------

        // 获取字符输出流 response 默认编码是 ISO-8859-1 拉丁编码
        // final PrintWriter writer = response.getWriter();
        // writer.write("<h1>=7=<h1><p>我是谁？我在那里？</p>");


        // ----------------字节输出流--------------
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("<h2>字节输出流</h2>".getBytes());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
