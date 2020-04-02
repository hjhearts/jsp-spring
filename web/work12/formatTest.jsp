<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>fmt의 number 태그</h2>
    <c:set var="price" value="100000000"/>
    <fmt:formatNumber value="${price}" type="number" var="priceNumber"/>
    통화로 표현시 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="￦"
            groupingUsed="true"/><br/>
    퍼센트로 표현시 : <fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/><br/>
    일반 숫자로 표현 시 : <c:out value="${priceNumber}"/><br/>
    <h2>formatDate</h2>
    <c:set var="now" value="<%=new Date()%>"/>
    <fmt:formatDate value="${now}" type="date" dateStyle="full"/><br/>
    <fmt:formatDate value="${now}" type="date" dateStyle="short"/><br/>
    <fmt:formatDate value="${now}" type="time"/><br/>
    <fmt:formatDate value="${now}" type="both" timeStyle="full"/><br/>
    <fmt:formatDate value="${now}" pattern="YYYY-MM-dd hh:mm:ss.SSS"/><br/>
    <br/><br/>
    한국 현재 시간 :
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
    <fmt:timeZone value="America/New York">
        뉴욕 현재 시간 :
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
    </fmt:timeZone>
</body>
</html>
