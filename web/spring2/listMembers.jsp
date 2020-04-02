<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-01
  Time: 오전 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>아이디</th>
            <th>패스워드</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일자</th>
        </tr>
        <c:forEach var="member" items="${membersList}">
            <tr>
                <td>${member.id}</td>
                <td>${member.pwd}</td>
                <td>${member.name}</td>
                <td>${member.email}</td>
                <td>${member.joinDate}</td>
            </tr>
        </c:forEach>
    </table>
<a href="${pageContext.request.contextPath}/member/memberForm.do">회원가입</a>
</body>
</html>
