<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" import="java.util.*, myweb2.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<c:set var="memberList" value="${memberList}"/>
<html>
<head>
    <title>회원 리스트</title>
</head>
<body>
    <h2>UserList</h2>
    <table>
        <tr>
            <th>아이디</th>
            <th>패스워드</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일자</th>
        </tr>
        <c:if test="${not empty memberList}">
            <c:forEach items="${memberList}" var="mem">
                <tr>
                    <td>${mem.id}</td>
                    <td>${mem.pwd}</td>
                    <td>${mem.name}</td>
                    <td>${mem.email}</td>
                    <td>${mem.joinDate}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>
