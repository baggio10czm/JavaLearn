package com.czm127;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginDemo")
public class LoginDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request 编码
        request.setCharacterEncoding("utf-8");

        // 得到参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        // 先判断验证码
        HttpSession session = request.getSession();
        String session_checkCode = (String) session.getAttribute("checkCode");

        // 用完一次就删除session验证码
        session.removeAttribute("checkCode");

        // 验证码验证，不区别大小写
        if(session_checkCode != null && session_checkCode.equalsIgnoreCase(checkCode)){
            if("czm".equals(username) && "123".equals(password)){
                // 将用户名存入session
                session.setAttribute("user", username);
                // 转发到登录页面
                response.sendRedirect(request.getContextPath() + "/success.jsp");

            }else {
                request.setAttribute("login_error", "用户or密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("checkCode_error", "验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
