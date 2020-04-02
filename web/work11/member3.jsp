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
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${true}">
    <h1>항상 TRUE 입니다.</h1>
</c:if>
<c:if test="${11 eq 11}">
    <h1>두 값은 같습니다.</h1>
</c:if>
<c:if test="${11 ne 31}">
    <h1>두 값은 다릅니다.</h1>
</c:if>
<c:if test="${(id == 'hong') && (name eq '홍길동')}">
    <h1>아이디는 ${id}이고 이름은 ${name}입니다.</h1>
</c:if>
<c:if test="${height >= 160}">
    <h1>키는 160보다 큽니다</h1>
</c:if>
</body>
</html>
