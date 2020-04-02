<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="score" value="${param.score}" scope="page"/>
    <c:choose>
        <c:when test="${score >= 0 && score <= 100}">
            <c:choose>
                <c:when test="${score >= 90}">
                    <h1>A학점</h1>
                </c:when>
                <c:when test="${score >= 80}">
                    <h1>B학점</h1>
                </c:when>
                <c:when test="${score >= 70}">
                    <h1>C학점</h1>
                </c:when>
                <c:when test="${score >= 60}">
                    <h1>D학점</h1>
                </c:when>
                <c:otherwise>
                    <h1>F학점</h1>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <h1>점수를 잘못입력했습니다. INVALID SCORE</h1>
            <a href="scoreTest.jsp">다시 입력</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
