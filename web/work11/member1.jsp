<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 4:46
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
            <td>${param.id}</td>
            <td>${param.pwd}</td>
            <td>${param.name}</td>
            <td>${param.email}</td>
        </tr>
    </table>
</body>
</html>
