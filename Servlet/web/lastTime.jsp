<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: ziyingfeng
  Date: 2019/12/5
  Time: 4:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");

    final Cookie[] cookies = request.getCookies();
    boolean hasLastTime = false;

    final Date data = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    String date_str = simpleDateFormat.format(data);
    // 因为Cookie 不支持空格所以要用URl编码转一下
    date_str = URLEncoder.encode(date_str, "utf-8");

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastTime")) {
                hasLastTime = true;
                cookie.setValue(date_str);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);

                // 输出到页面需要解码
                date_str = URLDecoder.decode(date_str, "utf-8");
                System.out.println("解码后：" + date_str);
%>
<h3>上次来的时间为 <%= date_str %></h3>
<%
                break;
            }
        }
    }

    if (cookies == null || cookies.length == 0 || !hasLastTime) {
        System.out.println("第一次访问");
        Cookie cookie = new Cookie("lastTime", date_str);
        response.addCookie(cookie);
        %>

        <h3>你好！第一次过来啊</h3>
<%
    }
%>
</body>
</html>
