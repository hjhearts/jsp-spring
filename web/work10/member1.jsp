<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table style="text-align: center">
        <tr>
            <td><%=id%></td>
            <td><%=pwd%></td>
            <td><%=name%></td>
            <td><%=email%></td>
        </tr>
        <tr>
            <td>${param.id}</td>
            <td>${param.pwd}</td>
            <td>${param.name}</td>
            <td>${param.email}</td>
        </tr>
    </table>
</body>
</html>
