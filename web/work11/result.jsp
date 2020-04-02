<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${empty param.id}">
        <c:redirect url="login.jsp">
            <c:param name="isErr" value="true"/>
        </c:redirect>
    </c:if>
    <c:if test="${not empty param.id}">
        <c:if test="${param.id eq 'admin'}">
            <h2>HELLO ADMIN this is ADMIN PAGE</h2>
        </c:if>
        <h2>HELLO ${param.id}</h2>
    </c:if>
</body>
</html>
