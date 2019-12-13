<%--
  Created by IntelliJ IDEA.
  User: ziyingfeng
  Date: 2019/12/6
  Time: 11:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #checkCode {
        cursor: pointer;
    }
</style>
<head>
    <title>登录验证码demo</title>
    <style>
        div {
            color: red;
        }
    </style>
    <script>
        window.onload = function () {
            document.getElementById("checkCode").onclick = function () {
                this.src = "${pageContext.request.contextPath}/checkCode?time="+new Date().getTime();
            }

        }
    </script>
</head>
<body>
<%
    System.out.println(request.getContextPath());
%>
<form action="${pageContext.request.contextPath}/loginDemo" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input autocomplete="false" type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input autocomplete="false" onautocomplete="false" type="text" name="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input autocomplete="false" type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><img id="checkCode" src="${pageContext.request.contextPath}/checkCode" alt=""></td>
        </tr>
        <tr>
            <td rowspan="2"><button>登录</button></td>
        </tr>
    </table>
</form>
<div><%= request.getAttribute("login_msg")==null?"":request.getAttribute("login_msg") %></div>
<div><%= request.getAttribute("login_error")==null?"":request.getAttribute("login_error") %></div>
<div><%= request.getAttribute("checkCode_error")==null?"":request.getAttribute("checkCode_error") %></div>
</body>
</html>
