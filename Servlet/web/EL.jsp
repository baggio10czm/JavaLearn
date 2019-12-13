<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ziyingfeng
  Date: 2019/12/9
  Time: 5:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%-- isELIgnored 是否忽略 EL表达式 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL</title>
</head>
<body>

<%-- 单独忽略 EL表达式用 "\" --%>
\${ 1 > 2 }: ${ 1 > 2}

<h3>EL运算符</h3>
\${ 1 + 2 }: ${ 1 + 2}
<hr>
\${ 10 % 2 }: ${ 1 % 2}
<hr>
\${ 10 / 2 }: ${ 10 / 2}
<hr>
\${ 3 * 2 }: ${ 3 * 2}

<h3>EL比较运算符</h3>

\${ 1 == 2 }: ${ 1 == 2}
<hr>
\${ 1 != 2 }: ${ 1 != 2}
<hr>
\${ 1 == 2 || 11 > 10}: ${ 1 == 2 || 11 > 10}
<hr>
\${ empty }: ${ 1 == 2 || 11 > 10}

<%--    获取值优先找request --%>
<%
    session.setAttribute("name","cmx");
    request.setAttribute("name","czm");
    session.setAttribute("age","32");

    List<String> list = new ArrayList<String>();
    list.add("czm");
    list.add("cmx");
    list.add("yyy");
    list.add("cjq");

    request.setAttribute("list", list);

    Map<String, String> map = new HashMap<>();
    map.put("name", "程忠明");
    map.put("age", "34");
    map.put("faith", "基督");

    request.setAttribute("map", map);
    %>

<h3>EL 获取值 没有的就返回 空</h3>
\${requestScope.name}: ${requestScope.name}
<hr>
\${sessionScope.age}: ${sessionScope.age}
<hr>
\${sessionScope.noHave}: ${sessionScope.noHave}
<hr>
\${name}: ${name}

<h3>EL 集合取值</h3>
\${list[0]}：${list[0]}，
\${list[1]}：${list[1]}，
\${list[2]}：${list[2]}，
\${list[11]}：${list[11]}
<br>

<%-- . 和 [] 方式都可以 --%>
\${map.name}: ${map.name},
\${map.age}: ${map.age},
\${map["faith"]}: ${map["faith"]},


<h3> empty 运算符  是否为null 或者长度为0</h3>

<%
    String str = "";
    request.setAttribute("str", str);
%>

\${ not empty str }: ${ not empty str }
\${ empty str}: ${ empty str }

<h3>动态获取虚拟目录</h3>
\${ pageContext.request.contextPath}: ${ pageContext.request.contextPath}

</body>
</html>
