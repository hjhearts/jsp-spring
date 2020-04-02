<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="file1" value="${param.param1}"/>
    <c:set var="file2" value="${param.param2}"/>
    매개변수 1 : <c:out value="${file1}"/><br/>
    매개변수 2 : <c:out value="${file2}"/><br/>
    <c:if test="${not empty file1}">
        <img src="${contextPath}/download.do?fileName=${file1}" width="300" height="300" alt="${file1}"/><br/>
    </c:if>
    <br/>
    <c:if test="${not empty file2}">
        <img src="${contextPath}/download.do?fileName=${file2}" width="300" height="300" alt="${file2}"/><br/>
    </c:if>
    <br/>
    <a href="${contextPath}/download.do?fileName=${file1}">파일 1 내려받기</a>
    <a href="${contextPath}/download.do?fileName=${file2}">파일 2 내려받기</a>
</body>
</html>
