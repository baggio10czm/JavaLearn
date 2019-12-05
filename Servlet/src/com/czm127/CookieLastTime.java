package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieLastTime")
public class CookieLastTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        final Cookie[] cookies = request.getCookies();
        boolean hasLastTime = false;

        final Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date_str = simpleDateFormat.format(data);
        // 因为Cookie 不支持空格所以要用URl编码转一下
        date_str = URLEncoder.encode(date_str, "utf-8");

        if(cookies != null){
            for (Cookie cookie: cookies){
                if(cookie.getName().equals("lastTime")){
                    hasLastTime = true;
                    cookie.setValue(date_str);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    // 输出到页面需要解码
                    date_str = URLDecoder.decode(date_str, "utf-8");
                    System.out.println("解码后："+date_str);

                    response.getWriter().write("<h3>上次来的时间为："+ date_str +"</h3>");
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || !hasLastTime){
            System.out.println("第一次访问");
            Cookie cookie = new Cookie("lastTime", date_str);
            response.addCookie(cookie);
            response.getWriter().write("<h3>你好！第一次过来啊</h3>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
