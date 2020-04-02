<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="myweb2.MemberBean" scope="page"/>
<jsp:setProperty name="bean" property="*"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td><%=bean.getId()%></td>
            <td><%=bean.getPwd()%></td>
            <td><%=bean.getName()%></td>
            <td><%=bean.getEmail()%></td>
        </tr>
        <tr>
            <td>${bean.id}</td>
            <td>${bean.pwd}</td>
            <td>${bean.name}</td>
            <td>${bean.email}</td>
        </tr>
    </table>
</body>
</html>
