package com.czm127.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes ={DispatcherType.REQUEST,DispatcherType.FORWARD})
// "/filterDemo"  拦截路径: /filterDemo
// "/user/*"  拦截路径: /user下所有资源
// "*.jsp"  拦截路径: 所有.jsp文件
// "/*"  拦截路径: 所有资源

/*
  拦截方式：
    dispatcherTypes：1：REQUEST（默认值）浏览器直接请求    2： FORWARD 转发访问  3： INCLUDE 包含   4：ERROR 错误跳转   5：ASYNC 异步访问
    dispatcherTypes ={DispatcherType.REQUEST,DispatcherType.FORWARD}) 就是转发+直接
 */

/*
    拦截先后顺服
        1：按照类名的字符串比较规则比较，值小的先执行
        2：web.xml配置  谁定义在上面就先执行
 */
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截成功");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
