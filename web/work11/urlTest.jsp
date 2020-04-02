<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:url var="url1" value="/work11/member1.jsp">
    <c:param name="id" value="hong"/>
    <c:param name="pwd" value="1234"/>
    <c:param name="name" value="홍길동"/>
    <c:param name="email" value="hong@test.com"/>
</c:url>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${url1}">회원정보 출력</a>
</body>
</html>
