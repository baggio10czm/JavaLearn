package com.czm127.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        // 1. 获取资源请求路径
        String requestURI = request.getRequestURI();
        // 判断是否包含登录相关资源路径，要注意排除css/js 图片 验证码等资源
        if(requestURI.contains("/login.jsp") || requestURI.contains("/loginServlet") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/") || requestURI.contains("/checkCode/")){
            chain.doFilter(req, resp);
        }else {
            // 读取缓存中的 user 信息
            Object user = request.getSession().getAttribute("user");
            // 判断是否登录
            if(user != null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
