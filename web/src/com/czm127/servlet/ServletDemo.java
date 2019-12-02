package com.czm127.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {

//  因为是单例 Servlet会有安全问题，尽量不要在servlet中定义成员变量，如果定义了不要修改值


    /**
     * 初始化 只执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init@@");
    }

    // 获取Servlet 配置
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 每一次访问Servlet执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet is ok");
    }

    // 获取Servlet 信息
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁之前执行 可释放资源
     * 在服务器关闭时 执行一次
     */
    @Override
    public void destroy() {
        System.out.println("销毁鸟");
    }
}
