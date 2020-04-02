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
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${22}" scope="page"/>
<c:set var="height" value="${177}" scope="page"/>
<c:remove var="age"/>
<c:remove var="height"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>${id}</td>
        <td>${pwd}</td>
        <td>${name}</td>
        <td>${age}</td>
        <td>${height}</td>
    </tr>
</table>
</body>
</html>
