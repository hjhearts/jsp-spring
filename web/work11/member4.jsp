<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 5:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="id" value="hjs" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="" scope="page"/>
<c:set var="age" value="26" scope="page"/>
<c:set var="height" value="173" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty name}">
        <h1>이름이 올바르지 않습니다.</h1>
    </c:when>
    <c:when test="${empty id}">
        <h1>ID가 입력되지 않았습니다.</h1>
    </c:when>
    <c:otherwise>
        <h1>${id} ${pwd} ${name} ${age} ${height}</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
