package com.czm127;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servletDownload")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");

        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/images/" + filename);

        // 用字节流关联
        final FileInputStream fileInputStream = new FileInputStream(realPath);

        // 解决中文文件名问题
        // 获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        // 设置响应头
        response.setHeader("content-type", mimeType);
        // 获取用户浏览器信息
        String agent = request.getHeader("user-agent");
        // 使用工具类 编码文件名
        // filename = DownloadUtils.getFileName(agent, filename);

        // 设置响应头
        response.setHeader("content-type", servletContext.getMimeType(filename));
        response.setHeader("content-disposition","attachment;filename="+filename);

        // 将输入流写出到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff, 0, len);
        }
        fileInputStream.close();
        outputStream.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
