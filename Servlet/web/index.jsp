
  Created by IntelliJ IDEA.
  User: ziyingfeng
  Date: 2019/12/2
  Time: 5:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp Demo</title>
  </head>
  <body>
  <%-- <% %> service方法可定义什么 这里就可以定义什么 --%>
  <%
    System.out.println("jsp");
    num = 99;
    String contextPath = request.getContextPath();
    out.print(contextPath);

  <%-- <%！ %> 定义语句 --%>
<%!
  int num = 11;
%>
<%-- <%= %> 输出语句 --%>
  <h3>jsp @@ <%= num %></h3>

  <% response.getWriter().write("<h1> response.getWriter().write 会在out.print 之前</h1>"); %>
  </body>
</html>
