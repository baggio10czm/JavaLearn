<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%-- pageEncoding="utf-8" 设置编码 如果不是高级编辑器需要这样设置 errorPage="" 设置发生错误时显示的页面  isErrorPage="" 可用exception对象  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%-- jsp注释 被注释的内容无法在html看到 --%>
<html>
  <head>
    <title>jsp Demo</title>
  </head>
  <body>
  <%
    List list = new ArrayList<>();
    //  isErrorPage="true"  后，可用exception
    String message = exception.getMessage();
    out.print(message);
  %>
  <%-- <% %> service方法可定义什么 这里就可以定义什么 --%>

  <%
    System.out.println("jsp");
    num = 99;
    String contextPath = request.getContextPath();
    out.print(contextPath);

    pageContext.setAttribute("test","001");
    System.out.println(pageContext.getAttribute("test"));
  %>

  <%-- <%！ %> 定义语句 --%>
<%!
  int num = 11;
%>
<%-- <%= %> 输出语句 --%>
  <h3>jsp @@ <%= num %></h3>

  <% response.getWriter().write("<h1> response.getWriter().write 会在out.print 之前</h1>"); %>

  </body>
</html>
