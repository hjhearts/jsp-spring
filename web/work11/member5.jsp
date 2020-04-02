<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dataList" class="java.util.ArrayList"/>
<%
    dataList.add("hello");
    dataList.add("안녕하세요");
    dataList.add("xin chao");
%>
<c:set var="list" value="${dataList}" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="0" end="10" step="1" varStatus="loop">
    <p>i = ${i}, 실행 횟수 = ${loop.count}</p>
</c:forEach>
<c:forEach var="i" begin="0" end="10" step="2">
    <p>i = ${i}</p>
</c:forEach>
<c:forEach var="data" items="${list}">
    <p>data = ${data}</p>
</c:forEach>
<c:set var="fruit" value="apple, pineapple, watermelon, strawberry"/>
<c:forTokens delims="," var="data" items="${fruit}">
    <p>fruit = ${data}</p>
</c:forTokens>
</body>
</html>
