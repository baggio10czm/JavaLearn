package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 解决中文乱码  主要是解决post方式
        // 设置流的编码
        request.setCharacterEncoding("UTF-8");


        // 获取请求体
        // 获取字符流
        BufferedReader reader = request.getReader();
        // 读数据
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }

        // ----------- POST GET 通用方法 --------
        // 根据参数名 获取 参数值  注意： getParameter 对于多选只能返回一个值
        System.out.println(request.getParameter("username"));
        // 根据参数名 获取 数值数组 （多选）
        System.out.println(Arrays.toString(request.getParameterValues("username")));

        // 获取所有参数名 枚举
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            // 根据名称获取请求头的值
            String value = request.getParameter(name);
            System.out.println(name+"="+value);
            System.out.println("-------");
        }

        // 获取所有参数值的map集合
        final Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String name : strings) {
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-----------");
        }

        // 请求转发处理  特点：url没有变化、只能转发当前服务器内部资源、http只有一次请求、
        request.getRequestDispatcher("/RequestDemo2").forward(request, response);
        // 多个资源共享数据
        request.setAttribute("id","1001");
        request.getAttribute("id");
        request.removeAttribute("id");


        // getServletContext 对象
        System.out.println(request.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方法
        System.out.println(request.getMethod());
        // 获取虚拟目录
        System.out.println(request.getContextPath());
        // 获取Servlet路径
        System.out.println(request.getServletPath());
        // 获取get参数
        System.out.println(request.getQueryString());
        // 获取Uri
        System.out.println(request.getRequestURI());
        // 获取UrL
        System.out.println(request.getRequestURL());
        // 获取客户ip
        System.out.println(request.getRemoteAddr());


        // 获取搜索请求头
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            // 根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+"="+value);
        }

        // 一般使用 直接使用 request.getHeader() 获取请求头信息
        String agent = request.getHeader("user-agent");
        if(agent.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if(agent.contains("FireFox")){
            System.out.println("是火狐");
        }else {
            System.out.println("是什么浏览器？");
        }

        // 请求头数据 referer 来源
        String referer = request.getHeader("referer");
        System.out.println(referer);
    }
}
