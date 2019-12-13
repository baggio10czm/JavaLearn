package com.czm127.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterProcess implements Filter {
    public void destroy() {
        // 服务器正常关闭, 支持销毁
        // 可用于释放资源
        System.out.println("filter 销毁了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 对 request 对象处理
        System.out.println("放行前");
        chain.doFilter(req, resp);
        // 对 Response 对象处理
        System.out.println("放行后");
    }

    public void init(FilterConfig config) throws ServletException {
        // 可用于加载资源
        System.out.println("filter init");
    }

}
