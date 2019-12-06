<%--
  Created by IntelliJ IDEA.
  User: ziyingfeng
  Date: 2019/12/6
  Time: 2:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h2><%= request.getSession().getAttribute("user") %>,欢迎回来=7=！</h2>
</body>
</html>
