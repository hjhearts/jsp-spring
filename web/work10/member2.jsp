<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>${memberList[0].id}</td>
            <td>${memberList[0].pwd}</td>
            <td>${memberList[0].name}</td>
            <td>${memberList[0].email}</td>
        </tr>
        <tr>
            <td>${memberList[1].id}</td>
            <td>${memberList[1].pwd}</td>
            <td>${memberList[1].name}</td>
            <td>${memberList[1].email}</td>
        </tr>
    </table>
</body>
</html>
