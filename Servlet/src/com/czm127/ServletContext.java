package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContent")
public class ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 两种获得ServletContext 方式
        System.out.println(request.getServletContext());

        javax.servlet.ServletContext servletContext = this.getServletContext();

        // getMimeType 获取MIME类型
        String filename = "aa.jpg";
        System.out.println(servletContext.getMimeType(filename));  //image/jpeg

        // 共享数据 一般不使用（因为是所有用户共享）
        servletContext.setAttribute("test","=7=");
        servletContext.getAttribute("test");
        servletContext.removeAttribute("test");

        // 获取文件真实服务器路径
        String realPath = servletContext.getRealPath("/config.text");
        String realPath2 = servletContext.getRealPath("/src/config.text");
        System.out.println(realPath);
        System.out.println(realPath2);

        File file = new File(realPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
